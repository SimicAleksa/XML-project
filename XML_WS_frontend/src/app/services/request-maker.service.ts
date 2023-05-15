import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { API_LOGIN_URL, API_REGISTRATION_URL, API_SEND_TRADEMARK_REQ_URL, API_USER_INFO_URL } from "../configs/api-urls";
import { LocalStorageManager } from '../utils/LocalStorageManager';

@Injectable()
export class RequestMaker {
  constructor(private httpClient: HttpClient, 
              private lStorageManager: LocalStorageManager) { }

  registrationRequest(data: any) {
    return this._getRequest('POST', API_REGISTRATION_URL, data);
  }

  loginRequest(data: any) {
    return this._getRequest('POST', API_LOGIN_URL, data);
  }

  fetchUserInfo() {
    return this._getRequest('GET', API_USER_INFO_URL);
  }

  sendTrademarkRequest(data: any) {
    return this._getRequest('POST', API_SEND_TRADEMARK_REQ_URL, data);
  }

  _getRequest(requestType: string, api_url: string, data: any = null) {
    let header: Object = {
      headers: new HttpHeaders()
        .set('Authorization',  `Bearer ${this.lStorageManager.getAuthToken()}`)
        .set('Content-Type',  'application/xml'),
      responseType: 'text'
    }
    return this.httpClient.request(new HttpRequest(requestType, api_url, data, header));
  }
}
