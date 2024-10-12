package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerPage {
    public static WebDriver driver;
    public registerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[.='Create Account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//a[contains(.,'Signup / Login')]")
    private WebElement signupLoginButtonMenu;

    @FindBy(xpath = "//h2[.='New User Signup!']")
    private WebElement titleSignup;

    @FindBy(css = "[name='name']")
    private WebElement nameField;

    @FindBy(css = "[data-qa='signup-email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[.='Signup']")
    private WebElement signupButton;

    @FindBy(css = "[alt='Website for automation practice']")
    private WebElement logo;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement address1Field;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "state")
    private WebElement stateField;

    @FindBy(id = "zipcode")
    private WebElement zipField;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//b[.='Account Created!']")
    private WebElement accountCreatedTitle;

    @FindBy(css = "[action='/signup'] > p")
    private WebElement errorMessage;

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void clickSignupButton() {
        signupButton.click();
    }
    public boolean isTitleSignupDisplayed() {
        return titleSignup.isDisplayed();
    }
    public void nameFieldSet(String name) {
        nameField.sendKeys(name);
    }
    public void emailFieldSet(String email) {
        emailField.sendKeys(email);
    }
    public void clickSignupLoginButtonMenu() {
        signupLoginButtonMenu.click();
    }
    public void clickCreateAccountButton() {
//        createAccountButton.click();
        WebElement button = driver.findElement(By.cssSelector("button.btn.btn-default"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }
    public void accountInformation(String option, String password, String day, String month, String year) {
        WebElement radioButton = driver.findElement(By.xpath("//input[@value='" + option + "']"));
        radioButton.click();
        passwordField.sendKeys(password);
        WebElement dayField = driver.findElement(By.xpath("//select[@name='days']"));
        dayField.sendKeys(day);
        WebElement monthField = driver.findElement(By.xpath("//select[@name='months']"));
        monthField.sendKeys(month);
        WebElement yearField = driver.findElement(By.xpath("//select[@name='years']"));
        yearField.sendKeys(year);
    }

    public void addressInformation(String firstname, String lastname, String company, String address, String country, String state, String city, String zipcode, String mobile) {
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastname);
        companyField.sendKeys(company);
        address1Field.sendKeys(address);
        cityField.sendKeys(city);
        stateField.sendKeys(state);
        zipField.sendKeys(zipcode);
        mobileNumberField.sendKeys(mobile);
        WebElement dayField = driver.findElement(By.xpath("//select[@name='country']"));
        dayField.sendKeys(country);
    }
    public boolean isAccountCreatedTitleDisplayed() {
        return accountCreatedTitle.isDisplayed();
    }

    public String isErrorMessageDisplayed() {
        String message = driver.findElement(By.cssSelector("[data-qa='signup-email']")).getAttribute("validationMessage");
        return message;
    }
    public String isErrorMessageDisplayedFormAccountAddressInformation() {
        String message = driver.findElement(By.id("password")).getAttribute("validationMessage");
        return message;
    }

    public String isErrorMessageDisplayedEmailAlreadyExist() {
        return errorMessage.getText();
    }
}
