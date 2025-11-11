package tests;

import base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import reports.ExtentManager;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    ExtentReports extent = ExtentManager.getReportObject();
    ExtentTest test;

    @BeforeMethod
    public void startReport() {
        test = extent.createTest("Verify OrangeHRM Login");
    }

    @Test
    public void verifyLogin() {
        try {
            LoginPage login = new LoginPage(driver);
            login.login("Admin", "admin123");
            test.log(Status.PASS, "Login test executed successfully on OrangeHRM site.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Failed: " + e.getMessage());
        }
    }

    @AfterMethod
    public void endReport() {
        extent.flush();
    }
}
