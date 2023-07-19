package co.com.bancopichincha.mambu.tasks.clients;

import co.com.bancopichincha.mambu.interactions.servicios.mambu.CallService;
import co.com.bancopichincha.mambu.models.search.DataFilter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


import java.util.Map;

public class SearchCustomerById implements Task {

    private final  Map<String, String> headers ;
    private final DataFilter body;
    private final  String resource;

    public SearchCustomerById(DataFilter body, String resource, Map<String,String> headers) {
        this.body= body;
        this.resource = resource;
        this.headers = headers;
    }

    public static SearchCustomerById call(DataFilter body, String resource, Map<String, String> headers){
        return new SearchCustomerById(body, resource, headers);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restPost(resource,body,headers)
        );
    }
    }

