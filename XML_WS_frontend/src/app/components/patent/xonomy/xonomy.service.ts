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
                },
                {
                  caption:'Dodaj <pronalazac>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<pronalazac></pronalazac>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("pronalazac")
                  },
                },
                {
                  caption:'Dodaj <punomocnik>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<punomocnik></punomocnik>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("punomocnik")
                  },
                },
                {
                  caption:'Dodaj <dostavljanje_podaci>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<dostavljanje_podaci></dostavljanje_podaci>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("dostavljanje_podaci")
                  },
                },
                {
                  caption:'Dodaj <prijava>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<prijava></prijava>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("prijava")
                  },
                },
                {
                  caption:'Dodaj <zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava></zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava")
                  },
                }
                ]
            },



            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////// zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava /////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava : {
              asker: Xonomy.askString,
              menu:[
              {
                  caption:'Dodaj <ranija_prijava>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<ranija_prijava></ranija_prijava>',
              },
              {
                  caption: 'Obrisi zahtev za priznanje prava prvenstva iz ranijih prijava',
                  action: Xonomy.deleteElement
              },
            ]
          },

          ranija_prijava : {
            asker: Xonomy.askString,
            menu:[
              {
                caption:'Dodaj <datum_podnosenja_ranije_prijave>',
                action: Xonomy.newElementChild,
                actionParameter: '<datum_podnosenja_ranije_prijave></datum_podnosenja_ranije_prijave>',
                hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                    return jsElement.hasChildElement("datum_podnosenja_ranije_prijave")
                },
            },
            {
              caption:'Dodaj <broj_ranije_prijave>',
              action: Xonomy.newElementChild,
              actionParameter: '<broj_ranije_prijave></broj_ranije_prijave>',
              hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                  return jsElement.hasChildElement("broj_ranije_prijave")
              },
          },
          {
            caption:'Dodaj <dvoslovna_oznaka_drzave>',
            action: Xonomy.newElementChild,
            actionParameter: '<dvoslovna_oznaka_drzave></dvoslovna_oznaka_drzave>',
            hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                return jsElement.hasChildElement("dvoslovna_oznaka_drzave")
            },
        },
            
            {
                caption: 'Obrisi raniju prijavu',
                action: Xonomy.deleteElement
            },
          ]
        },

        datum_podnosenja_ranije_prijave : {
          hasText: true,
          oneliner: true,
          asker: Xonomy.askString,
          menu:[{
            caption:'Obrisi datum podnosenja ranije prijave',
            action:Xonomy.deleteElement
          }
          ]
      },

      broj_ranije_prijave : {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
        menu:[{
          caption:'Obrisi broj ranije prijave',
          action:Xonomy.deleteElement
        }
        ]
    },

    dvoslovna_oznaka_drzave : {
      hasText: true,
      oneliner: true,
      asker: Xonomy.askString,
      menu:[{
        caption:'Obrisi dvoslovna oznaka drzave',
        action:Xonomy.deleteElement
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


          podnosilac_prijave_je_i_pronalazac : {
            hasText: true,
            oneliner: true,
            asker: Xonomy.askPicklist,
            askerParameter: ["true" , "false"],
            menu:[{
              caption:'Obrisi podnosilac je pronalazac',
              action:Xonomy.deleteElement
            }
            ]
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

        ////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////

        fizicko_pravno_lice : {
          asker: Xonomy.askString,
          menu:[
          {
              caption:'Dodaj <fizicko_lice>',
              action: Xonomy.newElementChild,
              actionParameter: '<fizicko_lice></fizicko_lice>',
              hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                  return jsElement.hasChildElement("fizicko_lice")
              },
          },
          {
              caption:'Dodaj <pravno_lice>',
              action: Xonomy.newElementChild,
              actionParameter: '<pravno_lice></pravno_lice>',
              hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                  return jsElement.hasChildElement("pravno_lice")
              },
          },
          {
            caption:'Obrisi fizicko/pravno lice',
            action:Xonomy.deleteElement
          }
          ]
      },


      pravno_lice : {
        asker: Xonomy.askString,
        menu:[
        {
            caption:'Dodaj <poslovno_ime>',
            action: Xonomy.newElementChild,
            actionParameter: '<poslovno_ime></poslovno_ime>',
            hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                return jsElement.hasChildElement("poslovno_ime")
            },
        },
        {
          caption:'Obrisi pravno lice',
          action:Xonomy.deleteElement
        }
        ]
    },


    drzavljanstvo : {
      hasText: true,
      oneliner: true,
      asker: Xonomy.askString,
      menu:[{
        caption:'Obrisi drzavljanstvo',
        action:Xonomy.deleteElement
      }
      ]
  },


    poslovno_ime : {
      hasText: true,
      oneliner: true,
      asker: Xonomy.askString,
      menu:[{
        caption:'Obrisi poslovno ime',
        action:Xonomy.deleteElement
      }
      ]
  },

    fizicko_lice : {
      asker: Xonomy.askString,
      menu:[
      {
          caption:'Dodaj <ime>',
          action: Xonomy.newElementChild,
          actionParameter: '<ime></ime>',
          hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
              return jsElement.hasChildElement("ime")
          },
      },
      {
        caption:'Dodaj <prezime>',
        action: Xonomy.newElementChild,
        actionParameter: '<prezime></prezime>',
        hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
            return jsElement.hasChildElement("prezime")
        },
    },
      {
        caption:'Obrisi fizicko lice',
        action:Xonomy.deleteElement
      }
      ]
  },


  ime : {
    hasText: true,
    oneliner: true,
    asker: Xonomy.askString,
    menu:[{
      caption:'Obrisi  ime',
      action:Xonomy.deleteElement
    }
    ]
  },

  prezime : {
    hasText: true,
    oneliner: true,
    asker: Xonomy.askString,
    menu:[{
      caption:'Obrisi  prezime',
      action:Xonomy.deleteElement
    }
    ]
  },

  ulica : {
    hasText: true,
    oneliner: true,
    asker: Xonomy.askString,
    menu:[{
      caption:'Obrisi  ulicu',
      action:Xonomy.deleteElement
    }
    ]
  },

  broj_objekta : {
    hasText: true,
    oneliner: true,
    asker: Xonomy.askString,
    menu:[{
      caption:'Obrisi broj objekta',
      action:Xonomy.deleteElement
    }
    ]
  },

  postanski_broj : {
    hasText: true,
    oneliner: true,
    asker: Xonomy.askString,
    menu:[{
      caption:'Obrisi postanski broj',
      action:Xonomy.deleteElement
    }
    ]
  },

  mesto : {
    hasText: true,
    oneliner: true,
    asker: Xonomy.askString,
    menu:[{
      caption:'Obrisi  mesto',
      action:Xonomy.deleteElement
    }
    ]
  },

  drzava : {
    hasText: true,
    oneliner: true,
    asker: Xonomy.askString,
    menu:[{
      caption:'Obrisi  drzavu',
      action:Xonomy.deleteElement
    }
    ]
  },


  adresa : {
    asker: Xonomy.askString,
    menu:[
    {
        caption:'Dodaj <ulica>',
        action: Xonomy.newElementChild,
        actionParameter: '<ulica></ulica>',
        hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
            return jsElement.hasChildElement("ulica")
        },
    },
    {
        caption:'Dodaj <broj_objekta>',
        action: Xonomy.newElementChild,
        actionParameter: '<broj_objekta></broj_objekta>',
        hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
            return jsElement.hasChildElement("broj_objekta")
        },
    },
    {
      caption:'Dodaj <postanski_broj>',
      action: Xonomy.newElementChild,
      actionParameter: '<postanski_broj></postanski_broj>',
      hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
          return jsElement.hasChildElement("postanski_broj")
      },
    },
    {
        caption:'Dodaj <mesto>',
        action: Xonomy.newElementChild,
        actionParameter: '<mesto></mesto>',
        hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
            return jsElement.hasChildElement("mesto")
        },
    },
    {
      caption:'Dodaj <drzava>',
      action: Xonomy.newElementChild,
      actionParameter: '<drzava></drzava>',
      hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
          return jsElement.hasChildElement("drzava")
      },
    },
    {
      caption:'Obrisi adresu',
      action:Xonomy.deleteElement
    }
    ]
},


dodatni_podaci : {
  asker: Xonomy.askString,
  menu:[
  {
      caption:'Dodaj <broj_telefona>',
      action: Xonomy.newElementChild,
      actionParameter: '<broj_telefona></broj_telefona>',
      hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
          return jsElement.hasChildElement("broj_telefona")
      },
  },
  {
      caption:'Dodaj <broj_faksa>',
      action: Xonomy.newElementChild,
      actionParameter: '<broj_faksa></broj_faksa>',
      hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
          return jsElement.hasChildElement("broj_faksa")
      },
  },
  {
    caption:'Dodaj <e_posta>',
    action: Xonomy.newElementChild,
    actionParameter: '<e_posta></e_posta>',
    hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
        return jsElement.hasChildElement("e_posta")
    },
},
  {
    caption:'Obrisi dodatne podatke',
    action:Xonomy.deleteElement
  }
  ]
},


broj_telefona : {
  hasText: true,
  oneliner: true,
  asker: Xonomy.askString,
  menu:[{
    caption:'Obrisi broj telefona',
    action:Xonomy.deleteElement
  }
  ]
},

broj_faksa : {
  hasText: true,
  oneliner: true,
  asker: Xonomy.askString,
  menu:[{
    caption:'Obrisi broj faksa',
    action:Xonomy.deleteElement
  }
  ]
},

e_posta : {
  hasText: true,
  oneliner: true,
  asker: Xonomy.askString,
  menu:[{
    caption:'Obrisi e_postu',
    action:Xonomy.deleteElement
  }
  ]
},

            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////// dostavljanje_podaci ////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            dostavljanje_podaci : {
              asker: Xonomy.askString,
              menu:[
              {
                  caption:'Dodaj <adresa>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<adresa></adresa>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("adresa")
                  },
              },
              {
                  caption:'Dodaj <podnosilac_saglasan_dostavljanje_elektronskim_putem>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<podnosilac_saglasan_dostavljanje_elektronskim_putem></podnosilac_saglasan_dostavljanje_elektronskim_putem>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("podnosilac_saglasan_dostavljanje_elektronskim_putem")
                  },
              },
              {
                caption:'Dodaj <podnosilac_saglasan_dostavljanje_u_papirnoj_formi>',
                action: Xonomy.newElementChild,
                actionParameter: '<podnosilac_saglasan_dostavljanje_u_papirnoj_formi></podnosilac_saglasan_dostavljanje_u_papirnoj_formi>',
                hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                    return jsElement.hasChildElement("podnosilac_saglasan_dostavljanje_u_papirnoj_formi")
                },
            },
              {
                  caption: 'Obrisi dostavljanje podaci',
                  action: Xonomy.deleteElement
              }]
          },

          podnosilac_saglasan_dostavljanje_elektronskim_putem : {
            hasText: true,
            oneliner: true,
            asker: Xonomy.askPicklist,
            askerParameter: ["true" , "false"],
            menu:[{
              caption:'Obrisi podnosilac saglasan dostavljanje elektronskim putem',
              action:Xonomy.deleteElement
            }
            ]
        },

        podnosilac_saglasan_dostavljanje_u_papirnoj_formi : {
          hasText: true,
          oneliner: true,
          asker: Xonomy.askPicklist,
          askerParameter: ["true" , "false"],
          menu:[{
            caption:'Obrisi podnosilac saglasan dostavljanje u papirnoj formi',
            action:Xonomy.deleteElement
          }
          ]
      },

      ////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////// prijava ////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            prijava : {
              asker: Xonomy.askString,
              menu:[
              {
                  caption:'Dodaj <dopunska_prijava>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<dopunska_prijava></dopunska_prijava>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("dopunska_prijava")
                  },
              },
              {
                  caption:'Dodaj <izdvojena_prijava>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<izdvojena_prijava></izdvojena_prijava>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("izdvojena_prijava")
                  },
              },
              {
                caption:'Dodaj <broj_osnovne_prijave>',
                action: Xonomy.newElementChild,
                actionParameter: '<broj_osnovne_prijave></broj_osnovne_prijave>',
                hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                    return jsElement.hasChildElement("broj_osnovne_prijave")
                },
            },
            {
              caption:'Dodaj <datum_podnosenja_osnovne_prijave>',
              action: Xonomy.newElementChild,
              actionParameter: '<datum_podnosenja_osnovne_prijave></datum_podnosenja_osnovne_prijave>',
              hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                  return jsElement.hasChildElement("datum_podnosenja_osnovne_prijave")
              },
            },
              {
                  caption: 'Obrisi dostavljanje podaci',
                  action: Xonomy.deleteElement
              }]
          },

          dopunska_prijava : {
            hasText: true,
            oneliner: true,
            asker: Xonomy.askPicklist,
            askerParameter: ["true" , "false"],
            menu:[{
              caption:'Obrisi dopunska prijava',
              action:Xonomy.deleteElement
            }
            ]
        },

        izdvojena_prijava : {
          hasText: true,
          oneliner: true,
          asker: Xonomy.askPicklist,
          askerParameter: ["true" , "false"],
          menu:[{
            caption:'Obrisi izdvojena prijava',
            action:Xonomy.deleteElement
          }
          ]
      },

      broj_osnovne_prijave : {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
        menu:[{
          caption:'Obrisi broj osnovne prijave',
          action:Xonomy.deleteElement
        }
        ]
      },

      datum_podnosenja_osnovne_prijave : {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
        menu:[{
          caption:'Obrisi datum podnosenja osnovne prijave',
          action:Xonomy.deleteElement
        }
        ]
      },


            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////// punomocnik /////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////

            punomocnik : {
              asker: Xonomy.askString,
              menu:[
              {
                  caption:'Dodaj <vrsta_punomocja>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<vrsta_punomocja></vrsta_punomocja>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("vrsta_punomocja")
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
                caption:'Obrisi punomocnika',
                action:Xonomy.deleteElement
              }
              ]
          },

          vrsta_punomocja : {
            asker: Xonomy.askString,
            menu:[
            {
                caption:'Dodaj <punomocnik_za_zastupanje>',
                action: Xonomy.newElementChild,
                actionParameter: '<punomocnik_za_zastupanje></punomocnik_za_zastupanje>',
                hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                    return jsElement.hasChildElement("punomocnik_za_zastupanje")
                },
            },
            {
                caption:'Dodaj <punomocnik_za_prijem_pismena>',
                action: Xonomy.newElementChild,
                actionParameter: '<punomocnik_za_prijem_pismena></punomocnik_za_prijem_pismena>',
                hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                    return jsElement.hasChildElement("punomocnik_za_prijem_pismena")
                },
            },
            {
              caption:'Obrisi vrste punomocnika',
              action:Xonomy.deleteElement
            }
            ]
        },


        punomocnik_za_zastupanje : {
          hasText: true,
          oneliner: true,
          asker: Xonomy.askPicklist,
          askerParameter: ["true" , "false"],
          menu:[{
            caption:'Obrisi punomocnik za zastupanje',
            action:Xonomy.deleteElement
          }
          ]
      },

      punomocnik_za_prijem_pismena : {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askPicklist,
        askerParameter: ["true" , "false"],
        menu:[{
          caption:'Obrisi punomocnik za prijem pismena',
          action:Xonomy.deleteElement
        }
        ]
    },




            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////// pronalazac /////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            pronalazac : {
              asker: Xonomy.askString,
              menu:[
              {
                  caption:'Dodaj <pronalazac_ne_zeli_da_bude_naveden_u_prijavi>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<pronalazac_ne_zeli_da_bude_naveden_u_prijavi></pronalazac_ne_zeli_da_bude_naveden_u_prijavi>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("pronalazac_ne_zeli_da_bude_naveden_u_prijavi")
                  },
              },
              {
                  caption:'Dodaj <pronalazac_je_podnosilac_prijave>',
                  action: Xonomy.newElementChild,
                  actionParameter: '<pronalazac_je_podnosilac_prijave></pronalazac_je_podnosilac_prijave>',
                  hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                      return jsElement.hasChildElement("pronalazac_je_podnosilac_prijave")
                  },
              },
              {
                caption:'Dodaj <podaci_o_pronalazacu>',
                action: Xonomy.newElementChild,
                actionParameter: '<podaci_o_pronalazacu></podaci_o_pronalazacu>',
                hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                    return jsElement.hasChildElement("podaci_o_pronalazacu")
                },
            },
              {
                caption:'Obrisi pronalazaca',
                action:Xonomy.deleteElement
              }
              ]
            },

            pronalazac_ne_zeli_da_bude_naveden_u_prijavi : {
              hasText: true,
              oneliner: true,
              asker: Xonomy.askPicklist,
              askerParameter: ["true" , "false"],
              menu:[{
                caption:'Obrisi pronalazac ne zeli da bude naveden u prijavi',
                action:Xonomy.deleteElement
              }
              ]
          },

          pronalazac_je_podnosilac_prijave : {
            hasText: true,
            oneliner: true,
            asker: Xonomy.askPicklist,
            askerParameter: ["true" , "false"],
            menu:[{
              caption:'Obrisi pronalazac je podnosilac prijave',
              action:Xonomy.deleteElement
            }
            ]
        },



        podaci_o_pronalazacu : {
          asker: Xonomy.askString,
          menu:[
          {
              caption:'Dodaj <fizicko_lice>',
              action: Xonomy.newElementChild,
              actionParameter: '<fizicko_lice></fizicko_lice>',
              hideIf: function (jsElement: { hasChildElement: (arg0: string) => any; }) {
                  return jsElement.hasChildElement("fizicko_lice")
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
            caption:'Obrisi podatke o pronalazacu',
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

