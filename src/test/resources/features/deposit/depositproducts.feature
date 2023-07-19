Feature: Deposit products

Business Need: As a mambu user, I need to see the deposit products that exist in mambu.

  Background:
    Given "Mambu user" requires the use of Mambu API v2.

  @DepositProducts
  Scenario Outline: View the list of existing deposit products
    When  "Mambu user" makes the call to the api to list the existing deposit products in mambu
    Then the system returns the list of existing deposit products in mambu "<List_Of_Deposit_Product>"
    Examples:
      | List_Of_Deposit_Product                                                                                   |
      | WalletColombiaCTE;CDTColombia;WalletColombiaAHO;WalletEjemplo;CTE_Sofka;Product Prueba |
