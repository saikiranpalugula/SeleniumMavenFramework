package utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CommonElementMethods extends ElementReadyStatus{



    public CommonElementMethods(WebDriver driver, ExtentTest testStep, SoftAssert softAssert) {
        super(driver, testStep, softAssert);
    }



    public CommonElementMethods(WebDriver driver) {
        super(driver);
    }


    public void enterValueWhenVisible(WebElement element, String inputValue) throws IOException {
        try {
            ExtentTest var10000 = this.testStep;
            if (this.elementVisibleAndEnabled(element, 5)) {
                element.sendKeys(new CharSequence[]{inputValue});
                return;
            }
        } catch (Exception e) {
            e.getMessage();

        }
    }

    public void enterValueWhenVisible(By locator, String inputValue) throws IOException {
        try {
            ExtentTest var10000 = this.testStep;
            if (this.elementVisibleAndEnabled(locator, 5)) {
                this.driver.findElement(locator).sendKeys(new CharSequence[]{inputValue});
                return;
            }
        } catch (Exception e) {
            e.getMessage();

        }
    }

}
