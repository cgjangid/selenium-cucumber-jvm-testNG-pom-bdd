Feature: User Registration Feature
  Background: When a user clicks on create account button on login page, registration page is displayed
    Given Application Login page is displayed
    When You click on create account button
    Then User Registration page is displayed


  Scenario Outline: If valid user details are provided on User Registration Page and clicked on Register Account button, user is registered successfully
    When Valid <firstName>, <lastName>, <emailId> and <userPassword> details are provided on Registration Page and clicked on Register Account Button
    Then User is registered successfully

    Examples:
      | firstName | lastName | emailId | userPassword |
#      | user1     | last1    | test1@dummy.xyza | password |
#      | user2     | last2    | test2@dummy.xyza | password |
#      | user3     | last2    | test2@dummy.xyza | password |
#      | user4     | last2    | test2@dummy.xyza | password |
#      | user5     | last1    | test1@dummy.xyza | password |
#      | user6     | last2    | test2@dummy.xyza | password |
#      | user11     | last1    | test1@dummy.xyza | password |
#      | user22     | last2    | test2@dummy.xyza | password |
      | user33     | last2    | test2@dummy.xyza | password |
#      | user44     | last2    | test2@dummy.xyza | password2 |
      | user55     | last1    | test1@dummy.xyza | password |
      | user66     | last2    | test2@dummy.xyza | password |
