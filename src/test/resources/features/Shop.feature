Feature: Shop

  @Shop @Postive @Web
  Scenario: Add product to cart & checkout
    Given the user is on the landing page
    When the user clicks the Login or Signup button
    Then the user is redirected to the login page
    When the user enters a valid email "ariestest@gmail.com" and a valid password "ariestest123" in the login form
    And the user submits the form by clicking the Login button
    Then the user is redirected to the home page, with profile name is "Aries Eko Prasetyo"
    When the user clicks MEN category and choses Tshirts
    Then the user is redirected to the product page
    When the user add "3" quantity to the product
    And the user click the Add to cart button
    Then the user click the View cart button
    And Total price = price multiplied by quantity
    