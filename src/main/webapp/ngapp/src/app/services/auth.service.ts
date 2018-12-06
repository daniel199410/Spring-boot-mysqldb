import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {TokenStorageService} from "./token-storage.service";

const httpOptions = new HttpHeaders({ 'Content-Type': 'application/json', });

@Injectable({ providedIn: 'root' })

export class AuthService implements CanActivate{
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient, private router: Router, private tokenStorageService: TokenStorageService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean> {
    return Promise.resolve(this.http.get(`${this.baseUrl}/rest/users/test`).toPromise()
      .then(a => true)
      .catch(e => {
        this.tokenStorageService.signOut();
        this.router.navigate(['login']);
        return false
      }));
  }

  attemptAuth(username: string, password: string): Observable<HttpResponse<any>> {
    const credentials = {username: username, password: password};
    return this.http.post<any>(`${this.baseUrl}/login`, credentials, {headers: httpOptions, observe: 'response'});
  }
}
