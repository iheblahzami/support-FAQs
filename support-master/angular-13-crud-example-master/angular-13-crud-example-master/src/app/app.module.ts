import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTopicComponent } from './components/add-topic/add-topic.component';
import { TopicDetailsComponent } from './components/topic-details/topic-details.component';
import { TopicsListComponent } from './components/topics-list/topics-list.component';
import { FrontListComponent } from './components/front-list/front-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddTopicComponent,
    TopicDetailsComponent,
    TopicsListComponent,
    FrontListComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

