package tests;

import br.dayvsontp.evertec.BaseTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesRegex;

public class DogApi extends BaseTest {

    private static String selectedBreed;

    @Test
    @Order(1)
    public void listarBreeds (){
        Map<String, ?> breedsMap = RestAssured.given()
                .when()
                    .get("/breeds/list/all")
                .then()
                .statusCode(200)
                .extract().jsonPath().getMap("message"); // Extrai o corpo como string

        Set<String> breedKeys = breedsMap.keySet();
        List<String> breedNames = new ArrayList<>(breedKeys);

        //Verifica se a lista não está vazia
        if (breedNames.isEmpty()) {
            throw new AssertionError("A lista de raças não deve estar vazia.");
        }

        // escolhe o indice(Random)
        Random random = new Random();
        int randomIndex = random.nextInt(breedNames.size());

        // Seleciona a raça do random
        selectedBreed = breedNames.get(randomIndex);

        System.out.println("Raça aleatória selecionada: " + selectedBreed);

    }

    @Test
    @Order(2)
    public void buscarImagemDaRaca() {
        if (selectedBreed != null) {
            RestAssured.given()
                    .when()
                    .get("/breed/" + selectedBreed + "/images")
                    .then()
                    .statusCode(200)
                    .log().all();
        } else {
            System.out.println("Teste 'buscarImagemDaRaca' ignorado, pois 'selectedBreed' é nulo.");
        }
    }

    @Test
    @Order(3)
    public void buscarImagemRandom() {

            RestAssured.given()
                    .when()
                    .get("/breeds/image/random")
                    .then()
                    .body("status", equalTo("success"))

//                    validando, que a Url da imagem é valida, com hamcrest
                    .body("message", matchesRegex("^https?://.*\\.(jpg|jpeg|png)$"))
                    .statusCode(200)
                    .log().all();

    }

    @Test
    @Order(4)
    public void buscarNoEndPointIncorreto() {
        RestAssured.given()
                .when()
                .get("/breeds/noEndPointIncorreto")
                .then()
                .statusCode(404)
                .log().all();

    }
}
