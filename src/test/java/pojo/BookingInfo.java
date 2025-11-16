package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookingInfo {
//"bookingid": 36,
//        "booking": {
//        "firstname": "John",
//                "lastname": "Doe",
//                "totalprice": 100,
//                "depositpaid": true,
//                "bookingdates": {
//            "checkin": "2021-08-31",
//                    "checkout": "2021-09-10"
//        },
//        "additionalneeds": "Breakfast"
//    }

    private int bookingid;

    public BookingInfo() {
    }

    private Booking booking;

    @Override
    public String toString() {
        return "BookingInfo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
