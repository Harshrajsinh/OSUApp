import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule }   from '@angular/forms';
import { Student } from './student';
import { HttpModule } from '@angular/http';
import { Http,URLSearchParams, Headers } from '@angular/http';
import {ToastModule, ToastsManager} from 'ng2-toastr/ng2-toastr';
import { RouterModule,Router } from '@angular/router';
import { Component, ViewContainerRef, OnInit } from '@angular/core';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  [x: string]: any;

  public model: Student;
  
     name:string = "";
  
     course:any[] = [{'id': 1,'cno':'','cname':''}];
  
     id:number = 1;
  
     result:Array<any> = [];
  
     constructor(private router: Router, private http : Http,public toastr: ToastsManager, vcr: ViewContainerRef){
      
          this.toastr.setRootViewContainerRef(vcr);
      
                   
         }

       
  ngOnInit() {

    var self  = this;
    let headers = new Headers();

    headers.append('Access-Control-Allow-Origin','http://localhost:4200');
    this.http.get('http://localhost:8084/api/getAllUsers',{ headers : headers}).map((response)=>response.json()).subscribe(
        function(data){
            this.result=data;
            console.log(this.result);
      }
    )
  }
  showSuccess() {
   this.router.navigate(['']);
  }

  display(){
    
            let headers = new Headers();
            headers.append('Access-Control-Allow-Origin','http://localhost:4200');
            headers.append('Content-Type','application/json');
            headers.append('Access','application/json');
    
          
            let postBody = JSON.stringify({"name" : this.name, "email" : this.email,});
            this.http.post('http://localhost:8084/api/addUser',postBody, {
            headers:headers
            }).subscribe((data)=>{
                console.log(data);
                var data = data;
                this.showSuccess();
          
            }
          )

        }

    
      back(){
        this.router.navigate(['']);
      }
}