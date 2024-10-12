Feature: User Login

  @Login @Positive @Web
  Scenario: Successful User Login with Valid Credentials
    Given the user is on the landing page
    When the user clicks the Login or Signup button
    Then the user is redirected to the login page
    When the user enters a valid email "ariestest@gmail.com" and a valid password "ariestest123" in the login form
    And the user submits the form by clicking the Login button
    Then the user is redirected to the home page, with profile name is "Aries Eko Prasetyo"

  @Login @Negative @Web
  Scenario: Failed User Login with Empty Data
    Given the user is on the landing page
    When the user clicks the Login or Signup button
    Then the user is redirected to the login page
    When the user enters a valid email "" and a valid password "" in the login form
    And the user submits the form by clicking the Login button
    Then the user receives an error message


  @Login @Negative @Web
  Scenario: Failed User Login with Empty Password
    Given the user is on the landing page
    When the user clicks the Login or Signup button
    Then the user is redirected to the login page
    When the user enters a valid email "ariestest@gmail.com" and a valid password "" in the login form
    And the user submits the form by clicking the Login button
    Then the user receives an error message

  @Login @Negative @Web
  Scenario: Failed User Login with Empty Email
    Given the user is on the landing page
    When the user clicks the Login or Signup button
    Then the user is redirected to the login page
    When the user enters a valid email "" and a valid password "ariestest123" in the login form
    And the user submits the form by clicking the Login button
    Then the user receives an error message

    @Login @Negative @Web
    Scenario: Failed User Login with Invalid Credential
      Given the user is on the landing page
      When the user clicks the Login or Signup button
      Then the user is redirected to the login page
      When the user enters a valid email "ariestest@gmail.com" and a valid password "aries123" in the login form
      And the user submits the form by clicking the Login button
      Then the error message shows "Your email or password is incorrect!"


