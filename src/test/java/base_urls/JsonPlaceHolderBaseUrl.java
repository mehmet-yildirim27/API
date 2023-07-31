package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    // Request icin gerekli olan hersey burada olacak
    // SetUp() ile tekrarli yapilacak islemleri topluyoruz ve test öncesi calisacak sekilde
    // @Before annotasyonuna ekliyoruz

    protected RequestSpecification spec; // Request'imizi spesifik hale getiriyoruz
    // "RequestSpecification" interface oldugu icin, objeyi "RequestSpecBuilder" classindan olusturururz.
    // build() diyerek bitirmek gerekiyor

    @Before
    public void setUp(){ // Her test metodu öncesinde calisir.
        spec = new RequestSpecBuilder()
                                       .setContentType(ContentType.JSON)
                                       .setAccept(ContentType.JSON)
                                       .setBaseUri("https://jsonplaceholder.typicode.com/")
                                       .build();

        // "setContentType(ContentType.JSON)" ile gönderecegimiz datanin icerigini,
        // "setAccept(ContentType.JSON)" ile karsi tarafin alacagi accept type'i belirtiyoruz
        //Accept type is “application/json” ==> Yukariya ekledim
    }
}
