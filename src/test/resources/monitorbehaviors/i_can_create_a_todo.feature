Feature: I can create a TODO
  Scenario: Creating a TODO
    When I create a TODO
    Then I should receive its identifier
