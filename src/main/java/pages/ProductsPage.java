package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.CommonElementMethods;
import utils.Log;

import java.io.IOException;

public class ProductsPage {

    private WebDriver driver;
    CommonElementMethods commonElementMethods;

    @FindBy(xpath = "//h3[contains(text(),'Codemify Backpack')]//ancestor::div[contains(@class,'product-info')]//button")
    WebElement AddToCartBtn;

    public WebElement getAddToCartBtn(String productName) {
        String xpath = "//h3[contains(text(),'" + productName + "')]"
                + "//ancestor::div[contains(@class,'product-info')]//button";
        return driver.findElement(By.xpath(xpath));
    }


    @FindBy(xpath = "//*[text()='Proceed to Checkout']")
    WebElement ChkOutBtn;

    @FindBy(xpath = "//*[text()='Cart']")
    WebElement CartBtn;



    //private By usernameTxtbox = By.id("Email");



    public ProductsPage(WebDriver driver){
        this.driver = driver;
        commonElementMethods = new CommonElementMethods(this.driver);
        PageFactory.initElements(driver, this);
    }

    public void addProduct() throws InterruptedException {
        Thread.sleep(2000);
        AddToCartBtn.click();
        CartBtn.click();
        ChkOutBtn.click();
    }

    public void addProduct(String productName) throws InterruptedException {
        Thread.sleep(2000);
        getAddToCartBtn(productName).click();
        CartBtn.click();
        ChkOutBtn.click();
    }

    public void addMultipleProducts(String... productNames) throws InterruptedException {
        for (String product : productNames) {
            Thread.sleep(1000);
            getAddToCartBtn(product).click();
            Thread.sleep(1000);
        }
        CartBtn.click();
        ChkOutBtn.click();
    }




}
