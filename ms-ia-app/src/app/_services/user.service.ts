import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/test/';

const API_URL_USERS = 'http://localhost:8080/api/users';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }
  getAll() {
    return this.http.get(API_URL_USERS);
  }

  get(id) {
     return this.http.get(`${API_URL_USERS}/${id}`);
  }

  create(data) {
    return this.http.post(API_URL_USERS, data);
  }

  update(id, data) {
    return this.http.put(`${API_URL_USERS}/${id}`, data);
  }

  delete(id) {
    return this.http.delete(`${API_URL_USERS}/${id}`);
  }

  deleteAll() {
    return this.http.delete(API_URL);
  }

  findByTitle(title) {
    return this.http.get(`${API_URL_USERS}?title=${title}`);
  }

 getPrincipal(): Observable<any> {
    return this.http.get(API_URL_USERS + '/principal', { responseType: 'text' });
  }
 
 
}
