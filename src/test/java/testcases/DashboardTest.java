package testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Basetest;
import pages.Dashboard;


public class DashboardTest extends Basetest {
    Dashboard dash;

    @Test(priority = 1)
    public void verifyDashboardAsManager() {
        loginAs("manager");  // Login using common method
        dash = new Dashboard(driver);
        Assert.assertTrue(dash.isDisplayed(),"Manager Dashboard is not loaded properly");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 2)
    public void verifyDashboardAsAssociate() {
        loginAs("associate");  // Login using common method
        dash = new Dashboard(driver);
        Assert.assertTrue(dash.isDisplayed(),"Associate Dashboard is not loaded properly");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
