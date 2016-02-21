import {Component} from 'angular2/core';
import {HTTP_PROVIDERS, Http, Headers} from 'angular2/http';
import {Injectable} from 'angular2/core';
import {NgFor} from 'angular2/common';
import 'rxjs/Rx';

@Component({
    selector: 'my-app',
    viewProviders: [HTTP_PROVIDERS],
    templateUrl: 'app/cw-list.tpl.html',
    directives: [NgFor]
})


@Injectable()
export class AppComponent {

    words = [];
    knownedWords = [];
    buttonLoadWords = "Wczytaj";

    constructor(public http: Http) {
       // header.append('Access-Control-Allow-Origin', '*');
        //http.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
    }

    getWords() {
        this.buttonLoadWords = "Wczytywanie...";
        this.http.get('http://localhost:8090/words')
            .subscribe(
                res => {this.words = res.json(); },
                err => console.error('There was an error: ' + err) ,
                () => this.buttonLoadWords = "Wczytaj"
        );
    };

    saveWords() {
        this.http.put('http://localhost:8090/words').subscribe();
    };

    learnedWord(word) {
        var headers = new Headers();
        headers.append('Content-Type', 'application/json');
        this.http.post('http://localhost:8090/words/', word,{headers:headers}).subscribe();
    }
    dupa = 'dupa100';
}
