Feature: EmployeeController API test
  Verify different operations using REST-assured

  Scenario: Test GET '/employees' endpoint
    Given I get the list of employees
    Then I check the employee id and name with id 1 and name "Ivan Aksionau"

  Scenario: Test PUT '/employee/{id}' endpoint
    Given I update the employee by id 2
      | id | name     | email     | phone  | address.street  | address.city | address.country |
      | 2  | some new | some mail | 567657 | some new street | new city     | new country     |
    Then I check the employee exists
      | id | name     | email     | phone  | address.street  | address.city | address.country |
      | 2  | some new | some mail | 567657 | some new street | new city     | new country     |

  Scenario: Test POST '/employee' endpoint
    Given I add new employee
      | id | name     | email     | phone  | address.street  | address.city | address.country |
      | 3  | some new | some mail | 567657 | some new street | new city     | new country     |
    Then I check the employee exists
      | id | name     | email     | phone  | address.street  | address.city | address.country |
      | 3  | some new | some mail | 567657 | some new street | new city     | new country     |