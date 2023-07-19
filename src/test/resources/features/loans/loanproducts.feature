Feature: Loan products

Business Need: As a mambu user, I need to see what loan products are available on mambu.

  Background:
    Given "Mambu user" requires the use of Mambu API v2.


  @loanProducts
  Scenario Outline: View the list of existing loan products
    When "Mambu user" calls the api to list the existing loan products on mambu
    Then the system returns the list of existing loan products in mambu "<List_Of_Loan_Product>"
    Examples:
      | List_Of_Loan_Product    |
      | Loan Product Prueba;Helping Hand Loan;MicroCreditoColombia  |




