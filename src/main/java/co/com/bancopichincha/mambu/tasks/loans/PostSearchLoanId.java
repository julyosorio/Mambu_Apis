package co.com.bancopichincha.mambu.tasks.loans;

import co.com.bancopichincha.mambu.interactions.servicios.mambu.CallService;
import co.com.bancopichincha.mambu.models.loantransaction.BodySearchLoan;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class PostSearchLoanId implements Task {
    private final String resource;
    private final BodySearchLoan body;
    private final Map<String,String> header;

    public PostSearchLoanId(String resource, BodySearchLoan body, Map<String, String> header) {
        this.resource = resource;
        this.body = body;
        this.header = header;
    }

    public static PostSearchLoanId call (String resource, BodySearchLoan body, Map<String,String> header){
        return new PostSearchLoanId(resource, body, header);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restPost(resource,body,header)
        );
    }
}
