import { Component, OnInit } from '@angular/core';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';
import { XMLParser } from 'src/app/utils/XMLParser';

@Component({
  selector: 'app-patent-advanced-search',
  templateUrl: './patent-advanced-search.component.html',
  styleUrls: ['./patent-advanced-search.component.css']
})
export class PatentAdvancedSearchComponent implements OnInit {

    public searchResult: Array<any> = [];
    public selectedPAT: string = "Nista nije izabrano";
  
    public statusFilters: Array<{toNeg: boolean, value: string, followingOperator: string}> = [];
    public statusFiltersTxt: string = "";
    public stsValueSelection: string = "NERESENO";
    public stsNegSelection: string = "false";
    public stsLogOpSelection: string = "";
  
    public emailFilters: Array<{toNeg: boolean, value: string, followingOperator: string}> = [];
    public emailFiltersTxt: string = "";
    public emailValueInp: string = "";
    public emailNegSelection: string = "false";
    public emailLogOpSelection: string = "";
  
    public dateFilters: Array<{value: string, dateOperator: string, followingOperator: string}> = [];
    public dateFiltersTxt: string = "";
    public dateValueInp: string = "";
    public dateOpSelection: string = "<";
    public dateLogOpSelection: string = "";
  
  
    public datePregledanoFilters: Array<{value: string, dateOperator: string, followingOperator: string}> = [];
    public datePregledanoFiltersTxt: string = "";
    public datePregledanoValueInp: string = "";
    public datePregledanoOpSelection: string = "<";
    public datePregledanoLogOpSelection: string = "";
  
  
    public isRegualr = this.lStorageManager.getUserRole() === "REGULAR"
  
  
    constructor(private requestMaker: RequestMaker, private xmlParser: XMLParser, private lStorageManager: LocalStorageManager) { }
  
    ngOnInit(): void {
    }
  
    performAdvancedSearch() {
      this.requestMaker
      .doPATAdvancedSearch(this.searchFormToDTO())
      .subscribe({
        next: (data: any) => {
          if (data.body !== undefined){
            if(this.datePregledanoFilters.length>0 && this.statusFiltersTxt.includes("NERESENO") && !this.statusFiltersTxt.includes("!NERESENO"))
            {
              alert("Nije pronadjen ni jedan zahtev za date filtere!")
              this.searchResult = [];
            }
            else if(this.datePregledanoFilters.length>0)
              {
                let temp = this.xmlParser.parseFromXml(
                  data.body.replace(/<(\/?)(ns2:)/g, '<$1')
                ).ListOfPatentRequestsDTO.ZahtevZaPatent;

                if (temp === undefined) {
                  alert("Nije pronadjen ni jedan zahtev za date filtere!")
                  this.searchResult = [];
                }
                else{
                  if(Array.isArray(temp))
                    this.searchResult = temp.filter((item: {popunjava_zavod: { datum_pregledanja: { _text: string; }; }; }) => item.popunjava_zavod.datum_pregledanja._text!== '1900-01-01T00:00:00');
                  else
                    {
                      if(temp.datum_pregledanja._text!=='1900-01-01T00:00:00')
                        this.searchResult=temp
                    }
                }
              }
            else{
              this.searchResult = this.xmlParser.parseFromXml(
                data.body.replace(/<(\/?)(ns2:)/g, '<$1')
              ).ListOfPatentRequestsDTO.ZahtevZaPatent;
            }
          }
          if (this.searchResult === undefined) {
            alert("Nije pronadjen ni jedan zahtev za date filtere!")
            this.searchResult = [];
          }
        }
  
      });
      this.selectedPAT = "Nista nije izabrano";
    }
  
    searchFormToDTO() {
      let reqBody = {
        onlyApproved: { _text: this.lStorageManager.getUserRole() === "REGULAR" },
        statusFilter: this.convertStatusForm(),
        emailNalogaPodnosiocaFilter: this.convertEmailForm(),
        datumPodnosenjaFilter: this.convertDateForm(),
        datumPregledanjaFilter: this.convertPregledanjeDateForm()
      }
  
      return this.xmlParser.parseToXml("ComplexSearchParamsDTO", reqBody);
    }
  
    convertStatusForm() {
      let filters = new Array<any>();
      this.statusFilters.forEach(f => {
        filters.push({
          toNeg: { _text: f.toNeg }, 
          value: { _text: f.value }, 
          followingOperator: { _text: f.followingOperator }
        });
      });
      return filters
    }
  
    convertEmailForm() {
      let filters = new Array<any>();
      this.emailFilters.forEach(f => {
        filters.push({
          toNeg: { _text: f.toNeg }, 
          value: { _text: f.value }, 
          followingOperator: { _text: f.followingOperator }
        });
      });
      return filters
    }
  
    convertDateForm() {
      let filters = new Array<any>();
      this.dateFilters.forEach(f => {
        filters.push({
          value: { _text: f.value }, 
          dateOperator: { _text: f.dateOperator }, 
          followingOperator: { _text: f.followingOperator }
        });
      });
      return filters
    }
  
    convertPregledanjeDateForm() {
      let filters = new Array<any>();
      this.datePregledanoFilters.forEach(f => {
        filters.push({
          value: { _text: f.value }, 
          dateOperator: { _text: f.dateOperator }, 
          followingOperator: { _text: f.followingOperator }
        });
      });
      return filters
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
  
    nothingIsSelected(): Boolean {
      return this.selectedPAT === "Nista nije izabrano";
    }
  
    openPDF(bytesAsStr: string, mime: string) {
      const blob = new Blob([require('buffer').Buffer.from(bytesAsStr, 'base64')], { type: mime });
      const url = window.URL.createObjectURL(blob);
      window.open(url);
    }
  
    // -------STATUS---------------------------------------------------------
    addStatusFilter(): void {
      const newFilter = {
        toNeg: this.stsNegSelection == "true" ? true : false, 
        value: this.stsValueSelection, 
        followingOperator: this.stsLogOpSelection
      }
  
      if (!this.validateNextStsFilter()) {
        alert("Novi filter status nije validan!");
        return;
      }
  
      this.statusFiltersTxt += `${newFilter.toNeg ? "!" : ""}${newFilter.value} ${newFilter.followingOperator} `;
      this.statusFilters.push(newFilter);
    }
  
    resetStatusFilters(): void {
      this.statusFilters = [];
      this.statusFiltersTxt = "";
    }
    
    validateNextStsFilter(): boolean {
      if (this.statusFilters.length === 0)
        return true;
      
      if (this.statusFilters[this.statusFilters.length-1].followingOperator === "")
        return false;
  
      return true;
  
    }
    // ----------------------------------------------------------------------
  
    // -----EMAIL------------------------------------------------------------
  
    addEmailFilter(): void {
      const newFilter = {
        toNeg: this.emailNegSelection == "true" ? true : false, 
        value: this.emailValueInp, 
        followingOperator: this.emailLogOpSelection
      }
  
      if (!this.validateNextEmailFilter()) {
        alert("Novi filter email-a nije validan!");
        return;
      }
  
      this.emailFiltersTxt += `${newFilter.toNeg ? "ne_sadrzi" : "sadrzi"}(${newFilter.value}) ${newFilter.followingOperator} `;
      this.emailFilters.push(newFilter);
    }
  
    resetEmailFilters(): void {
      this.emailFilters = [];
      this.emailFiltersTxt = "";
    }
    
    validateNextEmailFilter(): boolean {
      if (this.emailValueInp === "")
        return false;
  
      if (this.emailFilters.length === 0)
        return true;
      
      if (this.emailFilters[this.emailFilters.length-1].followingOperator === "")
        return false;
  
      return true;
    }
  
    // ----------------------------------------------------------------------
  
    // -----DATUM------------------------------------------------------------
    
    addDateFilter(): void {
      let dateConverted = new Date(this.dateValueInp);
      const newFilter = {
        value: `${dateConverted.getFullYear()}-${(dateConverted.getMonth() + 1).toString().padStart(2, '0')}-${dateConverted.getDate()}`, 
        dateOperator: this.dateOpSelection, 
        followingOperator: this.dateLogOpSelection
      }
  
      if (!this.validateNextDateFilter()) {
        alert("Novi filter datuma nije validan!");
        return;
      }
      console.log(123);
      this.dateFiltersTxt += `${newFilter.dateOperator === "<" ? "PRE" : "POSLE"}(${newFilter.value}) ${newFilter.followingOperator} `;
      this.dateFilters.push(newFilter);
    }
  
    resetDateFilters(): void {
      this.dateFilters = [];
      this.dateFiltersTxt = "";
    }
    
    validateNextDateFilter(): boolean {
      if (this.dateValueInp === "")
        return false;
  
      if (this.dateFilters.length === 0)
        return true;
      
        if (this.dateFilters[this.dateFilters.length-1].followingOperator === "")
        return false;
  
      return true;
    }
  
    // ----------------------------------------------------------------------
  
    // -----DATUM PREGLEDANO------------------------------------------------------------
    
    addPregledanoDateFilter(): void {
      let dateConverted = new Date(this.datePregledanoValueInp);
      const newFilter = {
        value: `${dateConverted.getFullYear()}-${(dateConverted.getMonth() + 1).toString().padStart(2, '0')}-${dateConverted.getDate()}`, 
        dateOperator: this.datePregledanoOpSelection, 
        followingOperator: this.datePregledanoLogOpSelection
      }
  
      if (!this.validateNextPregledanoDateFilter()) {
        alert("Novi filter datuma nije validan!");
        return;
      }
      console.log(123);
      this.datePregledanoFiltersTxt += `${newFilter.dateOperator === "<" ? "PRE" : "POSLE"}(${newFilter.value}) ${newFilter.followingOperator} `;
      this.datePregledanoFilters.push(newFilter);
    }
  
    resetPregledanoDateFilters(): void {
      this.datePregledanoFilters = [];
      this.datePregledanoFiltersTxt = "";
    }
    
    validateNextPregledanoDateFilter(): boolean {
      if (this.datePregledanoValueInp === "")
        return false;
  
      if (this.datePregledanoFilters.length === 0)
        return true;
      
        if (this.datePregledanoFilters[this.datePregledanoFilters.length-1].followingOperator === "")
        return false;
  
      return true;
    }
  
    // ----------------------------------------------------------------------
  
  }
  
  