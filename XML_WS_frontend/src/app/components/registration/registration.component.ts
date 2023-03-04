import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { Router } from '@angular/router';
import { XMLParser } from 'src/app/utils/XMLParser';
import { CLIENT_LOGIN_URL } from 'src/app/configs/client-urls';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {
  public regBtnNotClickable: boolean;
  public registrationForm: FormGroup;

  constructor(private requestMaker: RequestMaker, private formBuilder: FormBuilder, 
              private router: Router, private xmlParser: XMLParser) {
    this.regBtnNotClickable = false;
    this.registrationForm = this.formBuilder.group({
      firstname: ["", [Validators.required]],
      lastname: ["", [Validators.required]],
      email: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required, Validators.minLength(5), Validators.maxLength(30)]],    
      passwordRep: ["", [Validators.required]]
    });
  }

  ngOnInit(): void {}

  onRegistrationSubmit(): void {
    this.regBtnNotClickable = true;
    
    if (this.registrationForm.invalid || this.registrationForm.value.password !== this.registrationForm.value.passwordRep)
      alert("Unete lozinke se ne poklapaju!");
    else {
      this.requestMaker
        .registrationRequest(this._getRegDTOAsXML())
        .subscribe({
          error: (err: any) => {
            if (err.status === 409)
              alert('Vec postoji korisnik sa datom email adresom!');
            else
              alert('Registracija nije bila uspesna, proverite unete podatke!');
          },
          complete: () => {
            alert('Registracija je uspesno obavljena!');
            this.router.navigate([CLIENT_LOGIN_URL]);
          }
        });
    }
    
    this.regBtnNotClickable = false;
  }

  _getRegDTOAsXML(): any {
    const formData = this.registrationForm.value;
      
    const reqBody = {
      firstname: { _text: formData.firstname }, 
      lastname: { _text: formData.lastname }, 
      email: { _text: formData.email }, 
      password: { _text: formData.password }
    };
    return this.xmlParser.parseToXml("RegistrationDTO", reqBody);
  }

}
