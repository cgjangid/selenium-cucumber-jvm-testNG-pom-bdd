Feature: User Registration Feature

  Background: When a user clicks on create account button on login page, registration page is displayed
    Given Application Login page is displayed
    When You click on create account button
    Then User Registration page is displayed

  Scenario Outline: If valid user details are provided on User Registration Page and clicked on Register Account button, user is registered successfully
    When User details of <firstName>, <lastName>, <emailId> and <userPassword> are provided on Registration Page and clicked on Register Account Button
    Then User is registered successfully

    Examples:
      | firstName | lastName | emailId          | userPassword |
#      | user1     | last1    | test1@dummy.xyza | password |
#      | user2     | last2    | test2@dummy.xyza | password |
#      | user3     | last2    | test2@dummy.xyza | password |
#      | user4     | last2    | test2@dummy.xyza | password |
#      | userINV   | last2    | test2@dummy.xyza | passwordINV  |
      | user5     | last1    | test1@dummy.xyza | password     |

  Scenario Outline: If 'INVALID' user details are provided on User Registration Page and clicked on Register Account button, user is NOT registered
    When User details of <firstName>, <lastName>, <emailId> and <userPassword> are provided on Registration Page and clicked on Register Account Button
    Then User Registration is failed

    Examples:
      | firstName | lastName | emailId          | userPassword |
      | userINV   | last2    | test2@dummy.xyza | passwordINV  |