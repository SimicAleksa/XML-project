import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CLIENT_LOGIN_URL, CLIENT_PROFILE_URL, CLIENT_REGISTER_URL, CLIENT_TM_NEW_REQ_URL, CLIENT_PT_NEW_REQ_URL, CLIENT_CR_ADVANCED_SEARCH_URL, CLIENT_CR_BASIC_SEARCH_URL, CLIENT_CR_PENDING_REQS_URL, CLIENT_CR_NEW_REQ_URL, CLIENT_PT_ADVANCED_SEARCH_URL, CLIENT_PT_BASIC_SEARCH_URL, CLIENT_PT_PENDING_REQS_URL } from 'src/app/configs/client-urls';
import { CLIENT_TM_ADVANCED_SEARCH_URL, CLIENT_TM_BASIC_SEARCH_URL, CLIENT_TM_PENDING_REQS_URL } from 'src/app/configs/client-urls';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';
import { MenuService } from './service/menu-service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  public activeRole: string;

  constructor(private lStorageManager: LocalStorageManager, private menuService: MenuService, private router: Router) {
    this.activeRole = lStorageManager.getUserRole();
    this.updateRole();
  }

  ngOnInit(): void {
    this.menuService.menuRole.subscribe(() => {
      this.updateRole();
    });
  }

  updateRole(): void {
    this.activeRole = this.lStorageManager.getUserRole();
  }

  onLogOutBtnClick(): void {
    this.lStorageManager.removeAuthToken();
    this.lStorageManager.removeRole();

    this.updateRole();
    this.onLoginBtnClick();
  }

  onLoginBtnClick() {
    this.router.navigate([CLIENT_LOGIN_URL]);
  }

  onRegisterBtnClick() {
    this.router.navigate([CLIENT_REGISTER_URL]);
  }

  onProfileBtnClick() {
    this.router.navigate([CLIENT_PROFILE_URL]);
  }

  onNewTrademarkReqBtnClick() {
    this.router.navigate([CLIENT_TM_NEW_REQ_URL]);
  }

  onNewPatentReqBtnClick() {
    this.router.navigate([CLIENT_PT_NEW_REQ_URL]);
  }

  onPendingTrademarkReqsBtnClick() {
    this.router.navigate([CLIENT_TM_PENDING_REQS_URL]);
  }

  onBasicSearchBtnClick() {
    this.router.navigate([CLIENT_TM_BASIC_SEARCH_URL]);
  }

  onAdvancedSearchBtnClick() {
    this.router.navigate([CLIENT_TM_ADVANCED_SEARCH_URL]);
  }


  onNewCopyRightReqBtnClick() {
    this.router.navigate([CLIENT_CR_NEW_REQ_URL]);
  }

  onPendingCopyRightReqsBtnClick() {
    this.router.navigate([CLIENT_CR_PENDING_REQS_URL]);
  }

  onPendingPatentReqsBtnClick() {
    this.router.navigate([CLIENT_PT_PENDING_REQS_URL]);
  }

  onBasicSearchCRBtnClick() {
    this.router.navigate([CLIENT_CR_BASIC_SEARCH_URL]);
  }

  onAdvancedSearchCRBtnClick() {
    this.router.navigate([CLIENT_CR_ADVANCED_SEARCH_URL]);
  }

  onBasicSearchPTBtnClick() {
    this.router.navigate([CLIENT_PT_BASIC_SEARCH_URL]);
  }

  onAdvancedSearchPTBtnClick() {
    this.router.navigate([CLIENT_PT_ADVANCED_SEARCH_URL]);
  }
}
