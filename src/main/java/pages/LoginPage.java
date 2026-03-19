package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By usernameTxtbox = By.id("Email");
    private By passwdTxtbox = By.cssSelector("#Password");
    private By loginBtn = By.xpath("//*[text()='Log in']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String userName, String passWord){
        driver.findElement(usernameTxtbox).clear();
        driver.findElement(usernameTxtbox).sendKeys(userName);
        driver.findElement(passwdTxtbox).clear();
        driver.findElement(passwdTxtbox).sendKeys(passWord);
        driver.findElement(loginBtn).click();
    }

    public void enterUsername(String username){
        driver.findElement(usernameTxtbox).clear();
        driver.findElement(usernameTxtbox).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwdTxtbox).clear();
        driver.findElement(passwdTxtbox).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }
}
