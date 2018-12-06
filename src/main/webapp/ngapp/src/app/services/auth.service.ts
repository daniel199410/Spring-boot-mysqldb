import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';

const httpOptions = new HttpHeaders({ 'Content-Type': 'application/json', });

@Injectable({ providedIn: 'root' })

export class AuthService {
  private baseUrl = 'http://localhost:8080';
  private headers = new HttpHeaders({
    'Access-Control-Allow-Origin': '*'
  })

  constructor(private http: HttpClient) { }

  attemptAuth(username: string, password: string): Observable<HttpResponse<any>> {
    const credentials = {username: username, password: password};
    return this.http.post<any>(`${this.baseUrl}/login`, credentials, {headers: httpOptions, observe: 'response'},);
  }
}
