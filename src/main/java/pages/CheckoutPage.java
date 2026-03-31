package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonElementMethods;

import java.io.IOException;

public class CheckoutPage {

    private WebDriver driver;
    CommonElementMethods commonElementMethods;

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement FirstNametxtbox;

    @FindBy(xpath = "//*[@id='lastName']")
    WebElement LastNametxtbox;

    @FindBy(xpath = "//*[@id='email']")
    WebElement Emailtxtbox;

    @FindBy(xpath = "//*[@id='address']")
    WebElement Addrestxtbox;

    @FindBy(xpath = "//*[@id='city']")
    WebElement Citytxtbox;

    @FindBy(xpath = "//*[@id='state']")
    WebElement Statetxtbox;

    @FindBy(xpath = "//*[@id='zipCode']")
    WebElement Zipcodetxtbox;

    @FindBy(xpath = "//*[@id='cardNumber']")
    WebElement CardNumtxtbox;

    @FindBy(xpath = "//*[@id='expiryDate']")
    WebElement expirytxtbox;

    @FindBy(xpath = "//*[@id='cvv']")
    WebElement Cvvtxtbox;

    @FindBy(xpath = "//*[text()='Complete Order']")
    WebElement completeOrdrBtn;


    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        commonElementMethods = new CommonElementMethods(this.driver);
        PageFactory.initElements(driver, this);
    }

    public void shippingInfo() throws IOException {
        this.commonElementMethods.enterValueWhenVisible(FirstNametxtbox,"Saikiran");
        this.commonElementMethods.enterValueWhenVisible(LastNametxtbox,"P");
        this.commonElementMethods.enterValueWhenVisible(Emailtxtbox,"sai@gmail.com");
        this.commonElementMethods.enterValueWhenVisible(Addrestxtbox,"Unit 2");
        this.commonElementMethods.enterValueWhenVisible(Citytxtbox,"Brisbane");
        this.commonElementMethods.enterValueWhenVisible(Statetxtbox,"Queensland");
        this.commonElementMethods.enterValueWhenVisible(Zipcodetxtbox,"40364");

    }

    public void PaymentInfo() throws IOException, InterruptedException {
        this.commonElementMethods.enterValueWhenVisible(CardNumtxtbox,"1234567891234");
        this.commonElementMethods.enterValueWhenVisible(expirytxtbox,"11/26");
        this.commonElementMethods.enterValueWhenVisible(Cvvtxtbox,"124");
        completeOrdrBtn.click();
        Thread.sleep(3000);
    }


}
