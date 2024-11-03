import { Routes } from '@angular/router';

import { TitleComponent } from './title/title.component';
import { CheckSampleComponent } from './check-sample/check-sample.component'; 

export const routes: Routes = [
    {path: '', component: TitleComponent },
    {path: '', component: CheckSampleComponent },
];
