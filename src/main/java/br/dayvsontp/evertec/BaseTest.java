package br.dayvsontp.evertec;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest implements Constants {

    @BeforeClass
    public static void setup() {

        RestAssured.baseURI = APP_BASE_URL;
        RestAssured.port = APP_PORT;
        RestAssured.basePath = APP_BASE_PATH;

    }

}
