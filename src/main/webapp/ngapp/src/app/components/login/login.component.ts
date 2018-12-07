import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import { TokenStorageService } from '../../services/token-storage.service';

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

  login(username: string, password:string): void {
    this.authService.attemptAuth(username, password).subscribe(
      data => {
        const token = data.headers.get('Authorization');
        if(token) {
          this.token.saveToken(data.headers.get('Authorization'));
          this.router.navigate(['home']);
        } else {

        }
      }, error1 => {
        console.log("error");
      }
    )
  }

}
