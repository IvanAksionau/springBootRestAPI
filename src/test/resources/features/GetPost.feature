Feature: EmployeeController API test
  Verify different operations using REST-assured

  Scenario: Test GET '/employees' endpoint
    Given I get the list of employees
    Then I check the employee with name "Ivan" exists

  Scenario: Test POST '/employee' endpoint
    Given I add new employee
      | name     | email     | phone  | address.street  | address.city | address.country |
      | some new | some mail | 567657 | some new street | new city     | new country     |
    Then I check the employee exists
      | name     | email     | phone  | address.street  | address.city | address.country |
      | some new | some mail | 567657 | some new street | new city     | new country     |

#  Scenario: Test PUT '/employee/{id}' endpoint
#    Given I update the employee by id 2
#      | id | name     | email     | phone  | address.street  | address.city | address.country |
#      | 2  | some new | some mail | 567657 | some new street | new city     | new country     |
#    Then I check the employee exists
#      | id | name     | email     | phone  | address.street  | address.city | address.country |
#      | 2  | some new | some mail | 567657 | some new street | new city     | new country     |