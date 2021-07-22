Feature: User Login Feature

  Scenario Outline: Login with valid user details
    Given Application Login page is displayed
    When You login with the valid user <email> and valid password <password>
    Then User is logged-in successfully
    And Logged-in user name is displayed on Home Page

    Examples:
      | email            | password |
      | test1@dummy.xyza | password |