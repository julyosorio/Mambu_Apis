package co.com.bancopichincha.mambu.stepdefinitions.loans;


import co.com.bancopichincha.mambu.models.loantransaction.BodySearchLoan;
import co.com.bancopichincha.mambu.questions.loans.ValidateLoanState;
import co.com.bancopichincha.mambu.tasks.loans.PostSearchLoanId;
import co.com.bancopichincha.mambu.utils.DataManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;


import static co.com.bancopichincha.mambu.stepdefinitions.HooksAPI.environmentVariables;
import static co.com.bancopichincha.mambu.utils.Constants.getHeader;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
public class StepDefinitionLoanState {



   @When("^I perform a search by loanAccountId (.+)$")
   public void i_perform_a_search_by_loan_account_id_id(String id) {

       BodySearchLoan body = DataManager.bodySearchLoanId(id);
       OnStage.theActorInTheSpotlight().attemptsTo(
               PostSearchLoanId.call(environmentVariables.getProperty("api.searchLoan"), body, getHeader()));

   }

   @Then("^the accountState of the account must be (.+)$")
   public void the_account_state_of_the_account_must_be_state(String state) {
       OnStage.theActorInTheSpotlight().should(
               seeThat(ValidateLoanState.validateLoanState(state), is(true))
       );
   }
}
