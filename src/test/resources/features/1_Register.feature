Feature: User Registration

  @Register @Positive @Web

  Scenario: Successful User Registration with Valid Credentials
    Given the user is on the landing page
    When the user clicks the Login or Signup button
    Then the user is redirected to the registration page
    When the user enters a valid name "Aries Eko Prasetyo" and a valid email "ariestest@gmail.com" in the registration form
    And the user submits the form by clicking the Signup button
    And enter account information "Mr" as a user title "ariestest123" as password "1" as day "April" as month "1993" as year
    And enter address information "Aries" as Firstname "Prasetyo" as Lastname "PT Lalu Lalang" as Company "1145 U.S. 491" as Address "United States" as Country "New York" as State "Gallup" as City "87301" as ZIP Code "087886674010" as Mobile
    Then the account is created successfully, and the user receives a confirmation message

  @Register @Negative @Web
  Scenario: Failed User SignUp with Empty Mandatory Data
    Given the user is on the landing page
    When the user clicks the Login or Signup button
    Then the user is redirected to the registration page
    When the user enters a valid name "" and a valid email "" in the registration form
    And the user submits the form by clicking the Signup button
    Then the user receives an error message

  @Register @Negative @Web
  Scenario: Failed User SignUp with Empty Mandatory Data on Account Information and Address Information
    Given the user is on the landing page
    When the user clicks the Login or Signup button
    Then the user is redirected to the registration page
    When the user enters a valid name "Aries Eko Prasetyo" and a valid email "ariestest123@gmail.com" in the registration form
    And the user submits the form by clicking the Signup button
    And enter account information "" as a user title "" as password "" as day "" as month "" as year
    And enter address information "" as Firstname "" as Lastname "" as Company "" as Address "" as Country "" as State "" as City "" as ZIP Code "" as Mobile
    Then the user receives an error message on form Account Information and Address Information

  @Register @Negative @Web
  Scenario: Failed User SignUp with Existing Email
    Given the user is on the landing page
    When the user clicks the Login or Signup button
    Then the user is redirected to the registration page
    When the user enters a valid name "Aries Eko Prasetyo" and a valid email "ariestest@gmail.com" in the registration form
    And the user submits the form by clicking the Signup button
    Then the user receives an error message "Email Address already exist!"