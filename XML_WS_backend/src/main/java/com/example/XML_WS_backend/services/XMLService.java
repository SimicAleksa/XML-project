package com.example.XML_WS_backend.services;

import com.example.XML_WS_backend.custom_utils.xml_parsers.TrademarkParser;
import org.springframework.stereotype.Service;

@Service
public class XMLService {
    public void readTrademarkXMLFile() {
        TrademarkParser.print(TrademarkParser.read());
    }
}
