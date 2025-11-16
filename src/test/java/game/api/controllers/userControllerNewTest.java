package game.api.controllers;

import game.api.controllers.pojo.Users;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.game.userControllerNew.ResponseBodyGetUser;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class UserControllerNewTest {
    String URL = "http://85.192.34.140:8080/api/";

    public String getToken() {
        String bodyUser = "{ \"password\": \"qeqeqewgterhehrthrrt\", \"username\": \"340ami.hintz@yahoo.com\"}";
        String token = given().log().all()
                .when().contentType(ContentType.JSON).body(bodyUser).post(URL + "login")
                .then()
                .log().all()
                .statusCode(200).extract().body().jsonPath().get("token");
        return token;
    }

    @Test
    public void getListUsers() {
        List<Users> users = List.of(given()
                .log().all()
                .when()
                .get(URL + "users")
                .as(Users[].class));

        Assertions.assertEquals(users.size(), 100);
        List<String> usersWithEmail = users.stream().map(Users::getUser).filter(user -> user.contains("@")).toList();
        int sizeListUsersWithEmail = usersWithEmail.size();
        System.out.println("size of usersWithEmail: " + sizeListUsersWithEmail + "\n" +
                "usersWithEmail: ");
        usersWithEmail.forEach(System.out::println);

    }

    @Test
    public void getUser() {
        ResponseBodyGetUser responseBodyGetUser = given().log().all()
                .header("Authorization", "Bearer " + getToken())
                .when()
                .get(URL + "user")
                .then().log().all().statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/game/getUser.schema.json"))
                .extract().response().getBody().as(ResponseBodyGetUser.class);

        Assertions.assertEquals("qeqeqewgterhehrthrrt", responseBodyGetUser.getPass());
        Assertions.assertEquals("340ami.hintz@yahoo.com", responseBodyGetUser.getLogin());


    }
}
