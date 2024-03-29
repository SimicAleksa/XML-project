<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:a="http://www.ftn.uns.ac.rs/AutorskaPrava"
                version="2.0">
    <xsl:template match="/">
        <html>
            <head>
            </head>
            <body>
                <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;line-height:115%;border:none;'><span style='font-size:15px;line-height:115%;font-family:Arial, Helvetica, sans-serif;color:black;'>&#160;</span></p>
                <div style='align-content: center;width: 100%;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;display: flex;justify-content: center;'>
                    <div>
                        <table style="width: 100%;border-collapse:collapse;border:none;">
                            <tbody>
                                <tr>
                                    <td style="width: 492.75pt;border: 1pt solid black;padding: 0cm 5.4pt;vertical-align: top;">
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><strong><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>ЗАВОД ЗА ИНТЕЛЕКТУАЛНУ СВОЈИНУ &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160;ОБРАЗАЦ А-1 &#160; &#160;</span></strong></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>Београд, Кнегиње Љубице 5</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;text-align:center;border:none;'><strong><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;color:black;'>ЗАХТЕВ ЗА УНОШЕЊЕ У ЕВИДЕНЦИЈУ И ДЕПОНОВАЊЕ АУТОРСКИХ ДЕЛА</span></strong></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 492.75pt;border-right: 1pt solid black;border-bottom: 1pt solid black;border-left: 1pt solid black;border-image: initial;border-top: none;padding: 0cm 5.4pt;vertical-align: top;">
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>1) Подносилац - име, презиме, адреса и држављанство аутора или другог носиоца ауторског права ако је подносилац физичко лице, односно пословно име и седиште носиоца ауторског права ако је подносилац правно лице</span><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif'>*</span><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>:</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:lice/a:fizicko_lice/a:ime"/> &#160;
                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:lice/a:fizicko_lice/a:prezime"/>
                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:lice/a:pravno_lice/a:poslovno_ime"/>
                                            </span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:lice/a:fizicko_lice/a:adresa/a:ulica"/> &#160;
                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:lice/a:fizicko_lice/a:adresa/a:broj"/>&#160;
                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:lice/a:fizicko_lice/a:adresa/a:grad"/>

                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:lice/a:pravno_lice/a:podaci_o_sedistu/a:adresa/a:ulica"/> &#160;
                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:lice/a:pravno_lice/a:podaci_o_sedistu/a:adresa/a:broj"/>&#160;
                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:lice/a:pravno_lice/a:podaci_o_sedistu/a:adresa/a:grad"/>

                                            </span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <table style="width: 100%;border-collapse:collapse;border:none;">
                                            <tbody>
                                                <tr>
                                                    <td style="width: 50%;border: 1pt solid black;padding: 0cm 5.4pt;height: 16.75pt;vertical-align: top;">
                                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                                            <span style='font-family:Arial, Helvetica, sans-serif'>телефон:&#160;
                                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:telefon"/>
                                                            </span></p>
                                                    </td>
                                                    <td style="width: 50%;border-top: 1pt solid black;border-right: 1pt solid black;border-bottom: 1pt solid black;border-image: initial;border-left: none;padding: 0cm 5.4pt;height: 16.75pt;vertical-align: top;">
                                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                                            <span style='font-family:Arial, Helvetica, sans-serif'>e-mail:&#160;
                                                                <xsl:value-of select="//a:podaci_o_podnosiocu/a:email"/>
                                                            </span></p>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>2) Псеудоним или знак аутора, (ако га има):</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                <xsl:value-of select="//a:pseudonim_ili_znak_autora"/>
                                            </span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>3) Име, презиме и адреса пуномоћника, ако се пријава подноси преко пуномоћника:</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                <xsl:value-of select="//a:podaci_o_punomocniku/a:ime"/>&#160;
                                                <xsl:value-of select="//a:podaci_o_punomocniku/a:prezime"/>
                                            </span></p>
                                        <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                            <xsl:value-of select="//a:podaci_o_punomocniku/a:adresa/a:ulica"/> &#160;
                                            <xsl:value-of select="//a:podaci_o_punomocniku/a:adresa/a:broj"/>&#160;
                                            <xsl:value-of select="//a:podaci_o_punomocniku/a:adresa/a:grad"/>
                                        </span>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>4) Наслов ауторског дела, односно алтернативни наслов, ако га има, по коме ауторско дело може да се идентификује</span><span style='font-size:16px;font-family:  Arial, Helvetica, sans-serif'>*</span><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>:</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                <xsl:value-of select="//a:podaci_o_delu/a:naslov"/>&#160;
                                                <xsl:value-of select="//a:podaci_o_delu/a:alternativni_naslov"/>&#160;
                                            </span>
                                        </p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>5) Подаци о наслову ауторског дела на коме се заснива дело прераде, ако је у питању ауторско дело прераде, као и податак о аутору изворног дела:</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                <xsl:value-of select="//a:podaci_o_delu/a:podaci_o_delu_prerade/a:naslov_dela_prerade"/>&#160;
                                                <xsl:value-of select="//a:podaci_o_delu/a:podaci_o_delu_prerade/a:autor_dela_prerade"/>&#160;
                                            </span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>6) Подаци о врсти ауторског дела (књижевно дело, музичко дело, ликовно дело, рачунарски програм и др.)</span><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif'>&#160;*</span><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>:</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                <xsl:value-of select="//a:podaci_o_delu/a:vrsta_autorskog_dela"/>&#160;
                                            </span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>7) Подаци о форми записа ауторског дела (штампани текст, оптички диск и слично)</span><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif'>&#160;*</span><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>:</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                <xsl:value-of select="//a:podaci_o_delu/a:forma_zapisa_autorskog_dela"/>&#160;
                                            </span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>8) Подаци о аутору ако подносилац пријаве из тачке 1. овог захтева није аутор и то: презиме, име, адреса и држављанство аутора (групе аутора или коаутора), а ако су у питању један или више аутора који нису живи, имена аутора и године смрти аутора а ако је у питању ауторско дело анонимног аутора навод да је ауторско дело дело анонимног аутора:&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <xsl:for-each select="//a:podaci_o_autoru">
                                            <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                                <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                    <xsl:value-of select="position()"/>. Autor --
                                                    <xsl:choose>
                                                        <xsl:when test="a:anoniman_autor = 'true'">
                                                            anoniman autor
                                                        </xsl:when>
                                                        <xsl:otherwise>
                                                            Ime <xsl:value-of select="a:autor/a:ime"/>,&#160;
                                                            Prezime <xsl:value-of select="a:autor/a:prezime"/>,
                                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                                Ulica <xsl:value-of select="a:autor/a:adresa/a:ulica"/>, &#160;
                                                                Broj <xsl:value-of select="a:autor/a:adresa/a:broj"/>,&#160;
                                                                Grad <xsl:value-of select="a:autor/a:adresa/a:grad"/>,
                                                            </span>
                                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                                Drzavljanstvo <xsl:value-of select="a:autor/a:drzavljanstvo"/>, &#160;
                                                                Godina smrti <xsl:value-of select="a:autor/a:godina_smrti"/>&#160;
                                                            </span>
                                                        </xsl:otherwise>
                                                    </xsl:choose>
                                                </span>
                                            </p>
                                        </xsl:for-each>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>9) Податак да ли је у питању ауторско дело створено у радном односу:</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                <xsl:choose>
                                                    <xsl:when test="//a:podaci_o_delu/a:delo_stvoreno_u_radnom_odnosu = 'true'">
                                                        Autorsko delo je stvoreno u radnom odnosu
                                                    </xsl:when>
                                                    <xsl:otherwise>
                                                        Autorsko delo nije stvoreno u radnom odnosu
                                                    </xsl:otherwise>
                                                </xsl:choose>
                                            </span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <br/><br/>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>10) Начин коришћења ауторског дела или намеравани начин коришћења ауторског дела:</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                                <xsl:value-of select="//a:podaci_o_delu/a:nacin_koriscenja_dela"/>&#160;
                                            </span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <br/><br/>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>11)</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <div style='margin-top:0cm;margin-right:0cm;margin-bottom:.0001pt;margin-left:-.05pt;text-indent:-.05pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif; display: flex; justify-content: flex-end; margin-right: 2%;'>
                                                <strong><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>____________________________________________
                                                </span></strong>
                                            </div>
                                        </p>
                                        <div style='margin-top:0cm;margin-right:0cm;margin-bottom:.0001pt;margin-left:-.05pt;text-indent:-.05pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif; display: flex; justify-content: flex-end; margin-right: 8%;'>
                                            <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'><strong>Подносилац пријаве, носилац права</strong></span>
                                        </div>
                                        <div style='margin-top:0cm;margin-right:0cm;margin-bottom:.0001pt;margin-left:-.05pt;text-indent:-.05pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif; display: flex; justify-content: flex-end; margin-right: 1%;'>
                                            <span style='width: 58%; font-size:16px;font-family:Arial, Helvetica, sans-serif;'>(место за потпис физичког лица, односно потпис заступника правног лица или овлашћеног представника у правном лицу)*</span>
                                        </div>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;text-indent:-1.45pt;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'></span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160; &#160; &#160;</span></p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <table style="width: 100%;border-collapse:collapse;border:none;">
                            <tbody>
                                <tr>
                                    <td colspan="3" style="width: 492.75pt;border-top: 1pt solid black;border-right: 1pt solid black;border-left: 1pt solid black;border-image: initial;border-bottom: none;padding: 0cm 5.4pt;height: 370.3pt;vertical-align: top;">
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>12) Прилози који се подносе уз захтев:</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'></p>
                                        <span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>
                                            <xsl:for-each select="//a:prilozi">
                                                <xsl:value-of select="position()"/>. Prilog --
                                                Opis dela: <xsl:value-of select="a:opis_dela"/>, &#160;
                                                Primer dela: <xsl:value-of select="a:primer_dela"/>&#160;
                                                <hr></hr>
                                            </xsl:for-each>
                                        </span>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;text-indent:-1.45pt;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160; &#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;text-align:center;'><strong><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>ПОПУЊАВА ЗАВОД:</span></strong></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;text-align:justify;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160; &#160; &#160;<strong>Прилози уз пријаву:</strong></span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style="font-size:16px;font-family:Czar;"></span><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;опис ауторског дела (ако је дело поднето на оптичком диску);</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style="font-size:16px;font-family:Czar;"></span><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif;'>&#160;пример ауторског дела (слика, видео запис, аудио запис)</span></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td rowspan="2" style="width: 317.25pt;border-right: 1pt solid black;border-bottom: 1pt solid black;border-left: 1pt solid black;border-image: initial;border-top: none;padding: 0cm 5.4pt;height: 49.8pt;vertical-align: top;">
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif'>&#160;</span></p>
                                    </td>
                                    <td style="width: 163.05pt;border-top: 1pt solid black;border-right: 1pt solid black;border-bottom: 1pt solid black;border-image: initial;border-left: none;padding: 0cm 5.4pt;height: 49.8pt;vertical-align: top;">
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:15px;font-family:Arial, Helvetica, sans-serif'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:19px;font-family:Arial, Helvetica, sans-serif'>Број пријаве</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:19px;font-family:Arial, Helvetica, sans-serif'>&#160;</span>
                                            <strong><span style='font-size:24px;font-family:Arial, Helvetica, sans-serif'>
                                                &#160;&#160;<xsl:value-of select="//a:broj_prijave"/>
                                            </span></strong></p>
                                    </td>
                                    <td rowspan="3" style="width: 12.45pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 49.8pt;vertical-align: top;">
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:11px;font-family:Arial, Helvetica, sans-serif'>&#160;</span></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 163.05pt;border-top: none;border-left: none;border-bottom: 1pt solid black;border-right: 1pt solid black;padding: 0cm 5.4pt;height: 29.25pt;vertical-align: top;">
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:11px;font-family:Arial, Helvetica, sans-serif'>&#160;</span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:19px;font-family:Arial, Helvetica, sans-serif'>
                                                Датум подношења: </span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'>
                                            <span style='font-size:15px;font-family:Arial, Helvetica, sans-serif'>
                                                <xsl:value-of select="//a:datum_podnosenja"/>
                                            </span></p>
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:15px;font-family:Arial, Helvetica, sans-serif'>&#160;</span></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="width: 480.3pt;border-top: none;border-left: 1pt solid black;border-bottom: 1pt solid black;border-right: none;padding: 0cm 5.4pt;height: 11.25pt;vertical-align: top;">
                                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:7px;font-family:Arial, Helvetica, sans-serif'>&#160;</span></p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <p style='margin:0cm;margin-bottom:.0001pt;font-size:13px;font-family:Verdana, Geneva, Tahoma, sans-serif;'><span style='font-size:16px;font-family:Arial, Helvetica, sans-serif'>Рубрике у захтеву А-1 које су означене са * морају да буду обавезно попуњене.</span></p>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>