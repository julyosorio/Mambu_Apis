package co.com.bancopichincha.mambu.stepdefinitions.deposit;

import co.com.bancopichincha.mambu.questions.deposit.InformationDeposit;
import co.com.bancopichincha.mambu.tasks.deposit.GetDepositProd;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.bancopichincha.mambu.stepdefinitions.HooksAPI.environmentVariables;
import static co.com.bancopichincha.mambu.utils.Constants.getHeader;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class DepositProductsStep {

    @When("{string} makes the call to the api to list the existing deposit products in mambu")
    public void makesTheCallToTheApiToListTheExistingDepositProductsInMambu(String user) {
        OnStage.theActorCalled(user).attemptsTo(
                GetDepositProd.call(environmentVariables.getProperty("api.DepositProducts"),getHeader())
        );
    }

    @Then("the system returns the list of existing deposit products in mambu {string}")
    public void theSystemReturnsTheListOfExistingDepositProductsInMambu(String List_Of_Deposit_Product ) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        InformationDeposit.verifyWith(List_Of_Deposit_Product),is(true)
                )
        );
    }

}
