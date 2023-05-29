import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DeclineReqDialogComponent } from 'src/app/components/trademark/decline-req-dialog/decline-req-dialog.component';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { XMLParser } from 'src/app/utils/XMLParser';

@Component({
  selector: 'app-pending-patent-requests-page',
  templateUrl: './pending-patent-requests-page.component.html',
  styleUrls: ['./pending-patent-requests-page.component.css']
})
export class PendingPatentRequestsPageComponent implements OnInit {
  public pendingPATRequests: Array<any>;
  public selectedPAT: string;
  private obrazlozenje: string;
  private officialNameAndSurname: string;

  constructor(public dialog: MatDialog, private requestMaker: RequestMaker, private xmlParser: XMLParser) {
    this.pendingPATRequests = new Array<any>();
    this.fetchPendingRequests();
    this.selectedPAT = "Nista nije izabrano";
    this.obrazlozenje = "";
    this.getOfficialNameAndSurname()
  }

  ngOnInit(): void {
  }

  fetchPendingRequests(): void {
    this.requestMaker
      .getPendingPATRequests()
      .subscribe({
        next: (data: any) => {
          if (data.body !== undefined)
            this.pendingPATRequests = this.xmlParser.parseFromXml(
                                      data.body.replace(/<(\/?)(ns2:)/g, '<$1')
                                    ).ListOfPatentRequestsDTO.ZahtevZaPatent;
        }
    });
  }

  handleSelectedRow(patentNum: string) {
      this.selectedPAT = patentNum;
  }

  onPDFBtnClick() {
    if (this.nothingIsSelected())
      return;

    this.requestMaker
    .getPatentPDF(this.selectedPAT)
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

  onApproveBtnClick() {
    if (this.nothingIsSelected())
      return;
    
    this.requestMaker
    .sendNewPatentReqResenje(this.getApprovedResenje())
    .subscribe({
      error: () => {
        alert('Resenje nije poslato, nesto se desilo!');
      },
      complete: () => {
        this.removeSelectedPATFromList();
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
      .sendNewPatentReqResenje(this.getDeclinedResenje())
      .subscribe({
        error: () => {
          alert('Resenje nije poslato, nesto se desilo!');
        },
        complete: () => {
          this.removeSelectedPATFromList();
        }
      });
    });
  }

  nothingIsSelected(): Boolean {
    return this.selectedPAT === "Nista nije izabrano";
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
      brojPrijave: { _text: this.selectedPAT }, 
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

  removeSelectedPATFromList() {
    this.pendingPATRequests = this.pendingPATRequests.filter(pat => pat.popunjava_zavod.broj_prijave._text !== this.selectedPAT);
    this.selectedPAT = "Nista nije izabrano";
  }
}
