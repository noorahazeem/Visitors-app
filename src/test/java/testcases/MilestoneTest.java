package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Basetest;
import pages.Loginpage;
import pages.Milestone;

public class MilestoneTest extends Basetest {
		Milestone obj;
		Loginpage login;
		
		@Test(priority=1)
		public void verifyDisplaymanager() {
			loginAs("manager");
			
			obj=new Milestone(driver);
			Assert.assertTrue(obj.isDisplayed(), "Display not proper");
			System.out.println("Milestone field loaded properly");
			
			obj.milestonedisplay();
			
			login =new Loginpage(driver);
			login.prflClick();
			login.profile_logout();
		}
		
	
			@Test(priority=2)
			public void verifyDisplayassociate() {
				loginAs("associate");
				
				obj=new Milestone(driver);
				Assert.assertTrue(obj.isDisplayed(), "Display not proper");
				System.out.println("Milestone field loaded properly");
				obj.milestonedisplay();

				
				login =new Loginpage(driver);
				login.associateClick();
				login.profile_logout();
		}
}
