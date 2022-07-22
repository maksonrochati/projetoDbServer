package com.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class EditarContatoApiSteps {
    Response response;

    @Dado("que eu tenha um endpoint valido para editar o usuario")
    public void que_eu_tenha_um_endpoint_valido_para_editar_o_usuario() {
        RestAssured.baseURI="https://api-de-tarefas.herokuapp.com/";
    }
    @Quando("envio a requisicao ao servidor")
    public void envio_a_requisicao_ao_servidor() {
        response =    given()
                .contentType(ContentType.JSON)
                .header("Accept","application/vnd.tasksmanager.v2")
                .header("Location","/contacts/1885")
                .body("{\n" +
                        "\t\"id\": 1885,\n" +
                        "\t\"name\": \"test2\",\n" +
                        "\t\"last_name\": \"test2\",\n" +
                        "\t\"email\": \"tes68@gmail.com\",\n" +
                        "\t\"age\": \"27\",\n" +
                        "\t\"phone\": \"219847595555\",\n" +
                        "\t\"address\": \"Rua\",\n" +
                        "\t\"state\": \"Minas\",\n" +
                        "\t\"city\": \"Belo\"\n" +
                        "}")
                .when()
                    .put("contacts")
                .then()
                    .extract()
                        .response();
    }
    @Entao("devo validar os dados e status code de resposta")
    public void devo_validar_os_dados_e_status_code_de_resposta() {
        Assert.assertEquals(response.statusCode(), 404);
    }

}
