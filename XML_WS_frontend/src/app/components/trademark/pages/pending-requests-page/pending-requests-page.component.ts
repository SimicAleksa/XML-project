import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { XMLParser } from 'src/app/utils/XMLParser';
import { DeclineReqDialogComponent } from '../../decline-req-dialog/decline-req-dialog.component';

@Component({
  selector: 'app-pending-requests-page',
  templateUrl: './pending-requests-page.component.html',
  styleUrls: ['./pending-requests-page.component.css']
})
export class PendingRequestsPageComponent implements OnInit {
  public pendingTMRequests: Array<any>;
  public selectedTM: string;
  private obrazlozenje: string;
  private officialNameAndSurname: string;

  constructor(public dialog: MatDialog, private requestMaker: RequestMaker, private xmlParser: XMLParser) {
    this.pendingTMRequests = new Array<any>();
    this.fetchPendingRequests();
    this.selectedTM = "Nista nije izabrano";
    this.obrazlozenje = "";
    this.getOfficialNameAndSurname()
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
    
    this.requestMaker
    .sendNewTrademarkReqResenje(this.getApprovedResenje())
    .subscribe({
      error: () => {
        alert('Resenje nije poslato, nesto se desilo!');
      },
      complete: () => {
        this.removeSelectedTMFromList();
      }
    });
  }

  onDeclineBtnClick() {
    if (this.nothingIsSelected())
      return;
 
    const dialogRef = this.dialog.open(DeclineReqDialogComponent);
    dialogRef.componentInstance.submitValue.subscribe((obrazlozenje: string) => {
      this.obrazlozenje = obrazlozenje;
      this.requestMaker
      .sendNewTrademarkReqResenje(this.getDeclinedResenje())
      .subscribe({
        error: () => {
          alert('Resenje nije poslato, nesto se desilo!');
        },
        complete: () => {
          this.removeSelectedTMFromList();
        }
      });
    });
  }

  nothingIsSelected(): Boolean {
    return this.selectedTM === "Nista nije izabrano";
  }

  openPDF(bytesAsStr: string, mime: string) {
    const blob = new Blob([require('buffer').Buffer.from(bytesAsStr, 'base64')], { type: mime });
    const url = window.URL.createObjectURL(blob);
    window.open(url);
  }
  

  getApprovedResenje() {
    return this.getResenje(true, "");
  }

  getDeclinedResenje() {
    return this.getResenje(false, this.obrazlozenje)
  }

  getResenje(isApproved: boolean, obrazlozenje: string) {
    const reqBody = {
      brojPrijave: { _text: this.selectedTM }, 
      datumPodnosenjaResenja: { _text: new Date().toISOString().slice(0, 19) }, 
      sluzbenikImeIPrezime: { _text: this.officialNameAndSurname }, 
      jePrihvacen: { _text: isApproved },
      obrazlozenje: { _text: obrazlozenje }
    };
    return this.xmlParser.parseToXml("ResenjeZahteva", reqBody);
  }

  getOfficialNameAndSurname() {
    this.requestMaker.fetchUserInfo().subscribe({
      next: (retData: any) => {
        if (retData.body !== undefined) {
          retData = this.xmlParser.parseFromXml(retData.body).UserInfoDTO;
          this.officialNameAndSurname = retData.firstname._text + " " + retData.lastname._text;
        }
      }
    });
  }

  removeSelectedTMFromList() {
    this.pendingTMRequests = this.pendingTMRequests.filter(tm => tm.MetaData.BrojPrijave._text !== this.selectedTM);
    this.selectedTM = "Nista nije izabrano";
  }
}
