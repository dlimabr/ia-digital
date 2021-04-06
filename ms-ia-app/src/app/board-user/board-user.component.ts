import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { EmailService } from '../_services/email.service';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  content = '';
  users: any;
  form: any = {};
  currentUser = null;
  currentIndex = -1;
  title = '';
   isSuccessful = false;
  isSignUpFailed = false;
  isAllUsersAdmin = false;
  errorMessage= '';
  emailRequest = null;
  constructor(private userService: UserService,private emailService: EmailService) { }

  ngOnInit() {
    this.retrieveUsers();
  }

  public isChecked$ = new BehaviorSubject(false);

  toggleChecked() {
 	this.isChecked$.next(!this.isChecked$.value);	
	this.isAllUsersAdmin=this.isChecked$.value;
	this.currentUser = null;
    this.currentIndex = -1;
	this.form.allUsersAdmin=this.isChecked$.value;
  }

  
   retrieveUsers() {
    this.userService.getAll()
      .subscribe(
        data => {
          this.users = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  onSubmit() {	
	if (this.currentUser){
	    this.emailRequest =  {
	      username: this.currentUser.username, 
	      email: this.currentUser.email,     
	      message: this.form.message,
		  allUsersAdmin: this.form.allUsersAdmin
	    }
	}else{
		this.emailRequest =  {
	      message: this.form.message,
		  allUsersAdmin: this.form.allUsersAdmin
	    };	
	}
	console.log(this.emailRequest);
    this.emailService.send(this.emailRequest).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
	this.refreshList();
  }

  refreshList() {
    this.retrieveUsers();
    this.currentUser = null;
    this.currentIndex = -1;
  }

  setActiveUser(user, index) {
    this.currentUser = user;    
    this.currentIndex = index;
	this.isSuccessful=false;
	this.isAllUsersAdmin=false;
	this.isChecked$.next(false);
	this.form.allUsersAdmin=false;	
  }


  searchUser() {
    this.userService.findByTitle(this.title)
      .subscribe(
        data => {
          this.users = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}

