package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private Boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

    public Booking() {
    }

    public Booking(String firstname, String lastname, int totalprice, Boolean depositpaid, Bookingdates bookingdates, String additionalneeds){
    this.firstname = firstname;
    this.lastname = lastname;
    this.totalprice = totalprice;
    this.depositpaid = depositpaid;
    this.bookingdates = bookingdates;
    this.additionalneeds = additionalneeds;
}

    @Override
    public String toString() {
        return "Booking{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
