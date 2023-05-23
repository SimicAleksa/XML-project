import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { API_FETCH_PENDING_PAT_REQS_URL, API_LOGIN_URL, API_REGISTRATION_URL, API_SEND_PATENT_REQ_URL, API_SEND_TRADEMARK_REQ_URL } from "../configs/api-urls";
import { API_FETCH_PENDING_TM_REQS_URL, API_GEN_TM_PDF, API_GEN_TM_XHTML, API_SEND_TM_RESENJE, API_TM_ADVANCED_SEARCH, API_TM_BASIC_SEARCH, API_USER_INFO_URL } from "../configs/api-urls";
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

  sendPatentRequest(data: any) {
    return this._getRequest('POST', API_SEND_PATENT_REQ_URL, data);
  }

  sendTrademarkRequest(data: any) {
    return this._getRequest('POST', API_SEND_TRADEMARK_REQ_URL, data);
  }

  getPendingPATRequests(){
    return this._getRequest('GET', API_FETCH_PENDING_PAT_REQS_URL);
  }

  getPendingTMRequests() {
    return this._getRequest('GET', API_FETCH_PENDING_TM_REQS_URL);
  }

  getTrademarkPDF(id: string) {
    return this._getRequest('GET', API_GEN_TM_PDF + id);
  }

  getTrademarkXHTML(id: string) {
    return this._getRequest('GET', API_GEN_TM_XHTML + id);
  }

  sendNewTrademarkReqResenje(data: any) {
    return this._getRequest('POST', API_SEND_TM_RESENJE, data);
  }

  doTMBasicSearch(data: any) {
    return this._getRequest('POST', API_TM_BASIC_SEARCH, data);
  }

  doTMAdvancedSearch(data: any) {
    return this._getRequest('POST', API_TM_ADVANCED_SEARCH, data);
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
