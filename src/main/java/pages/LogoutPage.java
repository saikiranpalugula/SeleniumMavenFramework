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

public class LogoutPage {

    private WebDriver driver;
    CommonElementMethods commonElementMethods;



    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logoutBtn;

    public LogoutPage(WebDriver driver){
        this.driver = driver;
        commonElementMethods = new CommonElementMethods(this.driver);
        PageFactory.initElements(driver, this);
    }

   public void logout(){
       logoutBtn.click();
   }


}
