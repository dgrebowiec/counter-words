import {Component} from 'angular2/core';
import {HTTP_PROVIDERS, Http, Headers} from 'angular2/http';
import {Injectable} from 'angular2/core';
import {NgFor} from 'angular2/common';
import 'rxjs/Rx';

@Component({
    selector: 'my-app',
    viewProviders: [HTTP_PROVIDERS],
    template: `
        <h1>test </h1>
        <div> <label> {{dupa}} </label></div>
        <div> <input [(ngModel)]="dupa" placeholder="rower"> </div>
        <button (click)="getWords()">wczytaj slowa</button>
        <div>
          <h1>Wordeeeeees</h1>
          <!--{{words}}-->
          <ul>
            <li *ngFor="#word of words">
              {{word.word}}
            </li>
          </ul>
    </div>
    `,
    directives: [NgFor]
})


@Injectable()
export class AppComponent {

 words = [];

    constructor(public http: Http) {
       // header.append('Access-Control-Allow-Origin', '*');
        //http.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
    }

    getWords() {

        this.http.get('http://localhost:8080/words')
            .subscribe(
                res => {this.words = res.json(); },
                err => console.error('There was an error: ' + err)
        );
    }
    dupa = 'dupa100';
}
