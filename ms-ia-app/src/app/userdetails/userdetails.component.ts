import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {
 currentUser = null;
  message = '';
  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  
  constructor(private userService: UserService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
   this.message = '';
   console.log(this.route.snapshot.paramMap.get('id'));
    this.getUser(this.route.snapshot.paramMap.get('id'));
  }

  getUser(id) {
    this.userService.get(id)
      .subscribe(
        data => {
          this.currentUser = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  

  updateUser() {
    this.userService.update(this.currentUser.id, this.currentUser)
      .subscribe(
        response => {
          console.log(response);
          this.message = 'The user was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deleteUser() {
    this.userService.delete(this.currentUser.id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/admin']);
        },
        error => {
          console.log(error);
        });
  }
}
