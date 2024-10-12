package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.loginPage;

public class loginSteps {
    final private WebDriver driver;
    public loginSteps() {
        super();
        this.driver = Hooks.webDriver;
    }
    @Then("the user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        loginPage page = new loginPage(driver);
        Assert.assertTrue(page.isTitleLoginDisplayed());
    }

    @When("the user enters a valid email {string} and a valid password {string} in the login form")
    public void theUserEntersEmailAndPassword(String email, String password) {
        loginPage page = new loginPage(driver);
        page.emailFieldSet(email);
        page.passwordFieldSet(password);
    }

    @And("the user submits the form by clicking the Login button")
    public void theUserSubmitsTheFormByClickingTheLoginButton() {
        loginPage page = new loginPage(driver);
        page.clickLoginButton();
    }

    @Then("the user is redirected to the home page, with profile name is {string}")
    public void theUserIsRedirectedToTheHomePage(String name) {
        loginPage page = new loginPage(driver);
        Assert.assertEquals(name, page.getProfileName());
    }

    @Then("the error message shows {string}")
    public void theErrorMessageShows(String message) {
        loginPage page = new loginPage(driver);
        Assert.assertEquals(message, page.getErrorMessage());
    }
}
