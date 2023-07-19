Feature: Validate loan transaction

Business Need: As a user I need retrieve loan transaction usign transactions search API

  @LoanTransaction
  Scenario Outline: loan transaction
    Given I need to obtain the information of a loan
    When the id is sent to the resource transactions search whit loanAccountId <id>
    Then totalBalance must be equal to the subtraction of principalBalance with amount
    Examples:

      | id      |
      | YUTY352 |
