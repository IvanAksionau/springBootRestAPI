Feature:
  Verify different operations using REST-assured

    Scenario: Verify
      Given I get the list of employees
      Then I check the user id and name with id 1 and name "Ivan Aksionau"