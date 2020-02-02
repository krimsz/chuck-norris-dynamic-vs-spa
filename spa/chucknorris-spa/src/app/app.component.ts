import {Component, EventEmitter, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment';
import {BehaviorSubject, Observable, Subject} from 'rxjs';
import {map, pluck, switchMap, tap} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  currentFact: Observable<string>;
  clickStream$ = new BehaviorSubject<any>(null);

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit() {
    this.currentFact = this.clickStream$.pipe(
      switchMap( (_) =>
        this.httpClient.get(`${environment.restApiUrl}/joke`)
          .pipe(
            pluck('content'),
            map(c => c.toString())
          ))
    );
  }
}
