import {UserContact} from "./user-contact";
import {Solicitud} from "./Solicitud";

export class User {
  id: number;
  name: string;
  teamName: string;
  salary: number;
  userName: string;
  password: string;
  rol: number;
  userContact: UserContact;
  queries: Array<Solicitud>;
  active: boolean;
}
