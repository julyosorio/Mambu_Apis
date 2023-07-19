package co.com.bancopichincha.mambu.stepdefinitions.loans;


import co.com.bancopichincha.mambu.questions.loans.InformationProducts;
import co.com.bancopichincha.mambu.tasks.loans.GetLoanProd;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.bancopichincha.mambu.stepdefinitions.HooksAPI.environmentVariables;
import static co.com.bancopichincha.mambu.utils.Constants.getHeader;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class LoanProductsStep {

    @When("{string} calls the api to list the existing loan products on mambu")
    public void callsTheApiToListTheExistingLoanProductsOnMambu(String user) {
       OnStage.theActorCalled(user).attemptsTo(
               GetLoanProd.call(environmentVariables.getProperty("api.LoanProducts"),getHeader())
       );
   }
    @Then("the system returns the list of existing loan products in mambu {string}")
    public void theSystemReturnsTheListOfExistingLoanProductsInMambu(String name) {
       OnStage.theActorInTheSpotlight().should(
               seeThat(
                       InformationProducts.verifyWith(name), is(true)
               )
       );
   }

}
