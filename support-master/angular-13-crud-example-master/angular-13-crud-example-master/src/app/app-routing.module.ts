import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TopicsListComponent} from './components/topics-list/topics-list.component';
import { TopicDetailsComponent } from './components/topic-details/topic-details.component';
import { AddTopicComponent } from './components/add-topic/add-topic.component';
import {FrontListComponent} from "./components/front-list/front-list.component";

const routes: Routes = [
  { path: '', redirectTo: 'topics', pathMatch: 'full' },
  { path: 'topics', component: TopicsListComponent },
  { path: 'topics/:id', component: TopicDetailsComponent },
  { path: 'add', component: AddTopicComponent },
  { path: 'topics', component: FrontListComponent },
  { path: 'fronttopics', component: FrontListComponent }




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
