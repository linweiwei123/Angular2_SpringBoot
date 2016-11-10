import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 's-alerts',
  templateUrl: './alerts.component.html',
  styleUrls: [ './alerts.scss'],
})
export class AlertsComponent implements OnInit {
  @Input() width: number=300;
  @Input() showHeader: boolean=true;
  @Input() showFooter: boolean=false;
  @Input() headerText: string ="";
  @Input() footerText: string="";

@Input() headerLeftIconWidth : number=0;
@Input() headerRightIconWidth: number=25;
@Input() footerLeftIconWidth : number=0;
@Input() footerRightIconWidth: number=0;
@Input() page1Left:string = "0";
@Input() page2Left:string = "-300px";



  constructor() { }

  ngOnInit() {
  }

  leftIconClick(){
    this.headerLeftIconWidth=0;
    this.headerRightIconWidth=25;
    this.page2Left="-"+(this.width+20) +"px";
    this.page1Left="0";
  }

  rightIconClick(){
    this.headerLeftIconWidth=25;
    this.headerRightIconWidth=0;
    this.page2Left="0";
    this.page1Left="-"+(this.width+20) +"px";
  }

}
