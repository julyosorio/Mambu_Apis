Feature: validate loan

  Background: validate loan

    Given I need to obtain the information of a loan
    When I do a search by id

  @validateLoan1
  Scenario: validate associated product
    Then in the response the loanName field must not be empty

  @validateLoan
  Scenario: validate loan amount
    Then the value of the loanAmount field must be non zero

  @validateLoan
  Scenario: validate interest rate
    Then I have interestRate is non-zero

  @validateLoan
  Scenario: validate number of weeks for each payment
    Then the repaymentPeriodCount must be equal to or greater than 3

  @validateLoan
  Scenario: validate number of quotas
    Then the repaymentInstallments greater than 1

  @validateLoan
  Scenario: validate penalty rate
    Then the value of the penaltyRate field is greater than 1

  @validateLoan
  Scenario: validate tolerance period
    Then the value of the tolerancePeriod field is greater than 1






