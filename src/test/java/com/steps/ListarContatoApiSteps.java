package com.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.Arrays;

import static io.restassured.RestAssured.given;


public class ListarContatoApiSteps {

    Response response;

    @Dado("que eu tenha um endpoint valido para lista o usuario")
    public void que_eu_tenha_um_endpoint_valido_para_lista_o_usuario() {
        RestAssured.baseURI="https://api-de-tarefas.herokuapp.com/";
    }
    @Quando("enviar a requisicao ao servidor")
    public void enviar_a_requisicao_ao_servidor() {
        response = given()
                .when()
                    .get("contacts")
                .then()
                    .extract()
                        .response();

    }
    @Entao("valido dados e status code de resposta")
    public void valido_dados_e_status_code_de_resposta() {
        String dataType = response.path("data[3].type");
        Assert.assertEquals(dataType, "contacts");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNotNull(response.path("data[3].id"), 200);

    }
}
