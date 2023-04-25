import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  formData = {
    name: '',
    email: '',
    description: ''
  };
  emailSent = false;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
 
}
