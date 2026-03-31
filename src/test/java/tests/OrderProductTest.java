package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LogoutPage;
import pages.ProductsPage;
import pages.LoginPage;
import pages.CheckoutPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

import java.io.IOException;

public class OrderProductTest extends BaseTest {



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
    public void orderProduct( String username, String password) throws IOException, InterruptedException {
        LoginPage loginpg = new LoginPage(driver);
        ProductsPage productspg = new ProductsPage(driver);
        CheckoutPage checkoutpg = new CheckoutPage(driver);
        LogoutPage logoutpg = new LogoutPage(driver);
        Log.info("Starting Login Test");
        test = ExtentReportManager.createTest("Login Test with "+ username);
        //test.info("Adding credentials");
        loginpg.login(username, password);
        //test.info("Login completed");
        test.pass("user logged in Successfully");
        //productspg.addProduct("Codemify Bike Light");
        productspg.addMultipleProducts("Codemify Backpack", "Codemify Onesie", "Codemify Bike Light");
        test.pass("Product added to cart");
        checkoutpg.shippingInfo();
        test.pass("Added shipping information");
        checkoutpg.PaymentInfo();
        test.pass("Added Payment information");
        logoutpg.logout();
        test.pass("Logout was successfull");
    }




}
