package testcases;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.Basetest;
import pages.Dashboard;
import pages.Loginpage;

public class DashboardTest extends Basetest {
    Dashboard dash;
    Loginpage login;

    // ✅ Reusable method for both Manager & Associate
    private void performDashboardActions(String role) {
        loginAs(role);
        dash = new Dashboard(driver);

        Assert.assertTrue(dash.isDisplayed(), role + " Dashboard is not loaded properly");
        System.out.println(role + " dashboard loaded properly");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        login = new Loginpage(driver);
        if (role.equalsIgnoreCase("manager")) {
            login.prflClick();
        } else {
            login.associateClick();
        }
        login.profile_logout();
        System.out.println(role + " logged out successfully.");
    }

    @Test(priority = 1)
    public void verifyDashboardAsManager() {
        performDashboardActions("manager");  // Manager actions
    }

    @Test(priority = 2)
    public void verifyDashboardAsAssociate() {
        performDashboardActions("associate");  // Associate actions
    }
}
