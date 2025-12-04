import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule, CommonModule, MatCardModule, MatInputModule, MatButtonModule, MatIconModule, MatFormFieldModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  user={
    email:'',
    password:'',
  }
  storedUser={
    email:'test@gmail.com',
    password:'password123',
  }
  loginValid:boolean=true

  router=inject(Router)

  validadeLogin(email:string,password:string):boolean{
    return email==this.storedUser.email && password==this.storedUser.password
  }

  login() {
    if(this.validadeLogin(this.user.email, this.user.password)){
      localStorage.setItem('loggedInUser', JSON.stringify(this.user.email))
      this.loginValid=true
      this.router.navigate(['/dashboard'])
    } else {
      alert('incorrect email or password')
      this.loginValid=false
    }
  }

}
