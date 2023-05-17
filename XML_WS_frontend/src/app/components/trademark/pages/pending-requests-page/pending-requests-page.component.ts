import { Component, OnInit } from '@angular/core';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { XMLParser } from 'src/app/utils/XMLParser';

@Component({
  selector: 'app-pending-requests-page',
  templateUrl: './pending-requests-page.component.html',
  styleUrls: ['./pending-requests-page.component.css']
})
export class PendingRequestsPageComponent implements OnInit {
  public pendingTMRequests: Array<any>;
  public selectedTM: string;

  constructor(private requestMaker: RequestMaker, private xmlParser: XMLParser) {
    this.pendingTMRequests = new Array<any>();
    this.fetchPendingRequests();
    this.selectedTM = "Nista nije izabrano";
  }

  ngOnInit(): void {
  }

  fetchPendingRequests(): void {
    this.requestMaker
      .getPendingTMRequests()
      .subscribe({
        next: (data: any) => {
          if (data.body !== undefined)
            this.pendingTMRequests = this.xmlParser.parseFromXml(
                                      data.body.replace(/<(\/?)(ns2:)/g, '<$1')
                                    ).ListOfTrademarkRequestsDTO.ZahtevZaPriznanjeZiga;
        }
    });
  }

  handleSelectedRow(trademarkNum: string) {
      this.selectedTM = trademarkNum;
  }

  onPDFBtnClick() {
    if (this.nothingIsSelected())
      return;

    this.requestMaker
    .getTrademarkPDF(this.selectedTM)
    .subscribe({
      next: (data: any) => {
        if (data.body !== undefined)
          this.openPDF(this.xmlParser.parseFromXml(data.body).PDFBytesDTO.Bytes._text, 'application/pdf');
      },
      error: () => {
        alert('Pdf nije generisan, nesto se desilo!');
      }
    });
  }

  onXHTMLBtnClick() {
    if (this.nothingIsSelected())
      return;
    
    this.requestMaker
    .getTrademarkXHTML(this.selectedTM)
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

  onApproveBtnClick() {
    if (this.nothingIsSelected())
      return;
    
  }

  onDeclineBtnClick() {
    if (this.nothingIsSelected())
      return;
    
  }

  nothingIsSelected(): Boolean {
    return this.selectedTM === "Nista nije izabrano";
  }

  openPDF(bytesAsStr: string, mime: string) {
    const blob = new Blob([require('buffer').Buffer.from(bytesAsStr, 'base64')], { type: mime });
    const url = window.URL.createObjectURL(blob);
    window.open(url);
  }

}
