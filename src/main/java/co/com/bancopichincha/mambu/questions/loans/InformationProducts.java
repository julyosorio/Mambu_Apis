package co.com.bancopichincha.mambu.questions.loans;

import co.com.bancopichincha.mambu.models.ResponseProduct;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

public class InformationProducts implements Question<Boolean> {

    private final String List_Of_Loan_Product;

    public static InformationProducts verifyWith(String name) {
        return new InformationProducts(name);
    }

    public InformationProducts(String List_Of_Loan_Product) {
        this.List_Of_Loan_Product = List_Of_Loan_Product;

    }

    @SneakyThrows
    @Override
    public Boolean answeredBy(Actor actor) {

        ObjectMapper mapper = new ObjectMapper();
        String response = SerenityRest.lastResponse().asString();
        List<ResponseProduct> myObjects = mapper.readValue(response, new TypeReference<>() {
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (ResponseProduct responseProduct : myObjects) {
            stringBuilder.append(responseProduct.getName()).append(";");
        }
        String result = stringBuilder.toString();
        actor.attemptsTo(
                Ensure.that(result).isEqualTo(List_Of_Loan_Product + ";")
        );
        return true;
    }
}
