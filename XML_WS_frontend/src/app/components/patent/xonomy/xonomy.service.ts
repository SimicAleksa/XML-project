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
                },
                {
                  caption:'Dodaj <podnosilac_prijave>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<podnosilac_prijave></podnosilac_prijave>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("podnosilac_prijave")
                  },
              }
                ]
            },

            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////// podnosilac_prijave ////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            podnosilac_prijave : {
              asker: Xonomy.askString,
              menu:[
              {
                  caption:'Dodaj <podnosilac_prijave_je_i_pronalazac>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<podnosilac_prijave_je_i_pronalazac></podnosilac_prijave_je_i_pronalazac>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("podnosilac_prijave_je_i_pronalazac")
                  },
              },
              {
                  caption:'Dodaj <licni_podaci>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<licni_podaci></licni_podaci>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("licni_podaci")
                  },
              },
              {
                  caption: 'Obrisi naziv pronalaska',
                  action: Xonomy.deleteElement
              }]
          },

          licni_podaci : {
            asker: Xonomy.askString,
            menu:[
            {
                caption:'Dodaj <fizicko_pravno_lice>',
                action: Xonomy.newElementChild,
                actionParameter: '<fizicko_pravno_lice></fizicko_pravno_lice>',
                hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                    return jsElement.hasChildElement("fizicko_pravno_lice")
                },
            },
            {
                caption:'Dodaj <drzavljanstvo>',
                action: Xonomy.newElementChild,
                actionParameter: '<drzavljanstvo></drzavljanstvo>',
                hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                    return jsElement.hasChildElement("drzavljanstvo")
                },
            },
            {
              caption:'Dodaj <adresa>',
              action: Xonomy.newElementChild,
              actionParameter: '<adresa></adresa>',
              hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                  return jsElement.hasChildElement("adresa")
              },
            },
            {
              caption:'Dodaj <dodatni_podaci>',
              action: Xonomy.newElementChild,
              actionParameter: '<dodatni_podaci></dodatni_podaci>',
              hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                  return jsElement.hasChildElement("dodatni_podaci")
              },
            },
            {
              caption:'Obrisi licne podatke',
              action:Xonomy.deleteElement
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

