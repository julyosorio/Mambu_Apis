package co.com.bancopichincha.mambu.questions.loans;



import co.com.bancopichincha.mambu.models.loan.ResponseItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.apache.http.HttpStatus;

import java.util.List;

public class ValidateLoanState implements Question<Boolean> {

    public final String state;

    public static ValidateLoanState validateLoanState(String state) {
        return new ValidateLoanState(state);
    }

    public ValidateLoanState(String state) {
        this.state = state;
    }


    @SneakyThrows
    @Override
    public Boolean answeredBy(Actor actor) {
        ObjectMapper mapper = new ObjectMapper();
        String response = SerenityRest.lastResponse().asString();
        List<ResponseItem> myObjects = mapper.readValue(response, new TypeReference<List<ResponseItem>>(){});

        actor.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(HttpStatus.SC_OK),
                Ensure.that(myObjects.get(0).getAccountState()).isEqualTo(state)
        );
        return true;
    }
}
