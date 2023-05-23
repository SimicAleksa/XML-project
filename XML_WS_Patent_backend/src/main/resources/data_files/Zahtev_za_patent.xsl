<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:p="http://www.ftn.uns.ac.rs/zahtev_za_patent" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
            </head>
            <body>
                <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.0001pt;margin-left:.5pt;text-indent:0cm;line-height:115%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;margin:0cm;border:none;'><span style="font-size:15px;line-height:115%;">&#160;</span></p>
                <div style="align-content: center;width: 100%;align-self: center;">
                    <table style="width: 47%;border-collapse:collapse;border:none; margin-left: 1%;">
                        <tbody>
                            <tr>
                                <td colspan="4" style="width: 322.75pt;border: 1.5pt solid black;padding: 0cm 5.4pt;height: 12.35pt;vertical-align: top;">
                                    <p style='margin-top:2.0pt;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:center;'>Попуњава Завод</p>
                                </td>
                            </tr>
                            <tr>
                                <td style="width:66.75pt;border:none;border-left:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:19.05pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">Број пријаве</span></p>
                                </td>
                                <td colspan="2" rowspan="2" style="width:216.0pt;border:none;border-bottom:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:19.05pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:21px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:popunjava_zavod/p:broj_prijave"/> </span></p>
                                </td>
                                <td style="width:40.0pt;border:none;border-right:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:19.05pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">(21)</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td style="width:66.75pt;border-top:none;border-left:solid black 1.5pt;border-bottom:solid black 1.5pt;border-right:none;padding:0cm 5.4pt 0cm 5.4pt;height:4.55pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>&#160; &#160; &#160; &#160; &#160;&#160;</p>
                                </td>
                                <td style="width:40.0pt;border-top:none;border-left:none;border-bottom:  solid black 1.5pt;border-right:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:4.55pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:8.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>&#160;</p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="width:147.75pt;border-top:none;border-left:  solid black 1.5pt;border-bottom:none;border-right:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:19.35pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">Датум пријема</span>
                                        <span style="font-size:21px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:popunjava_zavod/p:datum_prijema"/></span>
                                    </p>
                                </td>
                                <td style="width:135.0pt;border:none;padding:0cm 5.4pt 0cm 5.4pt;height:  19.35pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">Признати датум подношења</span>
                                        <span style="font-size:21px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:popunjava_zavod/p:priznati_datum_podnosenja"/></span>
                                    </p>
                                </td>
                                <td style="width:40.0pt;border:none;border-right:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:19.35pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">(22)</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="width:147.75pt;border:solid black 1.5pt;border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:19.35pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                </td>
                                <td colspan="2" style="width:175.0pt;border-top:none;border-left:  none;border-bottom:solid black 1.5pt;border-right:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:  19.35pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3" style="width:282.75pt;border:none;border-left:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:19.65pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">Печат и потпис</span></p>
                                </td>
                                <td style="width:40.0pt;border:none;border-right:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:19.65pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3" style="width:282.75pt;border-top:none;border-left:  solid black 1.5pt;border-bottom:solid black 1.5pt;border-right:none;padding:0cm 5.4pt 0cm 5.4pt;height:19.25pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                </td>
                                <td style="width:40.0pt;border-top:none;border-left:none;border-bottom:  solid black 1.5pt;border-right:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:19.25pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td style="border:none;"><br/></td>
                                <td style="border:none;"><br/></td>
                                <td style="border:none;"><br/></td>
                                <td style="border:none;"><br/></td>
                            </tr>
                        </tbody>
                    </table>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.0001pt;margin-left:.55pt;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:13px;line-height:107%;">&#160; &#160; &#160; &#160;Република Србија</span></p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.0001pt;margin-left:.55pt;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:13px;line-height:107%;">&#160; &#160; &#160; &#160;Завод за интелектуалну својину</span></p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.0001pt;margin-left:.55pt;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:13px;line-height:107%;">&#160; &#160; &#160; &#160;Кнегиње Љубице број 5</span></p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.0001pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:13px;line-height:107%;">&#160; &#160; &#160; &#160;11000 Београд</span></p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.0001pt;margin-left:.55pt;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:16px;line-height:107%;">&#160;</span></p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.25pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:center;'><strong><span style="font-size:16px;line-height:107%;">ЗАХТЕВ</span></strong></p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.25pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:center;'><strong><span style="font-size:16px;line-height:107%;">ЗА ПРИЗНАЊЕ ПАТЕНТА</span></strong></p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.25pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>&#160;</p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.25pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:13px;line-height:107%;">&#160;</span></p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.25pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:center;'><span style="font-size:21px;line-height:107%;">&#160;</span></p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.25pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:center;'>(попунити писаћом машином или рачунаром)</p>
                    <table style="width: 100%;margin-left:9.9pt;border-collapse:collapse;border:none;">
                        <tbody>
                            <tr>
                                <td colspan="5" style="width: 529.9pt;border-width: 1.5pt 1.5pt 1pt;border-style: solid;border-color: black;border-image: initial;padding: 0cm 5.4pt;height: 42.1pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:2.0pt;margin-bottom:  3.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:justify;'><strong><span style="font-size:12px;line-height:  107%;">Поље број I&#160; &#160; &#160; &#160; &#160;&#160; НАЗИВ ПРОНАЛАСКА&#160; &#160;&#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160;&#160;</span></strong><span style="font-size:12px;line-height:107%;">(54)</span></p>
                                    <p style='margin-top:0cm;margin-right:2.85pt;margin-bottom:  .15pt;margin-left:0cm;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:justify;'><em>*&#160;</em>Назив проналаска треба да јасно и сажето изражава суштину проналаска и не сме да садржи измишљене или комерцијалне називе, жигове, имена, шифре, уобичајене скраћенице за производе и сл.</p>
                                </td>
                                <td style="height:42.1pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td colspan="5" style="width: 529.9pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 14.95pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">На српском језику: &#160; <xsl:value-of select="//p:Zahtev_za_patent/p:naziv_pronalaska/p:na_srpskom_jeziku"/></span></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:4px;line-height:107%;">&#160;</span></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">На енглеском језику: &#160;<xsl:value-of select="//p:Zahtev_za_patent/p:naziv_pronalaska/p:na_engleskom_jeziku"/></span></p>
                                </td>
                                <td style="height:14.95pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td colspan="4" style="width: 484.55pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: none;padding: 0cm 5.4pt;height: 1pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><strong><span style="font-size:12px;line-height:  107%;">Поље број II&#160; &#160; &#160; &#160;&#160;&#160; &#160;ПОДНОСИЛАЦ ПРИЈАВЕ&#160;&#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160;&#160;</span></strong>
                                        <span style='font-size:13px;line-height:107%;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <xsl:choose>
                                                <xsl:when test="//p:Zahtev_za_patent/p:podnosilac_prijave/p:podnosilac_prijave_je_i_pronalazac = 'true'">
                                                    ☑
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    ☐
                                                </xsl:otherwise>
                                            </xsl:choose>
                                            &#160; Подносилац пријаве је и проналазач<strong>&#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160;</strong>
                                        </span>
                                    </p>
                                </td>
                                <td style="width: 45.35pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 1pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">(71)</span></p>
                                </td>
                                <td style="height:1.0pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td rowspan="3" style="width: 185.1pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 39.7pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:1.15pt;margin-bottom:  2.0pt;margin-left:1.7pt;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">Име и презиме / Пословно име:&#160;</span>(презиме / пословно име уписати великим словима)</p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">
                                            <xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:fizicko_pravno_lice/p:fizicko_lice/p:ime"/>&#160; &#160;
                                            <xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:fizicko_pravno_lice/p:fizicko_lice/p:prezime"/>&#160; &#160;
                                            <xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:fizicko_pravno_lice/p:pravno_lice/p:poslovno_ime"/>&#160; &#160;
                                        </span>
                                    </p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                </td>
                                <td colspan="2" rowspan="3" style="width: 185.1pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 39.7pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:1.15pt;margin-bottom:  2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Улица и број, поштански број, место и држава:</span><br/>
                                        <span style="font-size:12px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:adresa/p:ulica"/>&#160;<xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:adresa/p:broj_objekta"/></span>
                                        <span style="font-size:12px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:adresa/p:postanski_broj"/>&#160;<xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:adresa/p:mesto"/></span>
                                        <span style="font-size:12px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:adresa/p:drzava"/></span>
                                    </p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                                <td colspan="2" style="width: 159.7pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 39.7pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:  107%;">Број телефона:
                                            &#160;<xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:dodatni_podaci/p:broj_telefona"/>
                                        </span>
                                    </p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                                <td style="height:39.7pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td colspan="2" style="width: 159.7pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 39.1pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:  107%;">Број факса:
                                            &#160;<xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:dodatni_podaci/p:broj_faksa"/>
                                        </span>
                                    </p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                                <td style="height:39.1pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td colspan="2" rowspan="2" style="width: 159.7pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 12.05pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:.55pt;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Е-пошта:
                                            &#160;<xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:dodatni_podaci/p:e_posta"/>
                                        </span>
                                    </p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                                <td style="height:12.05pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td colspan="2" style="width: 223.35pt;border-top: none;border-right: none;border-bottom: none;border-image: initial;border-left: 1.5pt solid black;padding: 0cm 5.4pt;height: 19.3pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Држављанство: &#160;&#160;
                                            <xsl:value-of select="//p:Zahtev_za_patent/p:podnosilac_prijave/p:licni_podaci/p:drzavljanstvo"/>
                                        </span>
                                    </p>
                                </td>
                                <td style="width: 146.85pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 19.3pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>(попунити само за физичка лица)</p>
                                </td>
                                <td style="height:19.3pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td colspan="5" style="width: 529.9pt;border-width: 1pt 1.5pt 1.5pt;border-style: solid;border-color: black;border-image: initial;padding: 0cm 5.4pt;height: 44.5pt;vertical-align: top;">
                                </td>
                                <td style="height:44.5pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td colspan="5" style="width:529.9pt;border-top:none;border-left:  solid black 1.5pt;border-bottom:solid black 1.0pt;border-right:solid black 1.5pt;padding:0cm 5.4pt 0cm 5.4pt;height:79.0pt;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:3.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><strong><span style="font-size:12px;line-height:  107%;">Поље број III &#160; &#160; &#160; &#160; &#160; ПРОНАЛАЗАЧ &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160;&#160;</span></strong><span style='font-size:13px;line-height:107%;font-family:Verdana, Geneva, Tahoma, sans-serif;;'>&#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160;</span><span style="font-size:12px;line-height:107%;">(72)</span></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:3.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>(ако су сви проналазачи уједно и подносиоци пријаве, поље број III се не попуњава)</p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>* Ако сви подносиоци пријаве нису и проналазачи, доставља се изјава подносилаца пријаве о основу стицања права на подношење пријаве у односу на проналазаче који нису и подносиоци пријаве и у том случају у поље број III се уносе подаци о свим проналазачим</p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span><span style='font-size:12px;line-height:107%;font-family:Verdana, Geneva, Tahoma, sans-serif;;'>&#160;&#160;</span><span style="font-size:12px;line-height:107%;">&#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160;</span>
                                        <span style='font-size:13px;line-height:107%;font-family:Verdana, Geneva, Tahoma, sans-serif;;'>
                                            <xsl:choose>
                                                <xsl:when test="//p:Zahtev_za_patent/p:pronalazac/p:pronalazac_ne_zeli_da_bude_naveden_u_prijavi = 'true'">
                                                    ☑
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    ☐
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </span>
                                        <span style="font-size:12px;line-height:107%;">&#160; &#160;Проналазач не жели да буде наведен у пријави</span>
                                    </p>
                                    <p style='margin-top:0cm;margin-right:1.45pt;margin-bottom:  2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>(ако проналазач не жели да буде наведен у пријави<span style="font-size:12px;line-height:107%;">&#160;</span>поље број III се не попуњава)</p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">*</span>Ако проналазач не жели да буде наведен у пријави, потребно је доставити потписану изјаву проналазача да не жели да буде наведен.</p>
                                </td>
                                <td style="height:79.0pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td rowspan="3" style="width: 185.1pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 15.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:1.15pt;margin-bottom:  2.0pt;margin-left:1.7pt;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Име и презиме:&#160;(презиме уписати великим словима) <br/>
                                            <span>
                                                <xsl:value-of select="//p:Zahtev_za_patent/p:pronalazac/p:podaci_o_pronalazacu/p:fizicko_lice/p:ime"/>
                                                &#160;<xsl:value-of select="//p:Zahtev_za_patent/p:pronalazac/p:podaci_o_pronalazacu/p:fizicko_lice/p:prezime"/>
                                            </span>
                                        </span></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                                <td colspan="2" rowspan="3" style="width: 185.1pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 15.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:1.25pt;margin-bottom:  .15pt;margin-left:1.7pt;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Улица и број, поштански број, место и држава: <br/>
                                            <span style="font-size:12px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:pronalazac/p:podaci_o_pronalazacu/p:adresa/p:ulica"/>&#160;
                                                <xsl:value-of select="//p:Zahtev_za_patent/p:pronalazac/p:podaci_o_pronalazacu/p:adresa/p:broj_objekta"/></span>
                                            <span style="font-size:12px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:pronalazac/p:podaci_o_pronalazacu/p:adresa/p:postanski_broj"/>&#160;
                                                <xsl:value-of select="//p:Zahtev_za_patent/p:pronalazac/p:podaci_o_pronalazacu/p:adresa/p:mesto"/></span>
                                            <span style="font-size:12px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:pronalazac/p:podaci_o_pronalazacu/p:adresa/p:drzava"/></span>
                                        </span></p>
                                    <p style='margin-top:0cm;margin-right:1.25pt;margin-bottom:  .15pt;margin-left:1.7pt;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                                <td colspan="2" style="width: 159.7pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 15.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:.55pt;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Број телефона:
                                            <xsl:value-of select="//p:Zahtev_za_patent/p:pronalazac/p:podaci_o_pronalazacu/p:dodatni_podaci/p:broj_telefona"/>
                                        </span></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                                <td style="height:15.4pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td colspan="2" style="width: 159.7pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 23.25pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:1.45pt;margin-bottom:  .15pt;margin-left:0cm;text-indent:-.7pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Број факса:
                                            <xsl:value-of select="//p:Zahtev_za_patent/p:pronalazac/p:podaci_o_pronalazacu/p:dodatni_podaci/p:broj_faksa"/>
                                        </span></p>
                                    <p style='margin-top:0cm;margin-right:1.45pt;margin-bottom:  .15pt;margin-left:0cm;text-indent:-.7pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160; &#160; &#160;&#160;</span></p>
                                </td>
                                <td style="height:23.25pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td colspan="2" style="width: 159.7pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 23.25pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:1.45pt;margin-bottom:  2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Е-пошта:
                                            <xsl:value-of select="//p:Zahtev_za_patent/p:pronalazac/p:podaci_o_pronalazacu/p:dodatni_podaci/p:e_posta"/>
                                        </span></p>
                                    <p style='margin-top:0cm;margin-right:1.45pt;margin-bottom:  2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                                <td style="height:23.25pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td colspan="5" style="width: 529.9pt;border-right: 1.5pt solid black;border-bottom: 1.5pt solid black;border-left: 1.5pt solid black;border-image: initial;border-top: none;padding: 0cm 5.4pt;height: 19.85pt;vertical-align: top;">
                                </td>
                                <td style="height:19.85pt;border:none;"><br/></td>
                            </tr>
                            <tr>
                                <td style="border:none;"><br/></td>
                                <td style="border:none;"><br/></td>
                                <td style="border:none;"><br/></td>
                                <td style="border:none;"><br/></td>
                                <td style="border:none;"><br/></td>
                                <td style="border:none;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>&#160;</p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:8.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>&#160;</p>
                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>&#160;</p>
                    <table style="width: 100%;margin-left:9.9pt;border-collapse:collapse;border:none;">
                        <tbody>
                            <tr>
                                <td colspan="8" style="width: 529.7pt;border-width: 1.5pt 1.5pt 1pt;border-style: solid;border-color: black;border-image: initial;padding: 0cm 5.4pt;height: 90.7pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><strong><span style="font-size:12px;line-height:107%;">Поље број IV &#160; &#160; &#160; &#160; &#160;</span></strong>
                                        <span style='font-size:13px;line-height:107%;font-family:Verdana, Geneva, Tahoma, sans-serif;;'>
                                            <xsl:choose>
                                                <xsl:when test="//p:Zahtev_za_patent/p:punomocnik/p:vrsta_punomocja/p:punomocnik_za_zastupanje = 'true'">
                                                    ☑
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    ☐
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </span><strong>
                                            <span style="font-size:12px;line-height:  107%;">&#160; ПУНОМОЋНИК ЗА ЗАСТУПАЊЕ &#160; &#160; &#160; &#160; &#160; &#160;&#160;</span></strong>
                                        <span style='font-size:13px;line-height:107%;font-family:Verdana, Geneva, Tahoma, sans-serif;;'>
                                            <xsl:choose>
                                                <xsl:when test="//p:Zahtev_za_patent/p:punomocnik/p:vrsta_punomocja/p:punomocnik_za_prijem_pismena = 'true'">
                                                    ☑
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    ☐
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </span><strong>
                                            <span style="font-size:12px;line-height:107%;">&#160; &#160; &#160;ПУНОМОЋНИК ЗА ПРИЈЕМ ПИСМЕНА &#160; &#160; &#160; &#160; &#160; &#160; &#160;&#160;</span></strong><span style="font-size:12px;line-height:107%;">(74)</span></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>&#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; </p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>* Пуномоћник за заступање је лице које по овлашћењу подносиоца пријаве предузима радње у управном поступку у границама пуномоћја</p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>* Пуномоћник за пријем писмена је лице које је подносилац пријаве одредио као лице коме се &#160;упућују сва писмена насловљена на подносиоца</p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4" rowspan="2" style="width: 263.2pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 31.2pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:1.15pt;margin-bottom:  2.0pt;margin-left:1.7pt;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Име и презиме / Пословно име</span>: (презиме / пословно име уписати великим словима)<br/>
                                        <span style="font-size:12px;line-height:107%;">&#160;<xsl:value-of select="//p:Zahtev_za_patent/p:punomocnik/p:licni_podaci/p:fizicko_pravno_lice/p:fizicko_lice/p:ime"/>&#160;
                                            <xsl:value-of select="//p:Zahtev_za_patent/p:punomocnik/p:licni_podaci/p:fizicko_pravno_lice/p:fizicko_lice/p:prezime"/></span>
                                        <span style="font-size:12px;line-height:107%;">&#160;<xsl:value-of select="//p:Zahtev_za_patent/p:punomocnik/p:licni_podaci/p:fizicko_pravno_lice/p:pravno_lice/p:poslovno_ime"/></span>
                                    </p>
                                    <p style='margin-top:0cm;margin-right:1.15pt;margin-bottom:  2.0pt;margin-left:1.7pt;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                    <p style='margin-top:0cm;margin-right:1.15pt;margin-bottom:  2.0pt;margin-left:1.7pt;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                </td>
                                <td colspan="2" rowspan="2" style="width: 139.7pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 31.2pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:1.15pt;margin-bottom:  2.0pt;margin-left:1.7pt;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Улица и број, поштански број и место:<br/>
                                            <span style="font-size:12px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:punomocnik/p:licni_podaci/p:adresa/p:ulica"/>&#160;
                                                <xsl:value-of select="//p:Zahtev_za_patent/p:punomocnik/p:licni_podaci/p:adresa/p:broj_objekta"/></span>
                                            <span style="font-size:12px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:punomocnik/p:licni_podaci/p:adresa/p:postanski_broj"/>&#160;
                                                <xsl:value-of select="//p:Zahtev_za_patent/p:punomocnik/p:licni_podaci/p:adresa/p:mesto"/></span>
                                        </span></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                                <td colspan="2" style="width: 126.8pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 31.2pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:.55pt;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Број телефона:
                                            &#160;<xsl:value-of select="//p:Zahtev_za_patent/p:punomocnik/p:licni_podaci/p:dodatni_podaci/p:broj_telefona"/>
                                        </span></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="width: 126.8pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 8.2pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Е-пошта:
                                            &#160;<xsl:value-of select="//p:Zahtev_za_patent/p:punomocnik/p:licni_podaci/p:dodatni_podaci/p:e_posta"/>
                                        </span></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.5pt;text-indent:-.5pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;&#160;&#160;&#160;&#160;</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="8" style="width: 529.7pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 39.7pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><strong><span style="font-size:12px;line-height:  107%;">Поље број V &#160; &#160; &#160; &#160;АДРЕСА ЗА ДОСТАВЉАЊЕ &#160;</span></strong></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>(ово поље се попуњава ако подносилац пријаве, заједнички представник или пуномоћник жели да се достављање поднесака врши на другој адреси од његове наведене адресе)</p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="8" style="width: 529.7pt;border-right: 1.5pt solid black;border-bottom: 1.5pt solid black;border-left: 1.5pt solid black;border-image: initial;border-top: none;padding: 0cm 5.4pt;height: 17pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Улица и број, поштански број и место: &#160;
                                            <span style="font-size:12px;line-height:107%;"><xsl:value-of select="//p:Zahtev_za_patent/p:dostavljanje_podaci/p:adresa/p:ulica"/>&#160;
                                                <xsl:value-of select="//p:Zahtev_za_patent/p:dostavljanje_podaci/p:adresa/p:broj_objekta"/> &#160;
                                                <xsl:value-of select="//p:Zahtev_za_patent/p:dostavljanje_podaci/p:adresa/p:postanski_broj"/>&#160;
                                                <xsl:value-of select="//p:Zahtev_za_patent/p:dostavljanje_podaci/p:adresa/p:mesto"/></span>
                                        </span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="8" style="width: 529.7pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 17pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><strong><span style="font-size:12px;line-height:  107%;">Поље број VI &#160; &#160; &#160; &#160;НАЧИН ДОСТАВЉАЊА</span></strong></p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="8" style="width: 529.7pt;border-right: 1.5pt solid black;border-bottom: 1.5pt solid black;border-left: 1.5pt solid black;border-image: initial;border-top: none;padding: 0cm 5.4pt;height: 45.35pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:2.0pt;margin-left:.55pt;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style='font-size:13px;line-height:107%;font-family:Verdana, Geneva, Tahoma, sans-serif;;'>
                                            <xsl:choose>
                                                <xsl:when test="//p:Zahtev_za_patent/p:dostavljanje_podaci/p:podnosilac_saglasan_dostavljanje_elektronskim_putem = 'true'">
                                                    ☑
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    ☐
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </span>
                                        <span style="font-size:16px;line-height:107%;">&#160; &#160; &#160;</span><span style="font-size:12px;line-height:107%;">Подносилац пријаве је сагласан да Завод врши достављање писмена искључиво електронским путем у форми електронског документа&#160;</span>(у овом случају неопходна је регистрација на порталу "еУправе")</p>
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:.55pt;text-indent:-.55pt;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style='font-size:13px;line-height:107%;font-family:Verdana, Geneva, Tahoma, sans-serif;;'>
                                            <xsl:choose>
                                                <xsl:when test="//p:Zahtev_za_patent/p:dostavljanje_podaci/p:podnosilac_saglasan_dostavljanje_u_papirnoj_formi = 'true'">
                                                    ☑
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    ☐
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </span>
                                        <span style="font-size:16px;line-height:107%;">&#160;&#160;</span><span style="font-size:12px;line-height:107%;">Подносилац пријаве је сагласан да Завод врши достављање писмена у папирној форми&#160;</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="7" style="width: 492.9pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: none;padding: 0cm 5.4pt;height: 7.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><strong><span style="font-size:12px;line-height:  107%;">Поље број VII&#160; &#160; &#160; &#160; &#160;&#160;</span></strong>
                                        <span style='font-size:13px;line-height:107%;font-family:Verdana, Geneva, Tahoma, sans-serif;;'>
                                            <xsl:choose>
                                                <xsl:when test="//p:Zahtev_za_patent/p:prijava/p:dopunska_prijava = 'true'">
                                                    ☑
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    ☐
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </span><strong>
                                            <span style="font-size:12px;line-height:107%;">&#160;ДОПУНСКА ПРИЈАВА &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160;</span></strong>
                                        <span style='font-size:13px;line-height:107%;font-family:Verdana, Geneva, Tahoma, sans-serif;;'>
                                            <xsl:choose>
                                                <xsl:when test="//p:Zahtev_za_patent/p:prijava/p:izdvojena_prijava = 'true'">
                                                    ☑
                                                </xsl:when>
                                                <xsl:otherwise>
                                                    ☐
                                                </xsl:otherwise>
                                            </xsl:choose>
                                        </span>
                                        <strong><span style="font-size:12px;line-height:107%;">&#160;ИЗДВОЈЕНА ПРИЈАВА</span></strong></p>
                                </td>
                                <td style="width: 36.8pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 7.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">(61)/(62)</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="7" style="width: 492.9pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: none;padding: 0cm 5.4pt;height: 7.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Број првобитне пријаве / основне пријаве, односно основног патента:
                                            &#160;<xsl:value-of select="//p:Zahtev_za_patent/p:prijava/p:broj_osnovne_prijave"/></span></p>
                                </td>
                                <td style="width: 36.8pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 7.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="7" style="width: 492.9pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1.5pt solid black;border-right: none;padding: 0cm 5.4pt;height: 7.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                        <span style="font-size:12px;line-height:107%;">Датум подношења првобитнe пријаве / основне пријаве:
                                            &#160;<xsl:value-of select="//p:Zahtev_za_patent/p:prijava/p:datum_podnosenja_osnovne_prijave"/></span></p>
                                </td>
                                <td style="width: 36.8pt;border-top: none;border-left: none;border-bottom: 1.5pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 7.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="7" style="width: 492.9pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: none;padding: 0cm 5.4pt;height: 7.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><strong><span style="font-size:12px;line-height:  107%;">Поље број VIII &#160; &#160; &#160; ЗАХТЕВ ЗА ПРИЗНАЊЕ ПРАВА ПРВЕНСТВА ИЗ РАНИЈИХ ПРИЈАВА:&#160;</span></strong></p>
                                </td>
                                <td style="width: 36.8pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 7.4pt;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;(30)</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="width: 135.65pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 1cm;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:center;'><span style="font-size:12px;line-height:107%;">Датум подношења раније пријаве</span></p>
                                </td>
                                <td style="width: 116.6pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 1cm;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:115%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;border:none;'><span style="font-size:12px;line-height:115%;">&#160;</span></p>
                                </td>
                                <td colspan="2" style="width: 129.05pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 1cm;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:center;'><span style="font-size:12px;line-height:107%;">Број раније пријаве&#160;</span></p>
                                </td>
                                <td colspan="3" style="width: 148.4pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 1cm;vertical-align: top;">
                                    <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:center;'><span style="font-size:12px;line-height:107%;">Двословна ознака државе, регионалне или међународне организације</span></p>
                                </td>
                            </tr>
                            <tr>
                                <xsl:for-each select="//p:Zahtev_za_patent/p:zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava/p:ranija_prijava">
                                    <tr>
                                        <td style="width: 19.05pt;border-top: none;border-left: 1.5pt solid black;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 17pt;vertical-align: top;">
                                            <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;text-align:center;'><strong>
                                                <span style="font-size:12px;line-height:  107%;">
                                                    <xsl:value-of select="position()"/>.
                                                </span></strong></p>
                                        </td>
                                        <td style="width: 116.6pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 17pt;vertical-align: top;">
                                            <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                                <span style="font-size:12px;line-height:107%;">&#160;
                                                    <xsl:value-of select="p:datum_podnosenja_ranije_prijave"/>
                                                </span></p>
                                        </td>
                                        <td style="width: 116.6pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 17pt;vertical-align: top;">
                                            <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'><span style="font-size:12px;line-height:107%;">&#160;</span></p>
                                        </td>
                                        <td colspan="2" style="width: 129.05pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 17pt;vertical-align: top;">
                                            <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                                <span style="font-size:12px;line-height:107%;">&#160;
                                                    <xsl:value-of select="p:broj_ranije_prijave"/>
                                                </span></p>
                                        </td>
                                        <td colspan="3" style="width: 148.4pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1.5pt solid black;padding: 0cm 5.4pt;height: 17pt;vertical-align: top;">
                                            <p style='margin-top:0cm;margin-right:0cm;margin-bottom:.15pt;margin-left:0cm;text-indent:0cm;line-height:107%;font-size:11px;font-family:Arial, Helvetica, sans-serif;color:black;'>
                                                <span style="font-size:12px;line-height:107%;">&#160;
                                                    <xsl:value-of select="p:dvoslovna_oznaka_drzave"/>
                                                </span></p>
                                        </td>
                                    </tr>
                                </xsl:for-each>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>