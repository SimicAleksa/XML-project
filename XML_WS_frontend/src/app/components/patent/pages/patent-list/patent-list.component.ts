import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort, Sort } from '@angular/material/sort';

export interface TableData {
  oznaka: string;
  vremePodnosenjaZahteva: string;
  status: string;
  // emailNalogaPodnosioca: string;
}

@Component({
  selector: 'app-patent-list',
  templateUrl: './patent-list.component.html',
  styleUrls: ['./patent-list.component.css']
})
export class PatentListComponent implements OnInit {
  // displayedColumns: string[] = ['oznaka', 'vremePodnosenjaZahteva', 'status', 'emailNalogaPodnosioca'];
  displayedColumns: string[] = ['oznaka', 'vremePodnosenjaZahteva', 'status'];
  dataSource: MatTableDataSource<TableData>;
  @ViewChild(MatSort) sort: MatSort;

  @Input() patents: any;
  @Output() onRowClickEventEmit = new EventEmitter<string>();

  constructor() {
    this.setMatTableDataSrouce();
  }
  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['patents'])
      this.setMatTableDataSrouce();
  }
  
  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  setMatTableDataSrouce() {
    this.dataSource = new MatTableDataSource(this.convertPatentsToTableData());
  }

  convertPatentsToTableData() {
    let rows = new Array<TableData>();
    if (this.patents !== undefined)
      if (!Array.isArray(this.patents)) {
        let metaData = this.patents.popunjava_zavod;
        rows.push({
          oznaka: metaData.broj_prijave._text,
          vremePodnosenjaZahteva: this.convertDatetimeForTable(metaData.priznati_datum_podnosenja._text),
          status: metaData.status._text,
          // emailNalogaPodnosioca: metaData.EmailNalogaPodnosioca._text
        });
      }
      else
       this.patents.forEach(pat => {
        let metaData = pat.popunjava_zavod;
        rows.push({
          oznaka: metaData.broj_prijave._text,
          vremePodnosenjaZahteva: this.convertDatetimeForTable(metaData.priznati_datum_podnosenja._text),
          status: metaData.status._text,
          // emailNalogaPodnosioca: metaData.EmailNalogaPodnosioca._text
        })
      });
    return rows;
  }

  sortData(sort: Sort) {
    const data = this.dataSource.data.slice();
    if (!sort.active || sort.direction === '') {
      this.dataSource.data = data;
      return;
    }
    this.dataSource.data = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'oznaka': return this.compare(a.oznaka, b.oznaka, isAsc);
        case 'vremePodnosenjaZahteva': return this.compare(a.vremePodnosenjaZahteva, b.vremePodnosenjaZahteva, isAsc);
        case 'status': return this.compare(a.status, b.status, isAsc);
        // case 'emailNalogaPodnosioca': return this.compare(a.emailNalogaPodnosioca, b.emailNalogaPodnosioca, isAsc);
        default: return 0;
      }
    });
  }

  compare(a: string | number, b: string | number, isAsc: boolean) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
  }

  onRowClick(row: TableData) {
    this.onRowClickEventEmit.emit(row.oznaka);
  }

  convertDatetimeForTable(dt: string) {
    const date = new Date(dt);
    const formattedTime = `${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}:${date.getSeconds().toString().padStart(2, '0')}`;
    const formattedDate = `${date.getDate().toString().padStart(2, '0')}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getFullYear()}`;
    return `${formattedTime} ${formattedDate}`;
  }

}
