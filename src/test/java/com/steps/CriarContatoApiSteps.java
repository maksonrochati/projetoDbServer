package com.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class CriarContatoApiSteps {
    Response response;

    @Dado("que eu tenha um endpoint valido para criar o usuario")
    public void que_eu_tenha_um_endpoint_valido_para_criar_o_usuario() {
        RestAssured.baseURI="https://api-de-tarefas.herokuapp.com/";
    }
    @Quando("envio requisicao para o servidor")
    public void envio_requisicao_para_o_servidor() {
        response =   given()
                .contentType(ContentType.JSON)
                .header("Accept","application/vnd.tasksmanager.v2")
                .body("{\n" +
                        "\t\"name\": \"test5\",\n" +
                        "\t\"last_name\": \"test\",\n" +
                        "\t\"email\": \"test5987@gmail.com\",\n" +
                        "\t\"age\": \"28\",\n" +
                        "\t\"phone\": \"99999999999\",\n" +
                        "\t\"address\": \"Rua dois\",\n" +
                        "\t\"state\": \"Minas Gerais\",\n" +
                        "\t\"city\": \"Belo Horizonte\"\n" +
                        "}")
                .when()
                    .post("contacts")
                .then()
                    .extract()
                        .response();
    }
    @Entao("valido os dados e status code de resposta")
    public void valido_os_dados_e_status_code_de_resposta() {
        String dataType = response.path("data.type");
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(dataType, "contacts");
    }
}
