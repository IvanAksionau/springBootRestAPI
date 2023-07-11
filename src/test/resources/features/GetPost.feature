Feature:
  Verify different operations using REST-assured

    Scenario: Verify
      Given I get the list of employees
      Then I check the user id is 1 and name is "name"