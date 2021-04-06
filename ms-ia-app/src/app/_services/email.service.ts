import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/email/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  constructor(private http: HttpClient) { }

  send(email): Observable<any> {
    return this.http.post(API_URL, {
      username: email.username,     
      message: email.message,
      email: email.email,
	  allUsersAdmin: email.allUsersAdmin
    }, httpOptions);
  }
 
}
