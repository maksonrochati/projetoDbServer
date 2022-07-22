package com.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class DeletarContatoApiSteps {
    Response response;

    @Dado("que eu tenha um endpoint valido para deletar o usuario")
    public void que_eu_tenha_um_endpoint_valido_para_deletar_o_usuario() {
        RestAssured.baseURI="https://api-de-tarefas.herokuapp.com/";
    }
    @Quando("eu enviar a requisicao ao servidor")
    public void eu_enviar_a_requisicao_ao_servidor() {
        response = given()
                .when()
                    .delete("contacts/2496")
                .then()
                    .extract()
                        .response();
    }
    @Entao("devo validar dados e status code de resposta")
    public void devo_validar_dados_e_status_code_de_resposta() {
        Assert.assertEquals(response.statusCode(), 204);
    }

}
