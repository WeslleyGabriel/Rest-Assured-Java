package Testes;

import Core.BaseTest;
import com.clumd.projects.javajson.api.Json;
import com.google.gson.JsonObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;
import static org.hamcrest.Matchers.is;

    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public class AdicionarUsersTeste extends BaseTest {


        @Test
        public void  test01_TestPostLoginSemSucesso() {
            JsonObject Json = new JsonObject();
            Json.addProperty("email", "eve.holt@reqres.in");
            given()
                    .body(Json.toString())
            .when()
                    .post("/login")
            .then()
                    .log().all()
                    .body("error", is("Missing password"))
                    .statusCode(400);
        }

      @Test
      public void test08_TestPostLoginComSenhaEmail(){
            JsonObject Json = new JsonObject();
            Json.addProperty("email", "eve.holt@reqres.in");
            Json.addProperty("password", "cityslicka");
            given()
                    .body(Json.toString())
                    .when()
                    .post("/login")
                    .then()
                    .log().all()
                    .body("token", is("QpwL5tke4Pnpja7X4"))
                    .statusCode(200);
      }

        @Test
        public void  test02_TestPostLoginRegistroSucesso() {
            JsonObject Json = new JsonObject();
            Json.addProperty("email", "eve.holt@reqres.in");
            Json.addProperty("password", "cityslicka");
            given()
                    .body(Json.toString())
                    .when()
                    .post("/register")
                    .then()
                    .log().all()
                    .body("id", is(4))
                    .body("token", is("QpwL5tke4Pnpja7X4"))
                    .statusCode(200);
        }

        @Test
        public void  test03_TestPostRegistroSemPassword() {
            JsonObject Json = new JsonObject();
            Json.addProperty("email", "eve.holt@reqres.in");
            given()
                    .body(Json.toString())
                    .when()
                    .post("/register")
                    .then()
                    .log().all()
                    .body("error", is("Missing password"))
                    .statusCode(400);
        }


        @Test
        public void  test04_TestPostLoginSemPassword() {
            JsonObject Json = new JsonObject();
            Json.addProperty("email", "eve.holt@reqres.in");
            given()
                    .body(Json.toString())
                    .when()
                    .post("/login")
                    .then()
                    .log().all()
                    .body("error", is ("Missing password"))
                    .statusCode(400);
        }


    }
