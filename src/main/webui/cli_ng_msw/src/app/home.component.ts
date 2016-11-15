import { Component, ViewEncapsulation, OnInit } from '@angular/core';
import { Router,ActivatedRoute, NavigationEnd } from '@angular/router';

import { LogoComponent }    from './components/logo/logo.component';
import { ItemDescrModel }   from './models/item-descr.model';


@Component({
  selector   : 'home-comp',
  templateUrl: './home.component.html',
  styleUrls  : ['./home.scss'],
  encapsulation: ViewEncapsulation.None
})
export class HomeComponent   {

  public selectedNavItem:string ="customers";
  public openRightDraw: boolean = false;

  constructor(private router:Router, private activeRoute:ActivatedRoute) {
    router.events
      .filter(event => event instanceof NavigationEnd)
      .map(_ => this.router.routerState.root)
      .map(route => {
        while (route.firstChild) route = route.firstChild;;
        return route;
      })
      .flatMap(route => route.data)
      .subscribe(data => {
        console.log(data);
        this.selectedNavItem = data.comp;
      });
  }

  toolbarNavItems:ItemDescrModel[] = [
    { itemId: 'products' , itemDescr: 'Products'  },
    { itemId: 'customers', itemDescr: 'Customers' },
    { itemId: 'services' , itemDescr: 'Services'  }
  ];


  navbarSelectionChange(val){
     // console.log(val);
  }


  onAlertClick($event){
    this.openRightDraw = !this.openRightDraw;
  }

  onLogout(event){
    localStorage.clear();
    window.location.href = '/index.html';
  }
}
