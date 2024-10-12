package stepDefinition;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObject.loginPage;

public class clearDataSteps {
    final private WebDriver driver;
    public clearDataSteps() {
        super();
        this.driver = Hooks.webDriver;
    }
    @Then("the user clicks the Delete Account button")
    public void theUserClicksTheDeleteAccountButton() {
        loginPage page = new loginPage(driver);
        page.clickDeleteAccountButton();
        page.clickContinueButton();
    }
}
