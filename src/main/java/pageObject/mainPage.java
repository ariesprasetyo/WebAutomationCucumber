package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class mainPage {
    public static WebDriver driver;
    public mainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//a[contains(.,'Men')]")
    private WebElement menCategory;

    @FindBy(xpath = "//a[contains(.,'Tshirts')]")
    private WebElement tshirtsCategory;

    @FindBy(css = ".title")
    private WebElement title;

    @FindBy(xpath = "//a[@href='/product_details/2']")
    private WebElement viewProductButton;

    @FindBy(id = "quantity")
    private WebElement quantityField;

    @FindBy(css = " .cart")
    private WebElement cartButton;

    @FindBy(css = "u")
    private WebElement viewChartButton;

    @FindBy(xpath = "//p[.='Rs. 400']")
    private WebElement price;

    @FindBy(css = ".disabled")
    private WebElement quantity;

    @FindBy(css = ".cart_total_price")
    private WebElement totalPrice;


    public void clickMenCategory() {
        menCategory.click();
    }

    public void clickTshirtsCategory() {
        tshirtsCategory.click();
    }

    public void clickViewProductButton() {
        viewProductButton.click();
    }

    public void quantityFieldSet(String quantity) {

        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickViewChartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[.='View Cart']")));
        element.click();
    }

    public boolean isTitleDisplayed() {
        return title.isDisplayed();
    }

    public int getPrice() {
        return Integer.parseInt(price.getText().substring(3).trim());
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getText());
    }

    public int totalPrice() {
        return Integer.parseInt(totalPrice.getText().substring(3).trim());
    }
}