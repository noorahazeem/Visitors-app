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
        loginAs("manager");  // Login using common method
        visit=new VisitLogs(driver);
        
        visit.click_logs();
        visit.isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(visit.isDisplayed(), "Visit Logs page is not displayed");
        System.out.println("Manager Visit Logs loaded properly");

        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        visit.clickExportCSV();
        // Verify CSV Download
        Assert.assertTrue(visit.isCSVDownloaded(), "CSV file was not downloaded!");
        System.out.println("CSV download succesful");
        visit.add_visit();
        System.out.println("Add visit done");
        
        login=new Loginpage(driver);
        login.prflClick();
        login.profile_logout();
        
        
    }
    @Test(priority = 2)
    public void visitlogAsAssociate() {
        loginAs("associate");  // Login using common method
        visit=new VisitLogs(driver);
        
        visit.click_logs();
        visit.isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(visit.isDisplayed(), "Visit Logs page is not displayed");
        System.out.println("associate Visit Logs loaded properly");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        visit.clickExportCSV();
        
        // Verify CSV Download
        Assert.assertTrue(visit.isCSVDownloaded(), "CSV file was not downloaded!");
        System.out.println("CSV download succesful");
        
        login=new Loginpage(driver);
        login.associateClick();
        login.profile_logout();
    }
}
