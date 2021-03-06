package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}

@RestController
@RefreshScope
class ClientRestController{

    private final String value;
    @Value("${bonus:empty}")
    private String bonusValue;

    public ClientRestController(@Value("${foo:test}") String value) {
        this.value = value;
    }

    @GetMapping("/foo")
    String foo() {
        return this.value;
    }

    @GetMapping("/bonus")
    String bonus() {
        return this.bonusValue;
    }
}
