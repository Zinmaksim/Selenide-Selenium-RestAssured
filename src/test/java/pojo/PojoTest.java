package pojo;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;


public class PojoTest {

    @Test
    public void checkBook() {
        Bookingdates bookingDates = new Bookingdates("2021-08-31", "2021-09-10");
        Booking booking = new Booking("John", "Doe", 100, true, bookingDates, "Breakfast");

        BookingInfo bookingInfo =
                given().log().all()
                        .contentType("application/json")
                        .accept("application/json")
                        .body(booking)
                        .post("https://restful-booker.herokuapp.com/booking")
                        .then().log().all()
                        .statusCode(200).assertThat()
                        .extract().
                        body().
                        as(BookingInfo.class);
        System.out.println("AAAAAAAAAAA: " + bookingInfo.toString());

     //  Booking checkBooking = given()
     //                .get("https://restful-booker.herokuapp.com/booking/" + bookingInfo.getBookingid())
     //                .then()
     //                .extract().body().as(Booking.class);

     //  Assertions.assertEquals(bookingInfo.getBooking().toString(), checkBooking.toString());

        given().get("https://restful-booker.herokuapp.com/booking/" + bookingInfo.getBookingid())
                .then().assertThat().body(matchesJsonSchemaInClasspath
                        ("schemas/book/book.schema.json")
                        .using(settings().with().checkedValidation(false)));
    }
    }

