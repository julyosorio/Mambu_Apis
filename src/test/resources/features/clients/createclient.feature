Feature: Create client

Business Need: As a mambu user, I need to create a client in mambu.

  Background:
    Given "Mambu user" requires the use of Mambu API v2.

  @CreateClient
  Scenario: Successful Client Creation
    When "Mambu user" makes the call to the request for the creation of a new customer
    Then The system should then get a 201 response (Client created).