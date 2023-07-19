package co.com.bancopichincha.mambu.interactions.servicios.mambu;


import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import net.thucydides.core.annotations.Step;

public class Post extends RestInteraction {

    private final String resource;
    private final Object body;

    public Post(String resource, Object body) {
        this.resource = resource;
        this.body = body;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
				  	 .log().all()
                .body(body)
                .when()
                .post(as(actor).resolve(resource));
    }
}