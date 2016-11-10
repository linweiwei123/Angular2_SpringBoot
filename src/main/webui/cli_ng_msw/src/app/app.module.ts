import { BrowserModule }  from '@angular/platform-browser';
import { NgModule }       from '@angular/core';
import { FormsModule, ReactiveFormsModule}    from '@angular/forms';
import { HttpModule }     from '@angular/http';
import { MaterialModule } from '@angular/material';
import { RouterModule }   from '@angular/router';

//Routing Module
import { AppRoutingModule } from './app-routing.module';


// Compinents and Pages
import { AppComponent }     from './app.component';
import { PillComponent }    from './components/pill/pill.component';
import { HnavComponent }    from './components/hnav/hnav.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { LogoComponent }    from './components/logo/logo.component';
import { AppFooterComponent } from './components/app-footer/app-footer.component';

//Pages
import { HomeComponent }      from './home.component';
import { LoginComponent }     from './components/pages/login/login.component';
import { AlertsComponent }    from './components/pages/alerts/alerts.component';
import { ProductsComponent }  from './components/pages/products/products.component';
import { CustomersComponent } from './components/pages/customers/customers.component';
import { ServicesComponent }  from './components/pages/services/services.component';
import { SignupComponent }    from './components/pages/signup/signup.component';


// Services
import { LoginService } from './api/login.service';
import { AuthGuard } from './routing_guards/auth.guard';

//Material2 depends on this module
import 'hammerjs';



@NgModule({

  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MaterialModule.forRoot(),
    HttpModule
  ],

  declarations: [
    AppComponent,
    PillComponent,
    HnavComponent,
    SidebarComponent,
    AlertsComponent,
    HomeComponent,
    LogoComponent,
    AppFooterComponent,
    LoginComponent,
    ProductsComponent,
    CustomersComponent,
    ServicesComponent,
    SignupComponent

  ],

  providers:[
    AuthGuard,
    LoginService,
    {provide: 'api', useValue: 'http://localhost:9119/'}
  ],

  bootstrap: [AppComponent]
})

export class AppModule { }
