Feature: Read a TODO
  Scenario: Read the content of an existing TODO
    Given An existing TODO with content "A CONTENT"
    When I try to get it
    Then I can read its content

  Scenario: Error when trying to read a non existing TODO
    When I try to get a non existing TODO
    Then I get an error telling that the TODO was not found
