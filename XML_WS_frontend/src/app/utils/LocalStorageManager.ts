import { Injectable } from '@angular/core';


@Injectable()
export class LocalStorageManager {
    private authTokenKey: string;
    private roleKey: string;
    private loggedUserEmailKey: string;

    constructor() {
        this.authTokenKey = 'auth-token';
        this.roleKey = 'role';
        this.loggedUserEmailKey = 'logged-user-email'
     }

  setAuthToken(authToken: string): void {
    localStorage.setItem(this.authTokenKey, authToken);
  }

  getAuthToken(): string | null{
    let authToken = localStorage.getItem(this.authTokenKey);
    return authToken !== null ? authToken : "INVALID";
  }

  removeAuthToken() {
    localStorage.removeItem(this.authTokenKey);
  }

  setUserRole(role: string): void {
    localStorage.setItem(this.roleKey, role);
  }

  getUserRole(): string {
    let role = localStorage.getItem(this.roleKey);
    return role === null ? "NOT LOGGED" : role;
  }

  removeRole() {
    localStorage.removeItem(this.roleKey);
  }

  setLoggedUserEmail(loggedUserEmail: string): void {
    localStorage.setItem(this.loggedUserEmailKey, loggedUserEmail);
  }

  getLoggedUserEmail(): string {
    let email = localStorage.getItem(this.loggedUserEmailKey);
    return email === null ? "NOT LOGGED" : email;
  }

  removeLoggedUserEmail() {
    localStorage.removeItem(this.loggedUserEmailKey);
  }
}