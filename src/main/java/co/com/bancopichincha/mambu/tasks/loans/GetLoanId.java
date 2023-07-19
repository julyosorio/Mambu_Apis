package co.com.bancopichincha.mambu.tasks.loans;

import co.com.bancopichincha.mambu.interactions.servicios.mambu.CallService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class
GetLoanId implements Task {

    private final String resource;
    private final String id;
    private final Map<String,String> header;



    public GetLoanId(String resource, String id, Map<String, String> header ){
        this.resource = resource;
        this.id = id;
        this.header = header;
    }

    public static  GetLoanId call (String resource, String id, Map<String, String> header){
        return new GetLoanId(resource, id, header);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                CallService.restGet(String.format(resource,id),header)
        );
    }
}
