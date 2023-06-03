import { Injectable } from '@angular/core';
import { RequestMaker } from '../services/request-maker.service';


@Injectable()
export class MetadataTabOpener {
    constructor(private requestMaker: RequestMaker) { }

    openTrademarkMetadataAsRDF() {
        this.requestMaker
        .getTMMetadataRDF()
        .subscribe({
          next: (data: any) => {
            if (data.body !== undefined)
                this.openTextInNewTab(data.body);
          }
        });
    }

    openTrademarkMetadataAsJSON() {
        this.requestMaker
        .getTMMetadataJSON()
        .subscribe({
          next: (data: any) => {
            if (data.body !== undefined)
                this.openTextInNewTab(data.body);
          }
        });
    }


  openPatentMetadataAsRDF() {
    this.requestMaker
    .getPATMetadataRDF()
    .subscribe({
      next: (data: any) => {
        if (data.body !== undefined)
            this.openTextInNewTab(data.body);
      }
    });
  }

  openPatentMetadataAsJSON() {
      this.requestMaker
      .getPATMetadataJSON()
      .subscribe({
        next: (data: any) => {
          if (data.body !== undefined)
              this.openTextInNewTab(data.body);
        }
      });
  }


  openCopyRightMetadataAsRDF() {
    this.requestMaker
    .getCRMetadataRDF()
    .subscribe({
      next: (data: any) => {
        if (data.body !== undefined)
            this.openTextInNewTab(data.body);
      }
    });
  }

  openCopyRightMetadataAsJSON() {
      this.requestMaker
      .getCRMetadataJSON()
      .subscribe({
        next: (data: any) => {
          if (data.body !== undefined)
              this.openTextInNewTab(data.body);
        }
      });
  }




    openTextInNewTab(textContent: string) {
        const newTab = window.open('', 'metadata');
        if (newTab !== null) {
            newTab.document.open();
            newTab.document.write(`<pre>${textContent.replace(new RegExp("<", 'g'), "&lt;")}</pre>`);
            newTab.document.close();
        }
    }

}
