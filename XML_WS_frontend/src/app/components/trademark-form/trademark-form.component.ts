import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-trademark-form',
  templateUrl: './trademark-form.component.html',
  styleUrls: ['./trademark-form.component.css']
})
export class TrademarkFormComponent implements OnInit {
  favoriteSeason: string;
  seasons: string[] = ['Winter', 'Spring', 'Summer', 'Autumn'];
  constructor() { }

  ngOnInit(): void {
  }

}
