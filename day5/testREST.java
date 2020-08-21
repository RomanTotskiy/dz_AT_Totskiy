package testREST;

import org.junit.Rule;
import org.junit.rules.Timeout;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TestRES {

    static String rapidapi_host = "wft-geo-db.p.rapidapi.com";
    static String rapidapi_key = "0e6dd8bfc8mshcd20a4d1a065548p115f1bjsnb7cfc95f13c7";

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Test
    public void LocalesTEST() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                queryParam("offset", "200").
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/locales").
                then().
                assertThat().
                body("links[1].rel", equalTo("prev"));
        Thread.sleep(300);

    }

    @Test
    public void CurrenciesTEST() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                queryParam("offset", "50").
                queryParam("hateoasMode", true).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/currencies").
                then().
                assertThat().
                body("data[1].code", equalTo("AFN")).
                body("metadata.totalCount", equalTo(205));
        Thread.sleep(600);
    }

    @Test
    public void TimezonesTEST() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/timezones").
                then().
                assertThat().
                body("links[2].rel", equalTo("next"));
        Thread.sleep(1000);
    }

    @Test
    public void CitiesTEST() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/geo/cities/Q60").
                then().
                assertThat().
                body("data.name", equalTo("Tokyo"));
        Thread.sleep(1000);
    }

    @Test
    public void CountriesTEST() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/geo/countries").
                then().
                assertThat().
                body("data[2].code", equalTo("ME"));
        Thread.sleep(500);
    }
}