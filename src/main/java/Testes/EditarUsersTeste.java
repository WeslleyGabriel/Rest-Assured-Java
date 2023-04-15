package Testes;

import Core.BaseTest;
import com.google.gson.JsonObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditarUsersTeste extends BaseTest {

    @Test
    public void test01_TestAtualizarPut() {
        JsonObject Json = new JsonObject();
        Json.addProperty("name", "Weslley");
        Json.addProperty("job","Dev");
        given()
                .body(Json.toString())
        .when()
                .put("users/2")
        .then()
                .body("name", is ("Weslley"))
                .body("job", is ("Dev"))
                .log().all()
            .statusCode(200);
    }

    @Test
    public void test02_TestAtualizarPath() {
        JsonObject Json = new JsonObject();
        Json.addProperty("name", "Weslley Gabriel");
        Json.addProperty("job","Programador");
        given()
                .body(Json.toString())
        .when()
                .patch("users/2")
        .then()
                .log().all()
                .body("name", is ("Weslley Gabriel"))
                .body("job", is ("Programador"))
            .statusCode(200);

    }

    @Test
    public void test03_TestAtualizarSemEnviarName() {
        JsonObject Json = new JsonObject();
        Json.addProperty("job","Quality Assurence");
        given()
                .body(Json.toString())
        .when()
                .patch("users/2")
        .then()
                .log().all()
                .body("job", is ("Quality Assurence"))
            .statusCode(200);

    }
    @Test
    public void test03_TestAtualizarSemEnviarEmail() {
        JsonObject Json = new JsonObject();
        Json.addProperty("name", "Weslley");
        given()
                .body(Json.toString())
        .when()
                .patch("users/2")
        .then()
                .log().all()
            .statusCode(200);

    }

    @Test
    public void test04_TestAtualizarSemEnviarCampos() {
        given()
        .when()
                .patch("users/2")
        .then()
                .log().all()
            .statusCode(200);

    }


}
