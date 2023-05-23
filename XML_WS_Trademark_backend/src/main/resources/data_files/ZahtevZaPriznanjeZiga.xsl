<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:z="http://www.ftn.uns.ac.rs/zahtev_za_zig" version="2.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://www.ftn.uns.ac.rs/zahtev_za_zig ZahtevZaPriznjanjeZiga.xsd">

    <xsl:template match="/">
        <html>
            <style>
                body {
                    font-family: Arial, Helvetica, sans-serif;
                    margin-left: 50px;
                    margin-right: 50px;
                }

                h2, h3 {
                    text-align: center;
                }

                h2 {
                    margin-bottom: 0px;
                }

                h3 {
                    margin-top: 0px;
                }

                .is-centered {
                    text-align: center;
                }

                .is-top-vertical {
                    vertical-align: top;
                }

                table, th, td {
                    border: 1px solid black;
                    border-collapse: collapse;
                }

                table.is-borderless, .is-borderless > tbody > th, .is-borderless > tbody > tr > td {
                    border: none !important;
                    border-collapse: collapse;
                }

                table {
                    width: 100%;
                }

                .ht-50 {
                    height: 50px
                }

                .ht-60 {
                    height: 60px
                }

                .border-top-none, .border-top-none>th, td {
                    border-top: none;
                }

                .pad-lef-10 {
                    padding-left: 10px;
                }

                .pad-left-20 {
                    padding-left: 20px !important;
                }

                .pt-05 {
                    padding-top: 5px;
                }

                .pb-1 {
                    padding-bottom: 10px;
                }

                .pb-2 {
                    padding-bottom: 20px;
                }

                .mb-0 {
                    margin-bottom: 0px;
                }

                .mb-1 {
                    margin-bottom: 10px;
                }

                .mt-0 {
                    margin-top: 0px;
                }

                .mt-6 {
                    margin-top: 60px;
                }

                .input-txt-clr {
                    color: rgb(105,105,105);
                }

                .col-half-width {
                    width: 50%;
                }

                .col-tenth-width {
                    width: 10%;
                }

                .col-tenth-eighth {
                    width: 80%;
                }

                .col-third-width {
                    width: 30%;
                }
            </style>
            <body>
                <h2>ЗАХТЕВ ЗА ПРИЗНАЊЕ ЖИГА</h2>
                <h3>Завод за интелектуалну својину, Књегиње Љубице 5, 11000 Београд</h3>
                <table>
                    <tr>
                        <td colspan="3" class="pad-lef-10">
                            <b>1. Подносилац пријаве:</b> име и презиме/пословно име, улица и број, поштански број, место, држава пребивалишта/седишта:
                        </td>
                    </tr>
                    <tr class="ht-60">
                        <td colspan="3" class="pad-left-20 input-txt-clr">
                            <span class="input-txt-clr"><xsl:value-of select="//z:PodnosilacPrijave/z:Ime"/></span>,
                            <span class="input-txt-clr"><xsl:value-of select="//z:PodnosilacPrijave/z:Adresa/z:Ulica"/></span>
                            <span class="input-txt-clr"><xsl:value-of select="//z:PodnosilacPrijave/z:Adresa/z:BrojUlice"/></span>,
                            <span class="input-txt-clr"><xsl:value-of select="//z:PodnosilacPrijave/z:Adresa/z:MestoPrebivalista"/></span>,
                            <span class="input-txt-clr"><xsl:value-of select="//z:PodnosilacPrijave/z:Adresa/z:DrzavaPrebivalista"/></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10">телефон: <span class="input-txt-clr"><xsl:value-of select="//z:PodnosilacPrijave/z:KontaktInformacije/z:Telefon"/></span></td>
                        <td class="pad-lef-10">e-mail: <span class="input-txt-clr"><xsl:value-of select="//z:PodnosilacPrijave/z:KontaktInformacije/z:E-mail"/></span></td>
                        <td class="pad-lef-10">факс: <span class="input-txt-clr"><xsl:value-of select="//z:PodnosilacPrijave/z:KontaktInformacije/z:Faks"/></span></td>
                    </tr>
                </table>
                <table class="border-top-none">
                    <tr>
                        <td colspan="3" class="pad-lef-10"><b>2. Пуномоћник:</b> име и презиме/пословно име, улица и број, поштански број, место, држава пребивалишта/седишта:</td>
                    </tr>
                    <tr class="ht-60">
                        <td colspan="3" class="pad-left-20 input-txt-clr">
                            <span class="input-txt-clr"><xsl:value-of select="//z:Punomocnik/z:Ime"/></span>,
                            <span class="input-txt-clr"><xsl:value-of select="//z:Punomocnik/z:Adresa/z:Ulica"/></span>
                            <span class="input-txt-clr"><xsl:value-of select="//z:Punomocnik/z:Adresa/z:BrojUlice"/></span>,
                            <span class="input-txt-clr"><xsl:value-of select="//z:Punomocnik/z:Adresa/z:MestoPrebivalista"/></span>,
                            <span class="input-txt-clr"><xsl:value-of select="//z:Punomocnik/z:Adresa/z:DrzavaPrebivalista"/></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10">телефон: <span class="input-txt-clr"><xsl:value-of select="//z:Punomocnik/z:KontaktInformacije/z:Telefon"/></span></td>
                        <td class="pad-lef-10">e-mail: <span class="input-txt-clr"><xsl:value-of select="//z:Punomocnik/z:KontaktInformacije/z:E-mail"/></span></td>
                        <td class="pad-lef-10">факс: <span class="input-txt-clr"><xsl:value-of select="//z:Punomocnik/z:KontaktInformacije/z:Faks"/></span></td>
                    </tr>
                </table>
                <table class="border-top-none">
                    <tr>
                        <td colspan="3" class="pad-lef-10"><b>3. Подаци о заједничком представнику ако постоји више подносилаца пријаве:</b>
                        </td>
                    </tr>
                    <tr class="ht-60 pad-left-20">
                        <td colspan="3" class="pad-left-20 input-txt-clr">
                            <span class="input-txt-clr"><xsl:value-of select="//z:ZajednickiPredstavnik/z:Ime"/></span>,
                            <span class="input-txt-clr"><xsl:value-of select="//z:ZajednickiPredstavnik/z:Adresa/z:Ulica"/></span>
                            <span class="input-txt-clr"><xsl:value-of select="//z:ZajednickiPredstavnik/z:Adresa/z:BrojUlice"/></span>,
                            <span class="input-txt-clr"><xsl:value-of select="//z:ZajednickiPredstavnik/z:Adresa/z:MestoPrebivalista"/></span>,
                            <span class="input-txt-clr"><xsl:value-of select="//z:ZajednickiPredstavnik/z:Adresa/z:DrzavaPrebivalista"/></span>
                        </td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10">телефон: <span class="input-txt-clr"><xsl:value-of select="//z:ZajednickiPredstavnik/z:KontaktInformacije/z:Telefon"/></span></td>
                        <td class="pad-lef-10">e-mail: <span class="input-txt-clr"><xsl:value-of select="//z:ZajednickiPredstavnik/z:KontaktInformacije/z:E-mail"/></span></td>
                        <td class="pad-lef-10">факс: <span class="input-txt-clr"><xsl:value-of select="//z:ZajednickiPredstavnik/z:KontaktInformacije/z:Faks"/></span></td>
                    </tr>
                </table>
                <table class="border-top-none">
                    <tr>
                        <td class="pad-lef-10 col-half-width" colspan="9"><b>4. Пријава се подноси за (уписати X):</b></td>
                        <td class="pad-lef-10 col-half-width" colspan="9"><b>в) изглед знака:</b></td>
                    </tr>

                    <tr>
                        <td class="pad-lef-10 col-tenth-width" rowspan="3" colspan="1"><b>а)</b></td>
                        <td class="pad-lef-10 col-tenth-eighth" colspan="6"><b>индивидуални жиг</b></td>
                        <td class="pad-lef-10 col-tenth-width" colspan="2"><b>
                            <xsl:choose>
                                <xsl:when test="//z:Zig/z:TipZiga = 'individualni zig'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </b></td>
                        <td class="pad-lef-10 is-centered" rowspan="12" colspan="9">
                            <img alt="slika"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10 col-tenth-eighth" colspan="6"><b>колективни жиг</b></td>
                        <td class="pad-lef-10 col-tenth-width" colspan="2"><b>
                            <xsl:choose>
                                <xsl:when test="//z:Zig/z:TipZiga = 'kolektivni zig'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </b></td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10 col-tenth-eighth" colspan="6"><b>жиг гаранције</b></td>
                        <td class="pad-lef-10 col-tenth-width" colspan="2"><b>
                            <xsl:choose>
                                <xsl:when test="//z:Zig/z:TipZiga = 'zig garancije'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </b></td>
                    </tr>

                    <tr>
                        <td class="pad-lef-10 col-tenth-width" rowspan="5" colspan="1"><b>б)</b></td>
                        <td class="pad-lef-10 col-tenth-eighth" colspan="6"><b>вербални знак (знак у речи)</b></td>
                        <td class="pad-lef-10 col-tenth-width" colspan="2"><b>
                            <xsl:choose>
                                <xsl:when test="//z:Zig/z:TipZnaka = 'verbalni znak'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </b></td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10 col-tenth-eighth" colspan="6"><b>графички знак; боју, комбинацију боја</b></td>
                        <td class="pad-lef-10 col-tenth-width" colspan="2"><b>
                            <xsl:choose>
                                <xsl:when test="//z:Zig/z:TipZnaka = 'graficki znak'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </b></td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10 col-tenth-eighth" colspan="6"><b>комбиновани знак</b></td>
                        <td class="pad-lef-10 col-tenth-width" colspan="2"><b>
                            <xsl:choose>
                                <xsl:when test="//z:Zig/z:TipZnaka = 'kombinovani znak'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </b></td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10 col-tenth-eighth" colspan="6"><b>тродимензионални знак</b></td>
                        <td class="pad-lef-10 col-tenth-width" colspan="2"><b>
                            <xsl:choose>
                                <xsl:when test="//z:Zig/z:TipZnaka = 'trodimenzionalni znak'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </b></td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10 col-tenth-eighth" colspan="6"><b>другу врсту знака (навести коју)</b></td>
                        <td class="pad-lef-10 col-tenth-width" colspan="2"><b>
                            <xsl:choose>
                                <xsl:when test="//z:Zig/z:TipZnaka = 'drugo'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </b></td>
                    </tr>

                    <tr>
                        <td class="pad-lef-10 is-top-vertical col-half-width" colspan="9">
                            <b>5. Назначење боје, односно боја из којих се знак састоји:</b>
                            <p class="input-txt-clr mb-0"><xsl:value-of select="//z:Zig/z:Boje"/></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10 is-top-vertical col-half-width" colspan="9">
                            <b>6. Транслитерација знака:</b>
                            <p class="input-txt-clr mb-0"><xsl:value-of select="//z:Zig/z:TransliteracijaZnaka"/></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10 is-top-vertical col-half-width" colspan="9">
                            <b>7. Превод знака*:</b>
                            <p class="input-txt-clr mb-0"><xsl:value-of select="//z:Zig/z:PrevodZnaka"/></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="pad-lef-10 is-top-vertical col-half-width" colspan="9">
                            <b>8. Опис знака:</b>
                            <p class="input-txt-clr mb-0"><xsl:value-of select="//z:Zig/z:OpisZnaka"/></p>
                        </td>
                    </tr>
                </table>

                <table class="border-top-none">
                    <tr>
                        <td colspan="3" class="pad-lef-10"><b>9. Бројеви класа робе и услуга према Ничанској класификацији:</b></td>
                    </tr>
                    <tr class="ht-60 pad-left-20">
                        <td colspan="3" class="pad-left-20 input-txt-clr">
                            <xsl:for-each select="//z:BrojeviKlasaRobeIliUsluga/*">
                                <xsl:text>[</xsl:text>
                                <xsl:value-of select="text()" />
                                <xsl:text>] </xsl:text>
                            </xsl:for-each>
                        </td>
                    </tr>
                </table>
                <table class="border-top-none">
                    <tr>
                        <td colspan="3" class="pad-lef-10 ht-60">
                            <b>10. Затражено право првенства и основ:</b>
                            <p class="input-txt-clr mb-0"><xsl:value-of select="//z:PravoPrvenstvaIOsnov"/></p>
                        </td>
                    </tr>
                </table>

                <table style="margin-top: 50px">
                    <tr>
                        <td colspan="4" class="pad-lef-10 ht-50 is-top-vertical"><b>11. Плаћене таксе:</b></td>
                        <td colspan="1" class="pad-lef-10 ht-50 is-top-vertical"><b>Динара</b></td>
                        <td colspan="5" rowspan="4" class="pad-lef-10 ht-50 is-top-vertical is-centered col-third-width">
                            <p class="mb-1 mt-0"><b>QR код</b></p>
                            <img alt="qr code" />
                        </td>
                    </tr>
                    <tr class="ht-60 pad-left-20">
                        <td colspan="4" class="pad-lef-10">
                            <b>а) основна такса</b>
                        </td>
                        <td colspan="1" class="pad-left-20 input-txt-clr">
                            <xsl:value-of select="//z:Taksa/z:OsnovnaTaksa"/>
                        </td>
                    </tr>
                    <tr class="ht-60 pad-left-20">
                        <td colspan="4" class="pad-lef-10">
                            <b>б) за <span class="input-txt-clr"><xsl:value-of select="count(//z:BrojeviKlasaRobeIliUsluga/*)"/></span> класа</b>
                            <br/>
                            <b>в) за графичко решење</b>
                        </td>
                        <td colspan="1" class="pad-left-20 input-txt-clr">
                            <xsl:variable name="sum" select="//z:Taksa/z:TaksaZaBrojKlasa + //z:Taksa/z:TaksaZaGrafickoResenje" />
                            <xsl:value-of select="$sum" />
                        </td>
                    </tr>
                    <tr class="ht-60 pad-left-20">
                        <td colspan="4" class="pad-lef-10">
                            <b>УКУПНО</b>
                        </td>
                        <td colspan="1" class="pad-left-20 input-txt-clr">
                            <xsl:value-of select="//z:Taksa/z:Ukupno"/>
                        </td>
                    </tr>
                </table>

                <table class="mt-6 is-borderless">
                    <tr class="pad-lef-10 ht-50 is-top-vertical is-centered mb-1 mt-0">
                        <td colspan="10"><b>ПОПУЊАВА ЗАВОД</b></td>
                    </tr>

                    <tr>
                        <td colspan="6" class="pad-lef-10 pb-2 pt-05"><b>Прилози уз захтев:</b></td>
                        <td colspan="4" rowspan="9" class="col-third-width">
                            <div class="is-centered pb-1">Број пријаве жига:</div>
                            <div class="is-centered pb-2">
                                <xsl:value-of select="//z:MetaData/z:BrojPrijave"/>
                            </div>
                            <div class="is-centered pb-1">Датум подношења:</div>
                            <div class="is-centered pb-1">
                                <xsl:variable name="dateNtime" select="//z:MetaData/z:DatumPodnosenja" />
                                <xsl:value-of select="concat(substring($dateNtime,9,2),'-',substring($dateNtime,6,2),'-',substring($dateNtime,1,4))"/></div>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="5" class="pad-lef-10 pb-2 pt-05">Примерак знака</td>
                        <td class="col-tenth-width is-centered">
                            <xsl:choose>
                                <xsl:when test="//z:PriloziUzZahtev/z:PrimerakZnaka = 'true'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" class="pad-lef-10 pb-2 pt-05">Списак робе и услуга**</td>
                        <td class="col-tenth-width is-centered">
                            <xsl:choose>
                                <xsl:when test="//z:PriloziUzZahtev/z:SpisakRobeIUsluga = 'true'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" class="pad-lef-10 pb-2 pt-05">Пуномоћје</td>
                        <td class="col-tenth-width is-centered">
                            <xsl:choose>
                                <xsl:when test="//z:PriloziUzZahtev/z:Punomocje = 'true'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" class="pad-lef-10 pb-2 pt-05">Генерално пуномоћје раније приложено</td>
                        <td class="col-tenth-width is-centered">
                            <xsl:choose>
                                <xsl:when test="//z:PriloziUzZahtev/z:PunomocjeRanijePrilozeno = 'true'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" class="pad-lef-10 pb-2 pt-05">Пуномоћје ће бити накнадно достављено</td>
                        <td class="col-tenth-width is-centered">
                            <xsl:choose>
                                <xsl:when test="//z:PriloziUzZahtev/z:PunomocjeNaknadnoPrilozeno = 'true'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" class="pad-lef-10 pb-2 pt-05">Општи акт о колективном жигу/жигу гаранције</td>
                        <td class="col-tenth-width is-centered">
                            <xsl:choose>
                                <xsl:when test="//z:PriloziUzZahtev/z:OpstiAktOZigu = 'true'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" class="pad-lef-10 pb-2 pt-05">Доказ о праву првенства</td>
                        <td class="col-tenth-width is-centered">
                            <xsl:choose>
                                <xsl:when test="//z:PriloziUzZahtev/z:DokazPravaPrvenstva = 'true'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" class="pad-lef-10 pb-2">Доказ о уплати таксе</td>
                        <td class="col-tenth-width is-centered">
                            <xsl:choose>
                                <xsl:when test="//z:PriloziUzZahtev/z:DokazUplateTakse = 'true'">
                                    <xsl:text>X</xsl:text>
                                </xsl:when>
                            </xsl:choose>
                        </td>
                    </tr>
                </table>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>