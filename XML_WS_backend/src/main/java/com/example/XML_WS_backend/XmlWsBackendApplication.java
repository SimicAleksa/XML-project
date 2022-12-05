package com.example.XML_WS_backend;

import com.example.XML_WS_backend.jaxb.JaxBParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmlWsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlWsBackendApplication.class, args);
		JaxBParser jb = new JaxBParser();
		jb.test();
	}

}
