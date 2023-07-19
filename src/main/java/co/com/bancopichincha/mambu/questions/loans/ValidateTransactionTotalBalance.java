package co.com.bancopichincha.mambu.questions.loans;


import co.com.bancopichincha.mambu.models.loantransaction.ResponseItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.apache.http.HttpStatus;

import java.util.List;

public class ValidateTransactionTotalBalance implements Question<Boolean> {

    public static ValidateTransactionTotalBalance transactionTotalBalance() {
        return new ValidateTransactionTotalBalance();
    }

    @SneakyThrows
    @Override
    public Boolean answeredBy(Actor actor) {


        ObjectMapper mapper = new ObjectMapper();
        String response = SerenityRest.lastResponse().asString();
        List<ResponseItem> myObjects = mapper.readValue(response, new TypeReference<>() {
		  });

        actor.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(HttpStatus.SC_OK),
                Ensure.that(myObjects.get(1).getAccountBalances().getTotalBalance() -
                        myObjects.get(0).getAmount()).isEqualTo(
                        myObjects.get(0).getAccountBalances().getTotalBalance() )

        );

        return true;
    }
}
