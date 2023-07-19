package co.com.bancopichincha.mambu.tasks.loans;

import co.com.bancopichincha.mambu.interactions.servicios.mambu.CallService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

public class GetAllLoanTransactionAccountId implements Task {

    private final String resource;
    private final String accountId;
    private final Map<String, String> header;

    public GetAllLoanTransactionAccountId(String resource, String accountId,Map<String, String> header) {
        this.resource = resource;
        this.accountId = accountId;
        this.header = header;
    }

    public static GetAllLoanTransactionAccountId call(String resource, String accountId, Map<String, String> header) {
        return new GetAllLoanTransactionAccountId(resource, accountId, header);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
      actor.attemptsTo(
              CallService.restGet(String.format(resource,accountId),header)
      );
    }
}
