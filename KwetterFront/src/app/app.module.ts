import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { Routing } from './routes/routing.component';
import { ModalModule, TabsModule } from 'ng2-bootstrap';

import { AppComponent } from './app.component';
import { ProfilePageComponent } from './Profile/profile.component';
import { TimelinePageComponent } from './Timeline/timeline.component';
import { NavbarTopComponent } from './Navbar/navbar_top.component';
import { FooterComponent } from './Footer/footer.component';

import { UserService } from './rest/user.service';
import { TweetService } from './rest/tweet.service';

@NgModule({
  declarations: [
    AppComponent,
    ProfilePageComponent,
    TimelinePageComponent,
    NavbarTopComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    TabsModule.forRoot(),
    ModalModule.forRoot(),
    Routing
  ],
  providers: [
    UserService,
    TweetService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
