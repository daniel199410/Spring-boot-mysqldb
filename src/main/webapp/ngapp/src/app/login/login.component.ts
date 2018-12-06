import { Component, OnInit } from '@angular/core';
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private authService: AuthService,
    private router: Router,
    private token: TokenStorageService
  ) { }

  ngOnInit() {
  }

  login(): void {
    this.authService.attemptAuth('dcatanor', '123').subscribe(data => {
        console.log(data.headers.get('authorization'));
        this.token.saveToken(data.headers.get('Authorization'));
        //this.router.navigate(['login']);
      }
    )
  }

}
