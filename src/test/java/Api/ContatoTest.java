package Api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

public class ContatoTest {

    //@Test
    public void testListarContatoComSucesso(){
        RestAssured.baseURI = "https://api-de-tarefas.herokuapp.com/";

        RestAssured
                .given()
                .when()
                    .get("contacts/1885")
                .then()
                    .assertThat()
                        .statusCode(200)
                        .body("data.id", Matchers.equalTo("1885"))
                        .body("data.type", Matchers.equalTo("contacts"));
    }

    //@Test
    public void testCriarContatoComSucesso(){
        RestAssured.baseURI = "https://api-de-tarefas.herokuapp.com/";

        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .header("Accept","application/vnd.tasksmanager.v2")
                    .body("{\n" +
                            "\t\"name\": \"test5\",\n" +
                            "\t\"last_name\": \"test\",\n" +
                            "\t\"email\": \"test75@gmail.com\",\n" +
                            "\t\"age\": \"28\",\n" +
                            "\t\"phone\": \"99999999999\",\n" +
                            "\t\"address\": \"Rua dois\",\n" +
                            "\t\"state\": \"Minas Gerais\",\n" +
                            "\t\"city\": \"Belo Horizonte\"\n" +
                            "}")
                .when()
                    .post("contacts")
                .then()
                    .assertThat()
                        .statusCode(201)
                        .body("data.id", Matchers.notNullValue())
                        .body("data.type", Matchers.equalTo("contacts"));
    }

    //@Test
    public void testEditarContatoComSucesso(){
        RestAssured.baseURI = "https://api-de-tarefas.herokuapp.com/";

        RestAssured
                .given()
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
                    .assertThat()
                        .statusCode(404);

    }

    //@Test
    public void testDeletarContatoComSucesso(){
        RestAssured.baseURI = "https://api-de-tarefas.herokuapp.com/";

        RestAssured
                .given()
                .when()
                    .delete("contacts/2327")
                .then()
                    .assertThat()
                        .statusCode(204);
    }
}
