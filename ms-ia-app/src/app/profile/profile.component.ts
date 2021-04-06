import { Component, OnInit } from '@angular/core';

import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: any;	
  sessionUser:string;
  
constructor(private token: TokenStorageService,private userService: UserService) { }


  ngOnInit() {
    this.currentUser = this.token.getUser();
		
		
  }


}