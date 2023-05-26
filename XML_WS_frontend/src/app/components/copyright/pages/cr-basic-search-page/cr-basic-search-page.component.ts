import { Component, OnInit } from '@angular/core';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';
import { XMLParser } from 'src/app/utils/XMLParser';

@Component({
  selector: 'app-cr-basic-search-page',
  templateUrl: './cr-basic-search-page.component.html',
  styleUrls: ['./cr-basic-search-page.component.css']
})
export class CrBasicSearchPageComponent implements OnInit {
  public searchResult: Array<any> = [];
  public searchQuery: string = '';
  public selectedCR: string = "Nista nije izabrano";

  constructor(private requestMaker: RequestMaker, private xmlParser: XMLParser, private lStorageManager: LocalStorageManager) {
  }

  ngOnInit(): void {
  }

  performBasicSearch() {
    let params = this.getParamsFromSearchQuery();
    console.log(params);
    
    if (params.length === 0) 
      return;
 
    this.requestMaker
    .doCRBasicSearch(this.getParamsDTO(params))
    .subscribe({
      next: (data: any) => {
        if (data.body !== undefined)
          this.searchResult = this.xmlParser.parseFromXml(
                                    data.body.replace(/<(\/?)(ns2:)/g, '<$1')
                                  ).ListOfCopyRightRequestsDTO.ZahtevZaAutorskoPravo;
      }
    });
    this.selectedCR = "Nista nije izabrano";
  }

  getParamsFromSearchQuery() {
    const regex = /"([^"]*)"/g;
    const matches = this.searchQuery.match(regex);
    return matches ? matches.map(match => match.slice(1, -1)).filter(param => param !== "") : [];
  }

  getParamsDTO(params: Array<string>) {
    let reqBody = {
      onlyApproved: { _text: this.lStorageManager.getUserRole() === "REGULAR" },
      param: params
    }
    return this.xmlParser.parseToXml("BasicSearchParamsDTO", reqBody);
  }

  handleSelectedRow(crNum: string) {
    this.selectedCR = crNum;
  }

  onPDFBtnClick() {
    if (this.nothingIsSelected())
      return;

    this.requestMaker
    .getCopyRightPDF(this.selectedCR)
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
    .getCopyRightXHTML(this.selectedCR)
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

  nothingIsSelected(): Boolean {
    return this.selectedCR === "Nista nije izabrano";
  }

  openPDF(bytesAsStr: string, mime: string) {
    const blob = new Blob([require('buffer').Buffer.from(bytesAsStr, 'base64')], { type: mime });
    const url = window.URL.createObjectURL(blob);
    window.open(url);
  }
  
  
}
