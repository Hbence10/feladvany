import { Component } from '@angular/core';
import { MatButton } from '@angular/material/button';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-not-found',
  imports: [RouterModule, MatButton],
  templateUrl: './not-found.html',
  styleUrl: './not-found.scss',
})
export class NotFound {

}
