import { Component, OnInit } from '@angular/core';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { XMLParser } from 'src/app/utils/XMLParser';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  public firstname: string;
  public lastname: string;
  public email: string;
  public roleType: string;

  constructor(private reqMaker: RequestMaker, private xmlParser: XMLParser) {
    this.fetchUserInformation();
  }

  ngOnInit(): void {
  }

  fetchUserInformation(): void {
    this.reqMaker.fetchUserInfo().subscribe({
      next: (retData: any) => {
        retData = this.xmlParser.parseFromXml(retData.body).UserInfoDTO;
        this.firstname = retData.firstname._text;
        this.lastname = retData.lastname._text;
        this.email = retData.email._text;
        this.roleType = retData.role._text;
      }
    });

  }

}
