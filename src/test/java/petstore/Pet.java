// 1 - Pacote
package petstore;

// 2 - Bibliotecas


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;


// 3 - Classe
public class Pet {

    // 3.1 Atributos

    String url = "https://petstore.swagger.io/v2/pet"; // endereço da entidade Pet
    //3.2 - Métodos e Funções

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir  - Create - Post
    @Test // Identifica o método ou função como um  teste para o TestNG
    public void IncluirPet() throws IOException {
        String JsonBody = lerJson("db/pet1.Json");

        // Sintaxe Gherkin
        // Dado - Quando - Então
        // Given - When - Then

        given() // dado
                .contentType("application/Json") // comum em API REST - antigas era "text/xml"
                .log().all()
                .body(JsonBody)
                .when()
                .post(url)
                .then()
                .log().all()
                .statusCode(200)
        ;
    }
}