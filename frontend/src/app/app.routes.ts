import { Routes } from '@angular/router';
import { HomePage } from './components/home-page/home-page';
import { NotFound } from './components/not-found/not-found';

export const routes: Routes = [
  { path: "homePage", component: HomePage, title: "Kezdőlap" },
  { path: "", pathMatch: "full", redirectTo: "homePage" },
  { path: "**", component: NotFound }
];
