package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://admin-demo.nopcommerce.com/login");
        driver.findElement(By.id("Email")).clear();

        driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("#Password")).clear();
        driver.findElement(By.cssSelector("#Password")).sendKeys(("admin"));
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        driver.quit();

    }
}