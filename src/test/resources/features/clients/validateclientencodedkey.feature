Feature: Validate the status of a mambu client with encodedKey

  Background:
    Given "Mambu user" requires the use of Mambu API v2.

  @ValidateClientStateEncodedKey
  Scenario: validate client state with encodedKey

    When I perform a search by encodedKey
    Then In the response the state parameter must be state

