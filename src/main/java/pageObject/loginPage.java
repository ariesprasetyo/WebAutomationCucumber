package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    public static WebDriver driver;
    public loginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//div[@class='login-form']//input[@name='email']")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[.='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//h2[.='Login to your account']")
    private WebElement titleLogin;

    @FindBy(css = "b")
    private WebElement profileName;

    @FindBy(xpath = "//p[.='Your email or password is incorrect!']")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[contains(.,'Delete Account')]")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//a[.='Continue']")
    private WebElement continueButton;

    public void clickDeleteAccountButton() {
        deleteAccountButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
    public void emailFieldSet(String email) {
        emailField.sendKeys(email);
    }

    public void passwordFieldSet(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isTitleLoginDisplayed() {
       return titleLogin.isDisplayed();
    }

    public String getProfileName() {
        return profileName.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
