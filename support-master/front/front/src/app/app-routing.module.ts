import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TopicsListComponent} from './components/topics-list/topics-list.component';
import { TopicDetailsComponent } from './components/topic-details/topic-details.component';
import { AddTopicComponent } from './components/add-topic/add-topic.component';
import {FrontListComponent} from "./components/front-list/front-list.component";
import { FormComponent } from './components/form/form.component';
import { HomeComponent } from './components/home/home.component';
import { ContactComponent } from './components/contact/contact.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'topics', component: TopicsListComponent },
  { path: 'contact', component: ContactComponent },

  { path: 'topics/:id', component: TopicDetailsComponent },
  { path: 'add', component: AddTopicComponent },
  { path: 'fronttopics', component: FrontListComponent },
  { path: 'form', component: FormComponent }




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
