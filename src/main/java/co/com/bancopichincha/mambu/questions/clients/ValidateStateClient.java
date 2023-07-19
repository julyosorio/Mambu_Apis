package co.com.bancopichincha.mambu.questions.clients;


import co.com.bancopichincha.mambu.models.search.SearchInformationResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;


public class ValidateStateClient implements Question<Boolean> {

    private final String id;
    private final  String state;


    public static ValidateStateClient verifyWith(String id, String state) {
		 return new ValidateStateClient(id, state);
	 }

    public ValidateStateClient(String id, String state){
        this.id = id;
        this.state = state;


    }




    @SneakyThrows
    @Override
    public Boolean answeredBy(Actor actor) {

        ObjectMapper mapper = new ObjectMapper();
        String response = SerenityRest.lastResponse().asString();
        List<SearchInformationResponse> myObjects = mapper.readValue(response, new TypeReference<List<SearchInformationResponse>>(){});

                actor.attemptsTo(
                        Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200),
                        Ensure.that((myObjects.get(0).getState())).isEqualTo(state),
                        Ensure.that((myObjects.get(0).getId())).isEqualTo(id)
        );
        return true;
    }
}

