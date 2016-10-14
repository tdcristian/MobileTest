Feature: Calculator operation check

  Scenario Outline:

    Given I select the correct capabilities

    And Open the calculator

    When I add <a> and <b>

    Then the result is <c>

    And close the calculator

    Examples: Single digits
      | a | b | c |
      | 4 | 5 | 9 |
      | 5 | 4 | 9 |
      | 2 | 3 | 5 |
