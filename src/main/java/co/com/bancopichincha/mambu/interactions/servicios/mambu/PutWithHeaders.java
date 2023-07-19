package co.com.bancopichincha.mambu.interactions.servicios.mambu;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PutWithHeaders extends RestInteraction {

    private String resource;
    private Object body;

    private Map<String, String> headers = new HashMap<>();

    public PutWithHeaders(String resource, Object body, Map<String, String> headers) {
        this.resource = resource;
        this.body = body;
        this.headers = headers;
    }


    @Step("{0} executes a PUT on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .log().all()
                .headers(headers)
                .body(body)
                .when()
                .put(as(actor).resolve(resource));
    }
}
