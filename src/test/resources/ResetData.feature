Feature: Clear Data

    @ClearData
    Scenario: Clear User Data
        Given the user is on the landing page
        When the user clicks the Login or Signup button
        Then the user is redirected to the login page
        When the user enters a valid email "ariestest@gmail.com" and a valid password "ariestest123" in the login form
        And the user submits the form by clicking the Login button
        And the user is redirected to the home page, with profile name is "Aries Eko Prasetyo"
        Then the user clicks the Delete Account button