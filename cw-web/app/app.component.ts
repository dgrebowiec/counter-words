import {Component} from 'angular2/core';
import {Http} from 'angular2/http';
//import {Injectable} from 'angular2/core';

@Component({
    selector: 'my-app',
    //viewProviders: [HTTP_PROVIDERS],
    template: `
        <h1>test </h1>
        <div> <label> {{dupa}} </label></div>
        <div> <input [(ngModel)]="dupa" placeholder="rower"> </div>
    `
})

//@Injectable()
export class AppComponent {
   /* constructor(http: Http) {
        //http.get('/words')

    }*/
    dupa = 'dupa100';
}
