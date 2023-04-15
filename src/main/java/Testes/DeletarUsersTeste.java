package Testes;


import Core.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeletarUsersTeste extends BaseTest {

    @Test
    public void test01_TesteDeletarUser(){
        given()
        .when()
                .delete("users/2")
        .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    public void test02_TesteDeletarSemPassarID(){
        given()
        .when()
                .delete("users")
        .then()
                .log().all()
            .statusCode(204);
    }

    @Test
    public void test03_TesteDeletarIdInexistente(){
        given()
        .when()
                .delete("users/-15")
        .then()
                .log().all()
            .statusCode(204);
    }

}
