package testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Basetest;
import pages.Loginpage;
import pages.VisitLogs;

public class VisitlogTest extends Basetest {
    VisitLogs visit;
    Loginpage login;
    
    @Test(priority = 1)
    public void visitlogAsManager() {
        visitlogAsRole("manager");
    }

    @Test(priority = 2)
    public void visitlogAsAssociate() {
        visitlogAsRole("associate");
    }

    // Reusable method for both roles
    public void visitlogAsRole(String role) {
        loginAs(role);  // Login using common method
        
        visit = new VisitLogs(driver);
        visit.click_logs();
        visit.isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(visit.isDisplayed(), "Visit Logs page is not displayed");
        System.out.println(role + " Visit Logs loaded properly");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        visit.clickExportCSV();
        
        // Verify CSV Download
        Assert.assertTrue(visit.isCSVDownloaded(), "CSV file was not downloaded!");
        System.out.println("CSV download successful");

        //logout
        login = new Loginpage(driver);
        if (role.equals("manager")) {
            login.prflClick();
        } else {
            login.associateClick();
        }
        login.profile_logout();
    }
}
