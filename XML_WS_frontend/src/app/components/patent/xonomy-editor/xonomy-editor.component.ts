import { AfterViewInit, Component, OnInit } from '@angular/core';
import { XonomyService } from '../xonomy/xonomy.service';

declare var Xonomy:any;

@Component({
  selector: 'app-xonomy-editor',
  templateUrl: './xonomy-editor.component.html',
  styleUrls: ['./xonomy-editor.component.css']
})
export class XonomyEditorComponent implements OnInit, AfterViewInit {

  constructor(private xonomyService: XonomyService) { }

  ngAfterViewInit(): void {
    let element = document.getElementById("xonomy-editor");
    let specification = this.xonomyService.patentXonomy;
    let xmlString = '<Zahtev_za_patent></Zahtev_za_patent>';
    Xonomy.render(xmlString, element, specification);
  }

  ngOnInit(): void {
    
  }
}
