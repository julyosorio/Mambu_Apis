package co.com.bancopichincha.mambu.questions.loans;


import co.com.bancopichincha.mambu.models.loan.ResponseItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;

public class ValidateLoanAmount implements Question<Boolean> {
     private final String loanAmount;

     public static ValidateLoanAmount validateLoanAmount (String loanAmount){
         return new ValidateLoanAmount(loanAmount);
     }

    public ValidateLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }


    @SneakyThrows
    @Override
    public Boolean answeredBy(Actor actor) {
        ObjectMapper mapper = new ObjectMapper();
        String response = SerenityRest.lastResponse().asString();
        List<ResponseItem> myObjects = mapper.readValue(response, new TypeReference<List<ResponseItem>>(){});

        actor.attemptsTo(
                Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(SC_OK),
                Ensure.that(myObjects.get(0).getLoanAmount()).isGreaterThanOrEqualTo(Double.parseDouble(this.loanAmount))

        );
        return true;
    }
}
