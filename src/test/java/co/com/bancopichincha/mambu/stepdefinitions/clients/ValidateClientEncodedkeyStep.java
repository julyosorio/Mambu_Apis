package co.com.bancopichincha.mambu.stepdefinitions.clients;

import co.com.bancopichincha.mambu.models.search.DataFilter;
import co.com.bancopichincha.mambu.questions.clients.ValidateClientEncodedkey;
import co.com.bancopichincha.mambu.tasks.clients.SearchCustomerById;
import co.com.bancopichincha.mambu.utils.DataManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.bancopichincha.mambu.stepdefinitions.HooksAPI.environmentVariables;
import static co.com.bancopichincha.mambu.utils.Constants.getHeader;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class ValidateClientEncodedkeyStep {


    private DataFilter dataFilter;


    @When("I perform a search by encodedKey {string}")
    public void i_perform_a_search_by_encoded_key(String encodedKey) {
        dataFilter = DataManager.loadFilterSearchBody("encodedKey", encodedKey);
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchCustomerById.call(dataFilter, environmentVariables.getProperty("api.ValidateClients"), getHeader())
        );
    }

    @Then("In the response the state parameter must be {string}")
    public void in_the_response_the_state_parameter_must_be(String state) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ValidateClientEncodedkey.verifyWith(dataFilter.getFilterCriteria().get(0).getValue(), state), is(true)
                )
        );
    }
}

