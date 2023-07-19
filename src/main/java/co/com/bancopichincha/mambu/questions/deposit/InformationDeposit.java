package co.com.bancopichincha.mambu.questions.deposit;


import co.com.bancopichincha.mambu.models.depositosdeproductos.ResponseDeposit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

public class InformationDeposit implements Question<Boolean> {
    private final String List_Of_Deposit_Product;


    public InformationDeposit(String List_Of_Deposit_Product){
        this.List_Of_Deposit_Product = List_Of_Deposit_Product;

    }
    @SneakyThrows
    @Override
    public Boolean answeredBy(Actor actor) {

        ObjectMapper mapper = new ObjectMapper();
        String response = SerenityRest.lastResponse().asString();
        List<ResponseDeposit> myObjects = mapper.readValue(response, new TypeReference<>() {});

		 StringBuilder aux = new StringBuilder();
		 for (ResponseDeposit responseDeposit: myObjects) {
			 aux.append(responseDeposit.getName()).append(";");
		 }
		 String result = aux.toString();

		 actor.attemptsTo(
				 Ensure.that(result).isEqualTo(List_Of_Deposit_Product + ";"));

        return true;
    }

    public static InformationDeposit verifyWith (String List_Of_Deposit_Product){
        return  new InformationDeposit(List_Of_Deposit_Product);
    }

}
