package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class Get05HasSizeHasItemHasItems extends HerOkuAppBaseUrl {

    //https://restful-booker.herokuapp.com/apidoc/index.html
    // bu swagger dökümani
       /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends a GET request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
            (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)
     */

    @Test
    public void get05() {
        //Set the url
        //String url = "https://restful-booker.herokuapp.com/booking?firstname=Sally&lastname=Brown";
        spec.pathParam("first", "booking")
                    .queryParams("firstname", "Josh", "lastname", "Allen");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();


        //Do assertion
        response.then().statusCode(200).body("bookingid", hasSize(greaterThan(0)));
        //response.then().statusCode(200).body("bookingid", hasSize(Matchers.greaterThan(0)));
        //response icerisinde eleman var ise "hasSize(greaterThan(0))" bu ifade true döner ve testimiz gecer

        //yada
        assertTrue(response.asString().contains("bookingid")); //bir tane bile "bookingid" iceriyor ise testimiz gecer.


    }

}