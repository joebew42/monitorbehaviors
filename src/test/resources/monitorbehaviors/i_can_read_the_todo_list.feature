Feature: Read the TODO list
  Scenario: Read the list of all the available TODOs
    Given An existing TODO with content "A CONTENT"
    And An existing TODO with content "ANOTHER CONTENT"
    When I access the list of TODOs
    Then I can see all the TODOs
