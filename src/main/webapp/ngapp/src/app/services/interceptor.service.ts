import { Injectable } from '@angular/core';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {TokenStorageService} from "./token-storage.service";
import {Router} from "@angular/router";
import {Observable} from "rxjs";

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable({ providedIn: 'root' })
export class InterceptorService implements HttpInterceptor {

  constructor(private token: TokenStorageService, private router: Router) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log(this.token.getToken());
    let authRequest = req;
    if(this.token.getToken() != null) {
      authRequest = req.clone({headers: req.headers.set(TOKEN_HEADER_KEY, this.token.getToken())});
    }
    return next.handle(authRequest);
  }
}
