import { Component, OnInit } from '@angular/core';
import { RequestMaker } from 'src/app/services/request-maker.service';
import { LocalStorageManager } from 'src/app/utils/LocalStorageManager';
import { XMLParser } from 'src/app/utils/XMLParser';

@Component({
  selector: 'app-tm-basic-search-page',
  templateUrl: './tm-basic-search-page.component.html',
  styleUrls: ['./tm-basic-search-page.component.css']
})
export class TmBasicSearchPageComponent implements OnInit {
  public searchResult: Array<any> = [];

  public searchQuery: string = '';

  constructor(private requestMaker: RequestMaker, private xmlParser: XMLParser, private lStorageManager: LocalStorageManager) {
  }

  ngOnInit(): void {
  }

  performBasicSearch() {
    let params = this.getParamsFromSearchQuery();
    if (params.length === 0) 
      return;
 
    this.requestMaker
    .doTMBasicSearch(this.getParamsDTO(params))
    .subscribe({
      next: (data: any) => {
        if (data.body !== undefined)
          this.searchResult = this.xmlParser.parseFromXml(
                                    data.body.replace(/<(\/?)(ns2:)/g, '<$1')
                                  ).ListOfTrademarkRequestsDTO.ZahtevZaPriznanjeZiga;
      }
    });
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
}
