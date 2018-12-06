import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../services/token-storage.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    if(!this.tokenStorageService.getToken()) {
      this.router.navigate(['login']);
    }
  }

  logOut() {
    this.tokenStorageService.signOut();
    this.router.navigate(['login']);
  }

}
