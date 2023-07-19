package co.com.bancopichincha.mambu.tasks.clients;

import co.com.bancopichincha.mambu.interactions.servicios.mambu.CallService;
import co.com.bancopichincha.mambu.models.update.ClientsUpdate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


import java.util.Map;

public class UpdateCustomer implements Task {

    private final ClientsUpdate clientsUpdateInfo;
    private final  String resource;
    private final  Map<String, String> headers ;

    public UpdateCustomer(ClientsUpdate clientsUpdateInfo, String resource, Map<String,String> headers) {
        this.clientsUpdateInfo = clientsUpdateInfo;
        this.resource = resource;
        this.headers = headers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(CallService.restPutWithHeaders(String.format(resource, clientsUpdateInfo.getId()),clientsUpdateInfo, headers));

    }
    public static UpdateCustomer callApi(ClientsUpdate clientsUpdateInfo, String resource, Map<String, String> headers){
        return Tasks.instrumented(UpdateCustomer.class,clientsUpdateInfo, resource, headers);
    }
}
