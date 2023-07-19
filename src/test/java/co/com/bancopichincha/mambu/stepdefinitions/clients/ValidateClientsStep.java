package co.com.bancopichincha.mambu.stepdefinitions.clients;

import co.com.bancopichincha.mambu.models.search.DataFilter;
import co.com.bancopichincha.mambu.questions.clients.ValidateStateClient;
import co.com.bancopichincha.mambu.tasks.clients.SearchCustomerById;
import co.com.bancopichincha.mambu.utils.DataManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.bancopichincha.mambu.stepdefinitions.HooksAPI.environmentVariables;
import static co.com.bancopichincha.mambu.utils.Constants.getHeader;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ValidateClientsStep {

    private DataFilter body;

    @When("I perform a search by id {string}")
    public void iPerformASearchById(String id) {
        body = DataManager.loadFilterSearchBody("id", id);
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchCustomerById.call(body, environmentVariables.getProperty("api.ValidateClients"), getHeader())
        );
    }

    @Then("in the response the state parameter must be {string}")
    public void inTheResponseTheStateParameterMustBe(String state) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ValidateStateClient.verifyWith(body.getFilterCriteria().get(0).getValue(), state), is(true)
                )
        );
    }
}
