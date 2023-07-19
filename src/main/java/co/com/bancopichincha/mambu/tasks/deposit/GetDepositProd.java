package co.com.bancopichincha.mambu.tasks.deposit;

import co.com.bancopichincha.mambu.interactions.servicios.mambu.CallService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class GetDepositProd implements Task {

    private final String resource;

    private final Map<String, String> headers;


    public  GetDepositProd(String resource,  Map<String,String> headers){
        this.resource = resource;
        this.headers = headers;

    }


    public static GetDepositProd call ( String resource, Map<String,String> headers){
        return new GetDepositProd(resource, headers);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CallService.restGet(resource,headers)
        );

    }
}
