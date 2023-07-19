package co.com.bancopichincha.mambu.interactions.servicios.mambu;


import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Delete extends RestInteraction {
    private final String resource;

    public Delete(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a DELETE on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .when()
                .delete(as(actor).resolve(resource));
    }
}
