package co.com.bancopichincha.mambu.questions.clients;

import co.com.bancopichincha.mambu.models.update.ClientsUpdate;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

public class InformationClients implements Question<Boolean> {


    private final String id;
    private final String enconkey;
    private final String externalid;
	 private final int status;


    public static InformationClients verifyWith(String id, String enconkey, String externalid, int status) {
		 return new InformationClients(id, enconkey, externalid, status);
	 }

    public InformationClients(String id, String enconkey, String externalid, int status){
        this.id = id;
        this.enconkey = enconkey;
        this.externalid= externalid;
		  this.status = status;
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
				    Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(status),
                Ensure.that(SerenityRest.lastResponse().as(ClientsUpdate.class).getId()).contains(id),
                Ensure.that(SerenityRest.lastResponse().as(ClientsUpdate.class).getEncodedKey()).contains(enconkey),
                Ensure.that(SerenityRest.lastResponse().as(ClientsUpdate.class).getPersonalizados().getExternalID()).contains(externalid)
        );
        return true;
    }
}
