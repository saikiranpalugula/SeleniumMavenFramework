package utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.*;

import java.time.Duration;

public class ElementReadyStatus {

    public WebDriver driver;
    protected ExtentTest testStep;
    protected SoftAssert softAssert;

    public ElementReadyStatus(WebDriver driver, ExtentTest testStep, SoftAssert softAssert) {
        this.driver = driver;
        this.testStep = testStep;
        this.softAssert = softAssert;
    }

    public ElementReadyStatus(WebDriver driver) {
        this.driver = driver;
    }


    protected boolean elementVisibleAndEnabled(WebElement element, int timeout) {
        try {
            if (((WebElement) (new WebDriverWait(this.driver, Duration.ofSeconds((long) timeout)))
                    .until(ExpectedConditions.visibilityOf(element))).isEnabled()) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return false;
    }

    protected boolean elementVisibleAndEnabled(By locator, int timeout) {
        try {
            if (((WebElement) (new WebDriverWait(this.driver, Duration.ofSeconds((long) timeout)))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator))).isEnabled()) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return false;
    }

}


