package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Log;
import utils.CommonElementMethods;

import java.io.IOException;

public class LoginPage {

    private WebDriver driver;
    CommonElementMethods commonElementMethods;

    private By usernameTxtbox = By.id("Email");

    //private By passwdTxtbox = By.cssSelector("#Password");
    @FindBy(css="#Password")
    WebElement passwdTxtbox;

    @FindBy(xpath = "//*[text()='Log i']")
    WebElement loginBtn;
    //private By loginBtn = By.xpath("//*[text()='Log in']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        commonElementMethods = new CommonElementMethods(this.driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String passWord) throws IOException {
        driver.findElement(usernameTxtbox).clear();
        driver.findElement(usernameTxtbox).sendKeys(userName);

        passwdTxtbox.clear();
        //passwdTxtbox.sendKeys(passWord);
        this.commonElementMethods.enterValueWhenVisible(passwdTxtbox, passWord);
        /*driver.findElement(passwdTxtbox).clear();
        driver.findElement(passwdTxtbox).sendKeys(passWord);
        driver.findElement(loginBtn).click();*/

        loginBtn.click();
        Assert.assertEquals(driver.getTitle(),"Just a moment...");
    }

    public void enterUsername(String username){
        driver.findElement(usernameTxtbox).clear();
        driver.findElement(usernameTxtbox).sendKeys(username);
    }

    public void enterPassword(String password){
       /* driver.findElement(passwdTxtbox).clear();
        driver.findElement(passwdTxtbox).sendKeys(password);*/

        passwdTxtbox.clear();
        passwdTxtbox.sendKeys(password);
    }

    public void clickLogin(){
        //driver.findElement(loginBtn).click();
        loginBtn.click();
        Log.info("Clicked on Login button");
    }
}
