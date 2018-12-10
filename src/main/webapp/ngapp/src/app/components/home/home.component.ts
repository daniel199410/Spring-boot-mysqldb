import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../services/token-storage.service";
import {Router} from "@angular/router";
import {User} from "../../models/user";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private tokenStorageService: TokenStorageService) { }

  user: User = {
    id: 1,
    name: "Daniel",
    teamName: "Team",
    salary: 700000,
    userName: "dcatanor",
    password: "123",
    rol: 0,
    userContact: {
      id: 8,
      phone: "3016347490"
    },
    queries: [
      {
        cdSolicitud: 2,
        tipoSolicitud: "B",
        ubicacion: "Lorem",
        cantidadIntentos: 10,
        fechaCreacion: "2018-12-24T00:00:00.000+0000"
      },
      {
        cdSolicitud: 2,
        tipoSolicitud: "A",
        ubicacion: "Ipsum",
        cantidadIntentos: 8,
        fechaCreacion: "2018-12-24T00:00:00.000+0000"
      }
    ],
    active: true,
  }

  ngOnInit() {
    if(!this.tokenStorageService.getToken()) {
      this.router.navigate(['login']);
    }
  }

  logOut() {
    this.tokenStorageService.signOut();
    this.router.navigate(['login']);
  }

  about() {
    this.router.navigate(['about']);
  }

}
