import { Injectable } from '@angular/core';


@Injectable()
export class LocalStorageManager {
    private authTokenKey: string;
    private roleKey: string;

    constructor() {
        this.authTokenKey = 'auth-token';
        this.roleKey = 'role';
     }

  setAuthToken(authToken: string): void {
    localStorage.setItem(this.authTokenKey, authToken);
  }

  getAuthToken(): string | null{
    return localStorage.getItem(this.authTokenKey);
  }

  setUserRole(role: string): void {
    localStorage.setItem(this.roleKey, role);
  }

  getUserRole(): string | null{
    return localStorage.getItem(this.roleKey);
  }

}