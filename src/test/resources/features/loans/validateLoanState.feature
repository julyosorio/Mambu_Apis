Feature: Validate loan state

  @validateLoanState
  Scenario Outline: validate state loans
    Given I need to obtain the information of a loan
    When I perform a search by loanAccountId <id>
    Then the accountState of the account must be <state>

    Examples:

      | id      | state            |
      | XUGM060 | ACTIVE           |
      | TJJA752 | PENDING_APPROVAL |
      | TJJA752 | ARREARS_IN       |
      | GKIT919 | CLOSED           |
      | HFPG278 | RESCHEDULED      |
      | ZJFK867 | WRITTEN_OFF      |


