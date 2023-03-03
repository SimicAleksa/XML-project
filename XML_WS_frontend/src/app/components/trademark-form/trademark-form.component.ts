import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-trademark-form',
  templateUrl: './trademark-form.component.html',
  styleUrls: ['./trademark-form.component.css']
})
export class TrademarkFormComponent implements OnInit {
  public tipZiga: string = "";
  public tipZnaka: string = "";

  // numbers = Array.from({length: 3}, (_, i) => i+1);
  numbers = [1, 2, 5 , 3];
  selectedNumbers =[];

  constructor() { }

  ngOnInit(): void {
  }

}
