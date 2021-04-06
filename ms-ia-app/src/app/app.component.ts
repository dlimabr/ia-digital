import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './_services/token-storage.service';
import { AuthService } from './_services/auth.service';
import { UserService } from './_services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username: string;
  sessionUser:string;

  constructor(private tokenStorageService: TokenStorageService, private authService: AuthService,private userService: UserService) { }

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
	  this.retrieveUserSession();
    
    }
  }
 retrieveUserSession() {
    this.userService.getPrincipal()
      .subscribe(
        data => {
          this.username = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  logout() {
	this.authService.logout();
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
