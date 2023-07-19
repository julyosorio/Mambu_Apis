Feature: clients update

Business Need: As a mambu user, I need to update the general information of an existing customer in mambu.

  Background:
    Given "Mambu user" requires the use of Mambu API v2.

  @ClientsUpdate
  Scenario: Client Update Successful
    When "Mambu user" makes the call to the request for updating clients
    Then The system should then get a 200 response (Client updated).