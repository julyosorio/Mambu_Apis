package co.com.bancopichincha.mambu.stepdefinitions.loans;

import co.com.bancopichincha.mambu.questions.loans.ValidateTransactionTotalBalance;
import co.com.bancopichincha.mambu.tasks.loans.GetAllLoanTransactionAccountId;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.bancopichincha.mambu.stepdefinitions.HooksAPI.environmentVariables;
import static co.com.bancopichincha.mambu.utils.Constants.getHeader;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class StepDefinitionLoanTransaction {


    @When("^the id is sent to the resource transactions search whit loanAccountId (.+)$")
    public void the_id_is_sent_to_the_resource_transactions_search(String accountId) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                GetAllLoanTransactionAccountId.call(environmentVariables.getProperty("api.allLoanTransaction"), accountId, getHeader())

        );
    }

    @Then("totalBalance must be equal to the subtraction of principalBalance with amount")
    public void total_balance_must_be_equal_to_the_subtraction_of_principal_balance_with_amount() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateTransactionTotalBalance.transactionTotalBalance(), is(true))
        );
    }
}
