import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { API_LOGIN_URL, API_REGISTRATION_URL } from "../configs/api-urls";

@Injectable()
export class RequestMaker {
  constructor(private httpClient: HttpClient) { }

  registrationRequest(data: any) {
    return this.getRequest('POST', API_REGISTRATION_URL, data);
  }

  loginRequest(data: any) {
    return this.getRequest('POST', API_LOGIN_URL, data);
  }

  getRequest(requestType: string, api_url: string,data: any = null) {
    let header = {
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${localStorage.getItem("token") || 'invalid'}`)
      .set('Content-Type',  'application/xml')
    }
    return this.httpClient.request(new HttpRequest(requestType, api_url, data, header));
  }
}
