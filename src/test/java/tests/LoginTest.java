package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin(){
        LoginPage loginpg = new LoginPage(driver);
        /*loginpg.enterUsername("admin@yourstore.com");
        loginpg.enterPassword("admin");
        loginpg.clickLogin();
        System.out.println(driver.getTitle());*/

        loginpg.login("admin@yourstore.com", "admin");
    }


}
