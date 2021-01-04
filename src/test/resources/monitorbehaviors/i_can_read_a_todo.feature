Feature: Read a TODO
  Scenario: Read the content of an existing TODO
    Given An existing TODO with content "A CONTENT"
    When I try to get it
    Then I can read its content
