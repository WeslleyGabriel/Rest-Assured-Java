package Testes;

import Core.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListarUsersTeste extends BaseTest {

    @Test
    public void test01_TestListarUmUnicoUsuario() {
        given()
        .when()
                .get("users/2")
        .then()
                .body("data.id",is (2))
                .body("data.email", is("janet.weaver@reqres.in"))
                .body("data.first_name", is ("Janet"))
                .body("data.last_name", is("Weaver"))
                .body("data.avatar", is ("https://reqres.in/img/faces/2-image.jpg"))
                .body("support.url", is("https://reqres.in/#support-heading"))
                .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"))
                .log().all()
            .statusCode(200);
    }

    @Test
    public void test02_TestListarTodosUsuarios() {
        given()
        .when()
                .get("/users?page=2")
        .then()
                .body("page", is (2))
                .body("total", is (12))
                .body("data.id[0]",is (7))
                .body("data.email[0]", is("michael.lawson@reqres.in"))
                .body("data.first_name[0]", is ("Michael"))
                .body("data.last_name[0]", is("Lawson"))
                .body("data.avatar[0]", is ("https://reqres.in/img/faces/7-image.jpg"))
                .log().all()
            .statusCode(200);
    }

    @Test
    public void test03_TestListarUsuarioUnicoNaoIndentificado() {
        given()
        .when()
                .get("api/users/23")
        .then()
                .body(equalTo("{}"))
            .statusCode(404);
    }

    @Test
    public void test04_TestListarRecursos() {
        given()
        .when()
                .get("/unknown")
        .then()
                .body("page", is (1))
                .body("total", is (12))
                .body("data.id[0]",is (1))
                .body("data.name[0]", is("cerulean"))
                .body("data.year[0]", is (2000))
                .body("data.color[0]", is ("#98B2D1"))
                .body("data.pantone_value[0]", is ("15-4020"))
                .log().all()
            .statusCode(200);
    }

    @Test
    public void test05_TestUnicoRecurso() {
        given()
        .when()
                .get("/unknown/2")
        .then()
                .body("data.id",is (2))
                .body("data.name", is("fuchsia rose"))
                .body("data.year", is (2001))
                .body("data.color", is ("#C74375"))
                .body("data.pantone_value", is ("17-2031"))
                .log().all()
            .statusCode(200);
    }

    @Test
    public void test06_TestUnicoRecursoNaoEncontrado() {
        given()
        .when()
                .get("/unknown/23")
        .then()
                .log().all()
            .statusCode(404);
    }

    @Test
    public void test07_TestRespostaAtrasada() {
        given()
        .when()
                .get("/users?delay=3")
        .then()
                .body("page", is (1))
                .body("total", is (12))
                .body("data.id[0]",is (1))
                .body("data.email[0]", is("george.bluth@reqres.in"))
                .body("data.first_name[0]", is ("George"))
                .body("data.last_name[0]", is ("Bluth"))
                .body("data.avatar[0]", is ("https://reqres.in/img/faces/1-image.jpg"))
                .log().all()
            .statusCode(200);

    }

}
