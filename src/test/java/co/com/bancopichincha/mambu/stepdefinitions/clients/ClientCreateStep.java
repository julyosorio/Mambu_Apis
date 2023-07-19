package co.com.bancopichincha.mambu.stepdefinitions.clients;

import co.com.bancopichincha.mambu.models.create.CreateCustomer;
import co.com.bancopichincha.mambu.questions.clients.ValidateClientCreate;
import co.com.bancopichincha.mambu.tasks.clients.CreateNewCustomer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.bancopichincha.mambu.stepdefinitions.HooksAPI.environmentVariables;
import static co.com.bancopichincha.mambu.utils.Constants.getHeader;
import static co.com.bancopichincha.mambu.utils.DataManager.loadBodyCreateUser;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class ClientCreateStep {
    CreateCustomer newCustomerInfo;

    @When("{string} makes the call to the request for the creation of a new customer")
    public void makesTheCallToTheRequestForTheCreationOfANewCustomer(String user) {
        newCustomerInfo = loadBodyCreateUser();
        OnStage.theActorCalled(user).attemptsTo(
                CreateNewCustomer.callApi(newCustomerInfo, environmentVariables.getProperty("api.createCLient"), getHeader())
        );
    }

    @Then("The system should then get a {int} response \\(Client created).")
    public void theSystemShouldThenGetAResponseClientCreated(int status) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateClientCreate.verifyWith(
                        newCustomerInfo.getPersonalizados().getExternalID(),
                        newCustomerInfo.getState().contains("INACTIVE") ? "INACTIVE" : "PENDING_APPROVAL",
                        status)));
    }

}
