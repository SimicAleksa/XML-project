package com.example.XML_WS_Patent_backend.database;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ExistAuthManager {
    @Value("${exist.user}")
    private String user;
    @Value("${exist.password}")
    private String password;
    @Value("${exist.host}")
    private String host;
    @Value("${exist.port}")
    private String port;
    @Value("${exist.driver}")
    private String driver;
    @Value("${exist.uri}")
    private String uri;
}