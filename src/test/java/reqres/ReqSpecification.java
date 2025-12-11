package reqres;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ReqSpecification {
    public static RequestSpecification requestSpec() {
        return
                given()
                .contentType(ContentType.JSON)
                .header(new Header("x-api-key", "reqres-free-v1"))
                .log().all()
                .when();
    }

}
