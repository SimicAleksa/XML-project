package com.example.XML_WS_Trademark_backend.database;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class DBAuthManager {
    @Value("${conn.user}")
    private String user;
    @Value("${conn.password}")
    private String password;
    @Value("${conn.host}")
    private String host;
    @Value("${conn.port}")
    private String port;
    @Value("${conn.driver}")
    private String driver;
    @Value("${conn.uri}")
    private String uri;
}