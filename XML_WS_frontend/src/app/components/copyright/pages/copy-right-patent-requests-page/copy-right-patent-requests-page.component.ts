import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DeclineReqDialogComponent } from 'src/app/components/trademark/decline-req-dialog/decline-req-dialog.component';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { XMLParser } from 'src/app/utils/XMLParser';

@Component({
  selector: 'app-copy-right-patent-requests-page',
  templateUrl: './copy-right-patent-requests-page.component.html',
  styleUrls: ['./copy-right-patent-requests-page.component.css']
})
export class CopyRightRequestsPageComponent implements OnInit {
  public pendingCRRequests: Array<any>;
  public selectedCR: string;
  private obrazlozenje: string;
  private officialNameAndSurname: string;

  constructor(public dialog: MatDialog, private requestMaker: RequestMaker, private xmlParser: XMLParser) {
    this.pendingCRRequests = new Array<any>();
    this.fetchPendingRequests();
    this.selectedCR = "Nista nije izabrano";
    this.obrazlozenje = "";
    // this.getOfficialNameAndSurname()
    this.officialNameAndSurname= "Temp Tempic"
  }

  ngOnInit(): void {
  }

  fetchPendingRequests(): void {
    this.requestMaker
      .getPendingCRRequests()
      .subscribe({
        next: (data: any) => {
          if (data.body !== undefined)
            this.pendingCRRequests = this.xmlParser.parseFromXml(
                                      data.body.replace(/<(\/?)(ns2:)/g, '<$1')
                                    ).ListOfCopyRightRequestsDTO.ZahtevZaAutorskoPravo;
        }
    });
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

  onApproveBtnClick() {
    if (this.nothingIsSelected())
      return;
    
    this.requestMaker
    .sendNewCopyRightReqResenje(this.getApprovedResenje())
    .subscribe({
      error: () => {
        alert('Resenje nije poslato, nesto se desilo!');
      },
      complete: () => {
        this.removeSelectedCRFromList();
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
      .sendNewCopyRightReqResenje(this.getDeclinedResenje())
      .subscribe({
        error: () => {
          alert('Resenje nije poslato, nesto se desilo!');
        },
        complete: () => {
          this.removeSelectedCRFromList();
        }
      });
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
  

  getApprovedResenje() {
    return this.getResenje(true, "");
  }

  getDeclinedResenje() {
    return this.getResenje(false, this.obrazlozenje)
  }

  getResenje(isApproved: boolean, obrazlozenje: string) {
    const reqBody = {
      brojPrijave: { _text: this.selectedCR }, 
      datumPodnosenjaResenja: { _text: new Date().toISOString().slice(0, 19) }, 
      sluzbenikImeIPrezime: { _text: this.officialNameAndSurname }, 
      jePrihvacen: { _text: isApproved },
      obrazlozenje: { _text: obrazlozenje }
    };
    return this.xmlParser.parseToXml("ResenjeZahteva", reqBody);
  }

  // getOfficialNameAndSurname() {
  //   this.requestMaker.fetchUserInfo().subscribe({
  //     next: (retData: any) => {
  //       if (retData.body !== undefined) {
  //         retData = this.xmlParser.parseFromXml(retData.body).UserInfoDTO;
  //         this.officialNameAndSurname = retData.firstname._text + " " + retData.lastname._text;
  //       }
  //     }
  //   });
  // }

  removeSelectedCRFromList() {
    this.pendingCRRequests = this.pendingCRRequests.filter(cr => cr.broj_prijave._text !== this.selectedCR);
    this.selectedCR  = "Nista nije izabrano";
  }
}
