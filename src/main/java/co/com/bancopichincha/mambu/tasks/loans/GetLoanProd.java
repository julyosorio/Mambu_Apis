package co.com.bancopichincha.mambu.tasks.loans;

import co.com.bancopichincha.mambu.interactions.servicios.mambu.CallService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class GetLoanProd implements Task {
    private final String resource;
    private static Map<String, String> headers;

    public GetLoanProd(String resource, Map<String, String> headers) {
        this.resource = resource;
        this.headers = headers;
    }

    public static GetLoanProd call(String resource, Map<String, String> headers) {
        return new GetLoanProd(resource, headers);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restGet(resource, headers)
        );
    }
}
