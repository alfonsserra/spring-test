package com.systelab.spring.integration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.factory.Jackson2ObjectMapperFactory;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;
import static io.restassured.config.SSLConfig.sslConfig;
import static org.hamcrest.CoreMatchers.hasItems;

@Tag("integration")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerRestAssuredIntegrationTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
        RestAssured.basePath = "/";
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.config = RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation())
                .and().objectMapperConfig((new ObjectMapperConfig().jackson2ObjectMapperFactory(
                        new Jackson2ObjectMapperFactory() {
                            @Override
                            public com.fasterxml.jackson.databind.ObjectMapper create(Type type, String s) {
                                com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
                                objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                                return objectMapper;
                            }
                        })));
    }

    @Test
    public void testGetUserList() {
        given().contentType(ContentType.JSON).when().get("/customers").then().statusCode(200).body("firstName", hasItems("Josh","Antonio"));
    }
}
