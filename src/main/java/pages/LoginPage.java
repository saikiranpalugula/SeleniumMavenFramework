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

    //private By usernameTxtbox = By.id("Email");

    private By usernameTxtbox = By.xpath("//*[@placeholder='Username']");

    private By passwdTxtbox = By.xpath("//*[@placeholder='Password']");

    //private By loginBtn = By.cssSelector(".login-button");

    @FindBy(css = ".login-button")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        commonElementMethods = new CommonElementMethods(this.driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String passWord) throws IOException {

        driver.findElement(usernameTxtbox).sendKeys(userName);
        this.commonElementMethods.enterValueWhenVisible(passwdTxtbox, passWord);
        loginBtn.click();
        Assert.assertEquals(driver.getTitle(),"E-Commerce Demo");
    }

    public void enterUsername(String username){
        driver.findElement(usernameTxtbox).clear();
        driver.findElement(usernameTxtbox).sendKeys(username);
    }

    public void enterPassword(String password){
       /* driver.findElement(passwdTxtbox).clear();
        driver.findElement(passwdTxtbox).sendKeys(password);*/

        //passwdTxtbox.clear();
        //passwdTxtbox.sendKeys(password);
    }

    public void clickLogin(){
        //driver.findElement(loginBtn).click();
        loginBtn.click();
        Log.info("Clicked on Login button");
    }
}
