import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginBtnNotClickable: boolean;
  public loginForm: FormGroup;

  constructor(private requestMaker: RequestMaker, private formBuilder: FormBuilder, private router: Router) {
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
        .loginRequest(this.loginForm.value)
        .subscribe(
          null,
          err => {
            if (err.status === 404)
              alert('Uneti podaci nisu tacni, molimo vas pokusajte ponovo!');
          },
          () => {
            alert('Logovanje je USPESNO!');
            //this.router.navigate(['/login']);
          }
        );
    }

    this.loginBtnNotClickable = false;
  }

}
