Feature: Validate clients


  Background:
    Given "Mambu user" requires the use of Mambu API v2.


  @ValidateClients
  Scenario Outline: validate client state with id

    When I perform a search by id <id>
    Then in the response the state parameter must be "<state>"

    Examples:
      | id          | state            |
      | "946299487" | ACTIVE           |
      | "938097657" | INACTIVE         |
      | "256973199" | PENDING_APPROVAL |
      | "946639189" | BLACKLISTED      |
