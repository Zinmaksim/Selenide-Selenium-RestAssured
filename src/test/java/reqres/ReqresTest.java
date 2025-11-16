package reqres;

import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import reqres.pojo.userData.Data;
import reqres.pojo.userData.UserData;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;


// https://reqres.in/api-docs/#/default - swagger
public class ReqresTest extends ReqSpecification {
    private final static String URL = "https://reqres.in/api/";

    @Test
    @Disabled
    public void getListUsers() {
        UserData userData = requestSpec()
                .get(URL + "users?page=2&per_page=2")
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().as(UserData.class);

        System.out.println(userData.toString());
        System.out.println(userData.getPage());
        System.out.println(userData.getData().toString());
        List<String> featureList = userData.get_meta().getFeatures().stream().toList();
        System.out.println(featureList);

        System.out.println(featureList.size());

        List<Data> featureList30 = userData.getData().stream().filter(data -> data.getAvatar().contains("12-image")).toList();

        List<String> email = new ArrayList<>(userData.getData().stream().map(Data::getAvatar).toList());
        email.add(2, "https://ya.ru");
//Stream<String> emailFull = Stream.concat(email, Stream.of("A")); // другой способ

        System.out.println(email);


        //List<UserData> users = given()
        //       .log().all()
        //       .when()
        //       .contentType(ContentType.JSON)
        //       .get(URL + "users?page=2")
        //       .then()
        //       .log().all()
        //       .extract().body().jsonPath().getList("data", UserData.class); // здесь указываем путь и класс, куда извлечь ответ
        //int i  =0;

        //  ResponseBody responseGetUserId = given()
        //          .header(new Header("x-api-key", "reqres-free-v1"))
        //          .log().all()
        //          .when()
        //          .contentType(ContentType.JSON)
        //          .get(URL + "users/" + 7)
        //          //.then()
        //          .andReturn();
        //  //extract().response().body();

        //  responseGetUserId.prettyPrint();

    }

    @Test
    @Disabled
    public void postUser() {
        String body = "{\n" +
                "  \"username\": \"Zinevskiy\",\n" +
                "  \"email\": \"Zinevskiy.lawson@reqres.in\",\n" +
                "  \"password\": \"123KJNFF\"\n" +
                "}";
        Response responsePostUser = requestSpec()
                .body(body)
                .post(URL + "users")
                .then()
                .statusCode(201)
                .log().all()
                .extract().response()
                .andReturn();

        String id = responsePostUser.body().jsonPath().get("id");
        //  Response responseGetUserId = requestSpec()
        //          .get(URL + "users/" + id)
        //          .then()
        //          .statusCode(200)
        //          .log().all()
        //          .extract().response()
        //          .andReturn();

        //Response responseGetUser = given()
        //        .header(new Header("x-api-key", "reqres-free-v1"))
        //        .log().all()
        //        .when()
        //        .contentType(ContentType.JSON)
        //        .get(URL + "users")
        //        .then()
        //        .statusCode(200)
        //        .log().all()
        //        .extract().response()
        //        .andReturn();

        String bodyPut = "{\n" +
                "  \"username\": \"Zinevskiy\",\n" +
                "  \"email\": \"Zinevskiy.lawson@reqres.in\",\n" +
                "  \"password\": \"Apple985464\"\n" +
                "}";

        //  Response responsePutUser = given()
        //          .header(new Header("x-api-key", "reqres-free-v1"))
        //          .log().all()
        //          .when()
        //          .contentType(ContentType.JSON)
        //          .body(bodyPut)
        //          .put(URL + "users/" + id)
        //          .then()
        //          .statusCode(200)
        //          .log().all()
        //          .extract().response()
        //          .andReturn();


        // Response responsePostLogin = given()
        //         .header(new Header("x-api-key", "reqres-free-v1"))
        //         .log().all()
        //        .when()
        //        .contentType(ContentType.JSON)
        //        .body(body)
        //        .post(URL + "login")
        //        .then()
        //        //.statusCode(200)
        //        .log().all()
        //        .extract().response()
        //        .andReturn();
    }

    @Test
    //@Disabled
    public void getUsers() {
        Response responseGetUsers = requestSpec()
                .get(URL + "users")
                .then()
                .statusCode(200)
                .log().all()
                .assertThat().body(matchesJsonSchemaInClasspath
                        ("schemas/reqres/getUser.schema.json")
                        .using(settings().with().checkedValidation(false)))
                .extract().response()
                .andReturn();

    }
}





