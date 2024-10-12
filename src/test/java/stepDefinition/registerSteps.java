package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.registerPage;
import org.openqa.selenium.WebDriver;

public class registerSteps {
   final private WebDriver driver;
   public registerSteps(){
       super();
       this.driver = Hooks.webDriver;
   }
   @Given("the user is on the landing page")
   public void theUserIsOnTheLandingPage() {
       registerPage page = new registerPage(driver);
       Assert.assertTrue(page.isLogoDisplayed());
   }

   @When("the user clicks the Login or Signup button")
   public void theUserClicksTheSignupLoginButton() {
       registerPage page = new registerPage(driver);
       page.clickSignupLoginButtonMenu();
   }

   @Then("the user is redirected to the registration page")
   public void theUserIsRedirectedToTheRegistrationPage() {
       registerPage page = new registerPage(driver);
       Assert.assertTrue(page.isTitleSignupDisplayed());
   }

   @When("the user enters a valid name {string} and a valid email {string} in the registration form")
   public void theUserEntersNameAndEmail(String name, String email) {
       registerPage page = new registerPage(driver);
       page.nameFieldSet(name);
       page.emailFieldSet(email);
   }

   @And("the user submits the form by clicking the Signup button")
   public void theUserSubmitsTheFormByClickingTheSignupButton() {
       registerPage page = new registerPage(driver);
       page.clickSignupButton();
   }

   @And("enter account information {string} as a user title {string} as password {string} as day {string} as month {string} as year")
   public void enterAccountInformation(String option, String password, String day, String month, String year) {
       registerPage page = new registerPage(driver);
       page.accountInformation(option, password, day, month, year);
   }

   @And("enter address information {string} as Firstname {string} as Lastname {string} as Company {string} as Address {string} as Country {string} as State {string} as City {string} as ZIP Code {string} as Mobile")
   public void enterAddressInformation(String firstname, String lastname, String company, String address, String country, String state, String city, String zipcode, String mobile) {
       registerPage page = new registerPage(driver);
     page.addressInformation(firstname, lastname, company, address, country, state, city, zipcode, mobile);
     page.clickCreateAccountButton();
   }

   @Then("the account is created successfully, and the user receives a confirmation message")
   public void theAccountIsCreatedSuccessfully() {
       registerPage page = new registerPage(driver);
       Assert.assertTrue(page.isAccountCreatedTitleDisplayed());
   }

   @Then("the user receives an error message")
   public void theUserReceivesAnErrorMessage() {
       registerPage page = new registerPage(driver);
       Assert.assertEquals("Please fill out this field.",page.isErrorMessageDisplayed());
   }

   @Then("the user receives an error message on form Account Information and Address Information")
   public void theUserReceivesAnErrorMessageOnFormAccountInformationAndAddressInformation() {
       registerPage page = new registerPage(driver);
       Assert.assertEquals("Please fill out this field.",page.isErrorMessageDisplayedFormAccountAddressInformation());
   }

   @Then("the user receives an error message {string}")
   public void theUserReceivesAnErrorMessage(String message) {
       registerPage page = new registerPage(driver);
       Assert.assertEquals(message,page.isErrorMessageDisplayedEmailAlreadyExist());
   }

}
