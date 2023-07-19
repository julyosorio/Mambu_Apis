package co.com.bancopichincha.mambu.questions.clients;

import co.com.bancopichincha.mambu.models.create.CreateCustomer;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

public class ValidateClientCreate implements Question<Boolean> {

	private final String externalID;
	private final String state;
	private final int status;

	public static ValidateClientCreate verifyWith(String externalID, String state, int status ) {
		return new ValidateClientCreate(externalID, state, status);
	}

	public ValidateClientCreate(String externalID, String state, int status){
		this.externalID = externalID;
		this.state = state;
		this.status = status;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		CreateCustomer user = SerenityRest.lastResponse().as(CreateCustomer.class);
		actor.attemptsTo(
				Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(status),
				Ensure.that(user.getState()).isEqualTo(state),
				Ensure.that(user.getPersonalizados().getExternalID()).contains(externalID));
		return true;
	}
}
