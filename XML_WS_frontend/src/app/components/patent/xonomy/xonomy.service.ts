import { Injectable } from '@angular/core';

declare var Xonomy:any;

@Injectable({
  providedIn: 'root'
})


export class XonomyService {
    constructor() {

    }
    public patentXonomy = {
        elements: {
          Zahtev_za_patent : {
                menu: [
                {
                    caption:'Dodaj <naziv_pronalaska>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<naziv_pronalaska></naziv_pronalaska>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("naziv_pronalaska")
                    },
                }
                ]
            },
            
            

            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////// naziv_pronalaska ////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            naziv_pronalaska : {
                asker: Xonomy.askString,
                menu:[
                {
                    caption:'Dodaj <na_srpskom_jeziku>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<na_srpskom_jeziku></na_srpskom_jeziku>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("na_srpskom_jeziku")
                    },
                },
                {
                    caption:'Dodaj <na_engleskom_jeziku>',
                    action: Xonomy.newElementChild,
                    actionParameter: '<na_engleskom_jeziku></na_engleskom_jeziku>',
                    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                        return jsElement.hasChildElement("na_engleskom_jeziku")
                    },
                },
                {
                    caption: 'Obrisi naziv pronalaska',
                    action: Xonomy.deleteElement
                }]
            },
            na_srpskom_jeziku : {
                mustBeBefore: ['na_engleskom_jeziku'],
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi srpski naziv',
                  action:Xonomy.deleteElement
                }
                ]
            },
            na_engleskom_jeziku : {
                hasText: true,
                oneliner: true,
                asker: Xonomy.askString,
                menu:[{
                  caption:'Obrisi engleski naziv',
                  action:Xonomy.deleteElement
                }
                ]
            },
          }
        }
      }

