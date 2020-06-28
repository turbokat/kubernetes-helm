import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  todaysThought = {
    author: "",
    thought: ""
  };
  isFetching = false;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.isFetching = true;
    this.http.get('http://localhost:8080/default-thought')
      .subscribe(responseData => {
        console.log(responseData);
        this.todaysThought.author = responseData['author'];
        this.todaysThought.thought = responseData['thought'];
        this.isFetching = false;
      });
  }

  onGetThought() {
    this.isFetching = true;
    this.http.get('http://localhost:8080/thought-for-the-day')
      .subscribe(responseData => {
        console.log(responseData);
        this.todaysThought.author = responseData['author'];
        this.todaysThought.thought = responseData['thought'];
        this.isFetching = false;
      });
  }
}
