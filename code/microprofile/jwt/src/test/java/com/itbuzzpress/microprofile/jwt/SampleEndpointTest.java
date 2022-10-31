package com.itbuzzpress.microprofile.jwt;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SampleEndpointTest {

    String keycloakURL ="http://localhost:8180";

    @Test
    public void testJWTEndpoint() {

        String secret ="mysecret";
        RestAssured.baseURI = keycloakURL;
        Response response = given().urlEncodingEnabled(true)
                .auth().preemptive().basic("jwt-client", secret)
                .param("grant_type", "password")
                .param("client_id", "jwt-client")
                .param("username", "test")
                .param("password", "test")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/auth/realms/myrealm/protocol/openid-connect/token")
                .then().statusCode(200).extract()
                .response();

        JsonPath jsonPathEvaluator = response.jsonPath();

        String userToken = jsonPathEvaluator.get("access_token");

        response = given().urlEncodingEnabled(true)
                .auth().preemptive().basic("jwt-client", secret)
                .param("grant_type", "password")
                .param("client_id", "jwt-client")
                .param("username", "admin")
                .param("password", "test")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/auth/realms/myrealm/protocol/openid-connect/token")
                .then().statusCode(200).extract()
                .response();

        jsonPathEvaluator = response.jsonPath();

        String adminToken = jsonPathEvaluator.get("access_token");

        RestAssured.baseURI = "http://localhost:8080/jwt-demo/rest/jwt";

        given().auth().preemptive()
                .oauth2(userToken)
                .when().get("/gouser")
                .then()
                .statusCode(200);

        given().auth().preemptive()
                .oauth2(adminToken)
                .when().get("/goadmin")
                .then()
                .statusCode(200);

     }

}