package wireMock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;

public class MockTest {
    private WireMockServer wireMockServer;
    private RequestSpecification requestSpec;

    @BeforeEach
    public void setup() {
        //Инициализация WireMock server
        wireMockServer = new WireMockServer(options().port(8080));
        wireMockServer.start();
        WireMock.configureFor("localhost", 8080);

        // Настройка mock endpoint
       WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/users"))
              .willReturn(WireMock.aResponse()
                      .withStatus(501)
                      .withHeader("Content-Type", "application/json")
                      .withBody("{\"message\": \"Hello from WireMock!\"}")));

        requestSpec = given()
                .baseUri("http://localhost")
                .port(8080)
                .contentType("application/json");
    }

    @AfterEach
    public void teardown() {
        wireMockServer.resetAll();
        wireMockServer.stop();
    }

    @Test
    public void getUsers() {
        requestSpec.when()
                .get("/api/users")
                .then()
                .assertThat()
                .statusCode(501)
                .log().all();



    }
}
