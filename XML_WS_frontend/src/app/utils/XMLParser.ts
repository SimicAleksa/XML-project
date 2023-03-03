import { Injectable } from '@angular/core';


@Injectable()
export class XMLParser {
  private converter = require('xml-js');
  private options: any = {compact: true, ignoreComment: true, spaces: 4};

  constructor() { }

  parseToXml(rootName: string, dataBody: any): any {
    let formDataAsXml = { 
      _declaration: { _attributes: { version: '1.0', encoding: 'utf-8' } },
      [`${rootName}`]: dataBody
    };
    return this.converter.js2xml(formDataAsXml, this.options)
  }

  parseFromXml(xmlString: string): any {
    return this.converter.xml2js(xmlString, this.options);
  }

}
