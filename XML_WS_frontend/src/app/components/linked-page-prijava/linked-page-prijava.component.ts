import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';
import { XMLParser } from 'src/app/utils/XMLParser';


@Component({
  selector: 'app-linked-page-prijava',
  templateUrl: './linked-page-prijava.component.html',
  styleUrls: ['./linked-page-prijava.component.css']
})
export class LinkedPagePrijavaComponent implements OnInit {
  selectedPAT: string;
  constructor(private requestMaker: RequestMaker, private xmlParser: XMLParser, private lStorageManager: LocalStorageManager,private route: ActivatedRoute,) { 
  }
  
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.selectedPAT = params['id'];
      this.onXHTMLBtnClick();
    });
  }

  

  onXHTMLBtnClick() {
    this.requestMaker
    .getPatentXHTML(this.selectedPAT)
    .subscribe({
      next: (data: any) => {
        if (data.body !== undefined)
          this.openPDF(this.xmlParser.parseFromXml(data.body).PDFBytesDTO.Bytes._text, 'text/html;charset=utf-8');
      },
      error: () => {
        alert('XHTML nije generisan, nesto se desilo!');
      }
    });
  }
  openPDF(bytesAsStr: string, mime: string) {
    const blob = new Blob([require('buffer').Buffer.from(bytesAsStr, 'base64')], { type: mime });
    const url = window.URL.createObjectURL(blob);
    window.open(url);
  }

}
