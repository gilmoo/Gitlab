import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './../app.component';
import { ProfilePageComponent } from './../Profile/profile.component';
import { TimelinePageComponent } from './../Timeline/timeline.component';

export const router: Routes = [
    { path: '', redirectTo : 'home', pathMatch: 'full'},
    { path: 'home', component: ProfilePageComponent},
    { path: 'timeline', component: TimelinePageComponent},
];

export const Routing: ModuleWithProviders = RouterModule.forRoot(router);