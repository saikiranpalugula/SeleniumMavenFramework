package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @DataProvider(name="LoginData")
    public Object[][] getLoginData() throws IOException {
        String filePath=System.getProperty("user.dir")+"/src/test/resources/testdata/TestData.xlsx";
        ExcelUtils.loadExcel(filePath,"Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][2];
        for(int i=1;i<rowCount;i++){
            data[i-1][0]=ExcelUtils.getCellData(i,0);
            data[i-1][1]=ExcelUtils.getCellData(i,1);
        }
        ExcelUtils.closeExcel();
        return data;
    }

    @Test(dataProvider = "LoginData")
    public void testValidLogin( String username, String password){
        LoginPage loginpg = new LoginPage(driver);
        /*loginpg.enterUsername("admin@yourstore.com");
        loginpg.enterPassword("admin");
        loginpg.clickLogin();
        System.out.println(driver.getTitle());*/
        Log.info("Starting Login Test");
        test = ExtentReportManager.createTest("Login Test with "+ username);
        test.info("Adding credentials");
        loginpg.login(username, password);
        test.info("Login completed");
        test.pass("Login Successfully");
    }

    @Test(enabled = false)
    public void testInValidLogin(){
        LoginPage loginpg = new LoginPage(driver);
        /*loginpg.enterUsername("admin@yourstore.com");
        loginpg.enterPassword("admin");
        loginpg.clickLogin();
        System.out.println(driver.getTitle());*/
        Log.info("Starting Login Test");
        test = ExtentReportManager.createTest("Login Test");
        test.info("Adding credentials");
        loginpg.login("admin@yourstore.com", "admin...");
        test.info("Login completed");
        test.pass("Login Successfully");
    }


}
