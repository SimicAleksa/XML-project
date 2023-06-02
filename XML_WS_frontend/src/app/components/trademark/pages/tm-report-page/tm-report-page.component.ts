import { Component, OnInit } from '@angular/core';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';
import { XMLParser } from 'src/app/utils/XMLParser';
import * as pdfMake from "pdfmake/build/pdfmake";
import * as pdfFonts from "pdfmake/build/vfs_fonts";

@Component({
  selector: 'app-tm-report-page',
  templateUrl: './tm-report-page.component.html',
  styleUrls: ['./tm-report-page.component.css']
})
export class TmReportPageComponent implements OnInit {
  public startDate: Date;
  public endDate: Date;
  public isStartDateInvalid: boolean;
  public isEndDateInvalid: boolean;


  constructor(private requestMaker: RequestMaker, private xmlParser: XMLParser, private lStorageManager: LocalStorageManager) { }

  ngOnInit(): void {
  }

  generateReport() {

    this.isStartDateInvalid = false;
    this.isEndDateInvalid = false;

    if (!this.startDate || !this.endDate) {
      this.isStartDateInvalid = !this.startDate;
      this.isEndDateInvalid = !this.endDate;
      return;
    }

    const start = new Date(this.startDate);
    const end = new Date(this.endDate);

    if (start > end) {
      this.isStartDateInvalid = true;
      this.isEndDateInvalid = true;
      return;
    }

    this.requestMaker
    .getTMReportData(this.getParamsDTO())
    .subscribe({
      next: (data: any) => {
        if (data.body !== undefined){
          let podaciIzvestaja = this.xmlParser.parseFromXml(
                                    data.body.replace(/<(\/?)(ns2:)/g, '<$1')
                                  ).ReportDTO;
          this.generatePDF(podaciIzvestaja)
          }
      }
    });
  }

  getParamsDTO() {
    let reqBody = {
      startDate: { _text: this.startDate },
      endDate: { _text: this.endDate },
    }
    console.log(this.xmlParser.parseToXml("ReportParamsDTO", reqBody));
    return this.xmlParser.parseToXml("ReportParamsDTO", reqBody);
  }

  generatePDF(podaciIzvestaja: any){
    console.log(podaciIzvestaja);
    const documentDefinition: any = {
      content: [
        { text: 'Izvestaj', style: 'header' },
        { text: 'OD: ' + this.startDate + '     DO: ' + this.endDate },
        { text: '_________________________________________________________'},
        { text: 'Ukupno podnetih: ' + podaciIzvestaja.ukupno._text },
        { text: 'Prihvaceni: ' + podaciIzvestaja.numOfPrihvaceno._text },
        { text: 'Odbijeni: ' + podaciIzvestaja.numOfOdbijeno._text },
        { text: '_________________________________________________________'},
      ],
      styles: {
        header: {
          alignment: 'center',
          fontSize: 24,
          bold: true,
          margin: [0, 0, 0, 10]
        }
      },
      defaultStyle: {
        fontSize: 18,
        alignment: 'center',
        margin: [0, 5, 0, 5]
      },
      pageMargins: [20, 20, 20, 20],
      pageBreakBefore: function(currentNode: any) {
        return currentNode.id === 'header';
      },
      background: function(currentPage: any, pageSize: any) {
        return {
          canvas: [{
            type: 'rect',
            x: 15,
            y: 15,
            w: pageSize.width-30,
            h: pageSize.height/2,
            lineWidth: 2,
            lineColor: '#000'
          }]
        };
      }
    };

    pdfMake.createPdf(documentDefinition, null, null, pdfFonts.pdfMake.vfs).open();
  }


}
