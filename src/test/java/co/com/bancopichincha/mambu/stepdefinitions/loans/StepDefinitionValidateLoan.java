package co.com.bancopichincha.mambu.stepdefinitions.loans;
import co.com.bancopichincha.mambu.questions.loans.*;
import co.com.bancopichincha.mambu.tasks.loans.GetLoanId;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.bancopichincha.mambu.stepdefinitions.HooksAPI.environmentVariables;
import static co.com.bancopichincha.mambu.utils.Constants.getHeader;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class StepDefinitionValidateLoan {


 @When("I do a search by id")
 public void i_do_a_search_by_id() {
     OnStage.theActorInTheSpotlight().attemptsTo(
             GetLoanId.call(environmentVariables.getProperty("api.getLoanId"), "3761389350", getHeader()));

 }

 @Then("in the response the loanName field must not be empty")
 public void in_the_response_the_loan_name_field_must_not_be_empty() {
     OnStage.theActorInTheSpotlight().should(
             seeThat(ValidateLoanName.validateLoanName(), is(true))
     );
 }

 @Then("the value of the loanAmount field must be non zero")
 public void the_value_of_the_loan_amount_field_must_be_non_zero() {
     OnStage.theActorInTheSpotlight().should(
             seeThat(ValidateLoanAmount.validateLoanAmount("0"), is(true))
     );
 }

 @Then("I have interestRate is non-zero")
 public void i_have_interest_rate_is_non_zero() {
     OnStage.theActorInTheSpotlight().should(
             seeThat(ValidateInterestRate.validateInterestRate(0.0), is(true))
     );
 }

 @Then("the repaymentPeriodCount must be equal to or greater than {int}")
 public void the_repayment_period_count_must_be_equal_to_or_greater_than(Integer int1) {
     OnStage.theActorInTheSpotlight().should(
               seeThat(ValidateRepaymentPeriodCount.validateRepaymentPeriodCount(int1), is(true))
       );
   }

   @Then("the repaymentInstallments greater than {int}")
   public void the_repayment_installments_greater_than(Integer int1) {
       OnStage.theActorInTheSpotlight().should(
               seeThat(ValidateRepaymentInstallments.validateRepaymentInstallments(int1), is(true))
       );
   }

   @Then("the value of the penaltyRate field is greater than {int}")
   public void the_value_of_the_penalty_rate_field_is_greater_than(Integer int1) {
       OnStage.theActorInTheSpotlight().should(
               seeThat(ValidatePenaltyRate.validatePenaltyRate(int1), is(true))
       );
   }

   @Then("the value of the tolerancePeriod field is greater than {int}")
   public void the_value_of_the_tolerance_period_field_is_greater_than(Integer int1) {
       OnStage.theActorInTheSpotlight().should(
               seeThat(ValidateTolerancePeriod.validateTolerancePeriod(int1), is(true))
       );
   }
}
