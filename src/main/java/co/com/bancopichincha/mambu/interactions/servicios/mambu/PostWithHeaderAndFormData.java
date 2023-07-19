package co.com.bancopichincha.mambu.interactions.servicios.mambu;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostWithHeaderAndFormData extends RestInteraction {
    private final String resource;
    private final Map<String, Object> header;
    private final List<String> formData;

    public PostWithHeaderAndFormData(String resource, List<String> formData, Map<String, Object> header) {
        this.resource = resource;
        this.formData = formData;
        this.header = header;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType("multipart/form-data")
                .relaxedHTTPSValidation()
                .headers(header)
                .formParam("client_id", formData.get(0))
                .formParam("scope", formData.get(1))
                .formParam("grant_type", "refresh_token")
                .formParam("client_info", "1")
                .formParam("client-request-id", formData.get(2))
                .formParam("refresh_token", formData.get(3))
                .when()
                .post(as(actor).resolve(resource));
    }
}
