import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {
  public regBtnNotClickable: boolean;
  public registrationForm: FormGroup;

  constructor(private requestMaker: RequestMaker, private formBuilder: FormBuilder, private router: Router) {
    this.regBtnNotClickable = false;
    this.registrationForm = this.formBuilder.group({
      name: ["", [Validators.required]],
      surname: ["", [Validators.required]],
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
        .registrationRequest(this.registrationForm.value)
        .subscribe(
          null,
          err => {
            if (err.status === 409)
              alert('Vec postoji korisnik sa datom email adresom!');
            else
              alert('Registracija nije bila uspesna, proverite unete podatke!');
          },
          () => {
            alert('Registracija je uspesno obavljena!');
            this.router.navigate(['/login']);
          }
        );
    }
    
    this.regBtnNotClickable = false;
  }
}
