package co.com.bancopichincha.mambu.tasks.clients;

import co.com.bancopichincha.mambu.interactions.servicios.mambu.CallService;
import co.com.bancopichincha.mambu.models.create.CreateCustomer;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

public class CreateNewCustomer implements Task {

    private final CreateCustomer newCustomerInfo;
    private final String resource;
    private final Map<String, String> headers;

    public CreateNewCustomer(CreateCustomer newCustomerInfo, String resource, Map<String, String> headers) {
        this.newCustomerInfo = newCustomerInfo;
        this.resource = resource;
        this.headers = headers;
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restPost(resource, newCustomerInfo, headers)
        );
    }


    public static CreateNewCustomer callApi(CreateCustomer newCustomerInfo, String resource, Map<String, String> headers) {
        return Tasks.instrumented(CreateNewCustomer.class, newCustomerInfo, resource, headers);
    }
}

