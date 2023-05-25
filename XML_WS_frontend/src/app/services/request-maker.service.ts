import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { API_CR_ADVANCED_SEARCH, API_CR_BASIC_SEARCH, API_FETCH_PENDING_CR_REQS_URL, API_FETCH_PENDING_PAT_REQS_URL, API_GEN_CR_PDF, API_GEN_CR_XHTML, API_GEN_PAT_PDF, API_GEN_PAT_XHTML, API_LOGIN_URL, API_PAT_ADVANCED_SEARCH, API_PAT_BASIC_SEARCH, API_REGISTRATION_URL, API_SEND_CR_REQ_URL, API_SEND_CR_RESENJE, API_SEND_PATENT_REQ_URL, API_SEND_PAT_RESENJE, API_SEND_TRADEMARK_REQ_URL } from "../configs/api-urls";
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

  sendTrademarkRequest(data: any) {
    return this._getRequest('POST', API_SEND_TRADEMARK_REQ_URL, data);
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


  //PATENT//
  sendPatentRequest(data: any) {
    return this._getRequest('POST', API_SEND_PATENT_REQ_URL, data);
  }

  getPatentPDF(id: string) {
    return this._getRequest('GET', API_GEN_PAT_PDF + id);
  }

  getPatentXHTML(id: string) {
    return this._getRequest('GET', API_GEN_PAT_XHTML + id);
  }

  sendNewPatentReqResenje(data: any) {
    return this._getRequest('POST', API_SEND_PAT_RESENJE, data);
  }

  getPendingPATRequests(){
    return this._getRequest('GET', API_FETCH_PENDING_PAT_REQS_URL);
  }

  doPATBasicSearch(data: any) {
    return this._getRequest('POST', API_PAT_BASIC_SEARCH, data);
  }

  doPATAdvancedSearch(data: any) {
    return this._getRequest('POST', API_PAT_ADVANCED_SEARCH, data);
  }


  //COPYRIGHT//
  doCRBasicSearch(data: any) {
    return this._getRequest('POST', API_CR_BASIC_SEARCH, data);
  }

  doCRAdvancedSearch(data: any) {
    return this._getRequest('POST', API_CR_ADVANCED_SEARCH, data);
  }

  sendCopyRightRequest(data: any) {
    return this._getRequest('POST', API_SEND_CR_REQ_URL, data);
  }

  getCopyRightPDF(id: string) {
    return this._getRequest('GET', API_GEN_CR_PDF + id);
  }

  getCopyRightXHTML(id: string) {
    return this._getRequest('GET', API_GEN_CR_XHTML + id);
  }

  sendNewCopyRightReqResenje(data: any) {
    return this._getRequest('POST', API_SEND_CR_RESENJE, data);
  }

  getPendingCRRequests(){
    return this._getRequest('GET', API_FETCH_PENDING_CR_REQS_URL);
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
