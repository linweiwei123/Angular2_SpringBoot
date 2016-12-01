import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent  }       from './home.component';
import { LoginComponent }       from './components/pages/login/login.component';

import { ProductsComponent  }   from './components/pages/products/products.component';
import { CustomersComponent }   from './components/pages/customers/customers.component';
import { ServicesComponent  }   from './components/pages/services/services.component';
import { SignupComponent }    from './components/pages/signup/signup.component';

import { AuthGuard } from './routing_guards/auth.guard';
import { PageNotFoundComponent }  from './components/pages/404/page-not-found.component';

const routes: Routes = [
  //Important: The sequence of path is important as the router go over then in sequential manner
  { path: 'login',  component: LoginComponent  },
  { path: 'signup', component: SignupComponent },
  {
    path: 'home',
    component: HomeComponent,
    canActivate:[AuthGuard],
    children:[  // Children paths are appended to the parent path
      {
        path:'', // Default path (if no deep path is specified for home component like webui/home then it will by default show ProductsComponent )
        children:[
          { path: '',  component: ProductsComponent  },
          { path: 'products',  component: ProductsComponent,  data:[{comp:'products' }]},
          { path: 'customers', component: CustomersComponent, data:[{comp:'customers'}]},
          { path: 'services',  component: ServicesComponent,  data:[{comp:'services' }]}
        ]
      }
    ]
  },
  { path: '', redirectTo: '/home/products', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }

];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
  declarations:[PageNotFoundComponent]
})
export class AppRoutingModule {}
