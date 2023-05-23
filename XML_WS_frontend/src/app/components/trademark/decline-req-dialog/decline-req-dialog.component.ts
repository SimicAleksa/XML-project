import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-decline-req-dialog',
  templateUrl: './decline-req-dialog.component.html',
  styleUrls: ['./decline-req-dialog.component.css']
})
export class DeclineReqDialogComponent implements OnInit {
  inputValue: string;
  @Output() submitValue = new EventEmitter<string>();

  constructor(public dialogRef: MatDialogRef<DeclineReqDialogComponent>) {}
  
  ngOnInit(): void {
  }

  onCancel(): void {
    this.dialogRef.close();
  }

  onSubmit(): void {
    if (this.inputValue === "") {
      alert("Unesite obrazlozenje pre potvrde.")
      return;
    }

    this.submitValue.emit(this.inputValue);
    this.dialogRef.close();
  }

}
