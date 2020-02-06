import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MovieMenuComponent } from './movie/movie-menu/movie-menu.component';
import { LoginComponent } from './login/login.component';
import { FavoritesComponent } from './favorites/favorites.component';
import { AuthGuard } from './auth.guard';
import { EditMovieComponent } from './movie/edit-movie/edit-movie.component';
import { SignupComponent } from './signup/signup.component';


const routes: Routes = [

  { path: '', redirectTo: '/movie-menu', pathMatch: 'full' },
  { path: 'favorites', component: FavoritesComponent },
  { path: 'addToFavorites', component: FavoritesComponent },
  { path: 'movie-menu', component: MovieMenuComponent },
  { path: 'customer', component: MovieMenuComponent },
  { path: 'main', component: MovieMenuComponent },
  { path: 'login', component: LoginComponent },
  { path: 'admin', component: MovieMenuComponent },
  { path: 'edit-movie/:id', component: EditMovieComponent},
 
  { path: 'signup', component: SignupComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
