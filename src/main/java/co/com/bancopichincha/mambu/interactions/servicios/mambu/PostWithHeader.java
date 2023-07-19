package co.com.bancopichincha.mambu.interactions.servicios.mambu;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostWithHeader extends RestInteraction {

    private final String resource;
    private final Object body;
    private final Map<String, Object> header;


    public PostWithHeader(String resource, Object body, Map<String, Object> header) {
        this.resource = resource;
        this.body = body;
        this.header = header;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .relaxedHTTPSValidation()
                .log().all()
                .headers(header)
                .header("Content-type", "application/json")
                .body(body)
                .when()
                .post(as(actor).resolve(resource)).then().log().all();
    }
}
