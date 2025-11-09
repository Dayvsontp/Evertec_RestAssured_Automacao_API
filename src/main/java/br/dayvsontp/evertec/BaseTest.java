package br.dayvsontp.evertec;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

// Importa todas as constantes estáticas (APP_BASE_URL, APP_PORT, etc.)
import static br.dayvsontp.evertec.Constants.*;

public class BaseTest {

    @BeforeAll
    public static void setup() {

        RestAssured.baseURI = APP_BASE_URL;
        RestAssured.port = APP_PORT;

        RestAssured.basePath = APP_BASE_PATH;

    }

}