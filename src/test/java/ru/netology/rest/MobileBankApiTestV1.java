package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
        given()
                //Which URL-URI are we referring
                .baseUri("http://localhost:9999/api/v1")

        .when()
                //Which request are we use
                .get("/demo/accounts")

        .then()
                //What we must check - ACTIONS
                .statusCode(200)
                // static import for JsonSchemaValidator.matchesJsonSchemaInClasspath
               .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
                //Check Currency correct Symbol style
               .body("[0].currency", equalTo("RUB"))

        ;
    }
}