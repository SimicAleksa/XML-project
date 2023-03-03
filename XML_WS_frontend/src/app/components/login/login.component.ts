import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { Router } from '@angular/router';
import { XMLParser } from 'src/app/utils/XMLParser';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginBtnNotClickable: boolean;
  public loginForm: FormGroup;

  constructor(private requestMaker: RequestMaker, private formBuilder: FormBuilder, 
              private router: Router, private xmlParser: XMLParser, private lStorageManager: LocalStorageManager) {
    this.loginBtnNotClickable = false;
    this.loginForm = this.formBuilder.group({
      email: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required, Validators.minLength(5), Validators.maxLength(30)]],    
    });
   }

  ngOnInit(): void {}

  onLoginSubmit(): void {
    this.loginBtnNotClickable = true;

    if (this.loginForm.invalid)
      alert("Uneti podaci nisu tacni, molimo vas pokusajte ponovo!");
    else {
      this.requestMaker
        .loginRequest(this._getLoginDTOAsXML())
        .subscribe({
          next: (retData: any) => {
            if (retData.body !== undefined) {
              let resData = this.xmlParser.parseFromXml(retData.body).AuthTokenDTO;
              this.lStorageManager.setAuthToken(resData.authToken);
              this.lStorageManager.setUserRole(resData.role);
            }
          },
          error: (err: any) => {
            if (err.status === 404 || err.status === 401)
              alert('Uneti podaci nisu tacni, molimo vas pokusajte ponovo!');
          },
          complete: () => {
            alert('Logovanje je USPESNO!');
            //this.router.navigate(['/login']);
          }
        });
    }

    this.loginBtnNotClickable = false;
  }

  _getLoginDTOAsXML(): any {
    const formData = this.loginForm.value;
      
    const reqBody = {
      email: { _text: formData.email }, 
      password: { _text: formData.password }
    };
    return this.xmlParser.parseToXml("LoginDTO", reqBody);
  }
}
