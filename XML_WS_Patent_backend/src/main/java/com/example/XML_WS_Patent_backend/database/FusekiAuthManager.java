package com.example.XML_WS_Patent_backend.database;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class FusekiAuthManager {
    @Value("${fuseki.endpoint}")
    public String endpoint;
    @Value("${fuseki.dataset}")
    public String dataset;
    @Value("${fuseki.query}")
    public String queryEndpoint;
    @Value("${fuseki.update}")
    public String updateEndpoint;
    @Value("${fuseki.data}")
    public String dataEndpoint;
}
