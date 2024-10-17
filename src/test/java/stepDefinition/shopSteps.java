package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.mainPage;

public class shopSteps {
    final private WebDriver driver;
    public shopSteps() {
        super();
        this.driver = Hooks.webDriver;
    }

    @When("the user clicks MEN category and choses Tshirts")
    public void theUserClicksMENCategoryAndChosesTshirts() {
        mainPage page = new mainPage(driver);
        webDriverWait(5);
        page.clickMenCategory();
        webDriverWait(10);
        page.clickTshirtsCategory();
    }

    private void webDriverWait(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the user is redirected to the product page")
    public void theUserIsRedirectedToTheProductPage() {
        mainPage page = new mainPage(driver);
        Assert.assertTrue(page.isTitleDisplayed());
        page.clickViewProductButton();
    }

    @When("the user add {string} quantity to the product")
    public void theUserAddQuantityToTheProduct(String quantity) {
        mainPage page = new mainPage(driver);
        page.quantityFieldSet(quantity);
    }
    @And("the user click the Add to cart button")
    public void theUserClickTheAddToCartButton() {
        mainPage page = new mainPage(driver);
        page.clickCartButton();
    }

    @Then("the user click the View cart button")
    public void theUserClickTheViewCartButton() {
        mainPage page = new mainPage(driver);
        page.clickViewChartButton();
    }

    @And("Total price = price multiplied by quantity")
    public void total_price() {
        mainPage page = new mainPage(driver);
        int actualTotalPrice = page.getPrice() * page.getQuantity();
        Assert.assertEquals(page.totalPrice(),actualTotalPrice);
    }


}
