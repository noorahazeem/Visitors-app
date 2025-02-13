
	package testcases;

	import org.testng.annotations.Test;
	import base.Basetest;

import java.time.Duration;

import org.openqa.selenium.devtools.v129.profiler.model.Profile;
import org.testng.Assert;

import pages.Addvisit;
import pages.Dashboard;
	import pages.Loginpage;
import pages.ProfileView;

	public class DashboardTest extends Basetest {
	    
	    Dashboard dash;
	  
	    
	    @Test(priority = 1)
	    public void testDashboardAccessManager() {
	        //  Login as Manager
	        loginAs("manager");
	        
	        //  Verify Manager Dashboard
	        dash = new Dashboard(driver);
	        Assert.assertTrue(dash.isDisplayed(), "Manager Dashboard is not loaded properly");
	        System.out.println("Manager Dashboard loaded properly");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        // Logout as Manager
	        loginpage.prflClick();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        loginpage.profile_logout();
	    }
	    
	        @Test(priority = 2)
		    public void testDashboardAccessAssociate() {
	        //  Login as Associate
	        loginAs("associate");
	        
	        //  Verify Associate Dashboard
	        dash = new Dashboard(driver);
	        Assert.assertTrue(dash.isDisplayed(), "Associate Dashboard is not loaded properly");
	        System.out.println("Associate Dashboard loaded properly");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	      

	        // Logout as Associate
	        loginpage.associateClick();
	        loginpage.profile_logout();
	    }
	}
