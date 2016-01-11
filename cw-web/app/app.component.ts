import {Component} from 'angular2/core'

@Component({
    selector: 'my-app',
    template: `
        <h1>test </h1>
      <div> <label> {{dupa}} </label></div>
       <div> <input [(ngModel)]="dupa" placeholder="rower"> </div>
    `

})
export class AppComponent {
    dupa = 'dupa100';
}
