package co.com.bancopichincha.mambu.stepdefinitions.clients;


import co.com.bancopichincha.mambu.models.update.ClientsUpdate;
import co.com.bancopichincha.mambu.questions.clients.InformationClients;
import co.com.bancopichincha.mambu.tasks.clients.UpdateCustomer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.bancopichincha.mambu.stepdefinitions.HooksAPI.environmentVariables;
import static co.com.bancopichincha.mambu.utils.Constants.getHeader;
import static co.com.bancopichincha.mambu.utils.DataManager.loadBodyUpdateUser;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ClientUpdateStep {

    ClientsUpdate clientsUpdateInfo;

    @When("{string} makes the call to the request for updating clients")
    public void makesTheCallToTheRequestForUpdatingClients(String user) {
        clientsUpdateInfo = loadBodyUpdateUser();
        OnStage.theActorCalled(user).attemptsTo(
                UpdateCustomer.callApi(clientsUpdateInfo, environmentVariables.getProperty("api.updateCLient"), getHeader())
        );
    }

    @Then("The system should then get a {int} response \\(Client updated).")
    public void theSystemShouldThenGetAResponseClientUpdated(int status) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(InformationClients.verifyWith(
                                clientsUpdateInfo.getId(),
                                clientsUpdateInfo.getEncodedKey(),
                                clientsUpdateInfo.getPersonalizados().getExternalID(), status),
                        is(true))
        );
    }

}
