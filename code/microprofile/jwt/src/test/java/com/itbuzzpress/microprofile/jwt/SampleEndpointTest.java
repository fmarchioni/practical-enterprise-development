package com.itbuzzpress.microprofile.jwt;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.Reader;
import java.io.StringReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

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

        JsonReader jsonReader = Json.createReader(new StringReader(response.getBody().asString()));
        JsonObject object = jsonReader.readObject();
        String userToken = object.getString("access_token");

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

        jsonReader = Json.createReader(new StringReader(response.getBody().asString()));
        object = jsonReader.readObject();
        String adminToken = object.getString("access_token");

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