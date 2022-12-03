import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest } from '@angular/common/http';
import { API_REGISTRATION_URL } from "../configs/api-urls";

@Injectable()
export class RequestMaker {
  constructor(private httpClient: HttpClient) { }

  registrationRequest(data: any) {
    return this.httpClient.request(new HttpRequest('POST', API_REGISTRATION_URL, data));
  }
}
