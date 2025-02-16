package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Basetest;
import pages.Loginpage;
import pages.UpcomingVisit;

public class UpcomingVisitTest extends Basetest {
		Loginpage login;
		UpcomingVisit visit;
		
		@Test(priority=1)
		public void verifyVisitManager() {
			loginAs("manager");
			visit=new UpcomingVisit(driver);
			Assert.assertTrue(visit.isdisplayed(), "UpcomigVisit field is not proper");
			System.out.println("Upcoming visit loaded properly");
			
			Assert.assertTrue(visit.viewdetailsDisplay(), " View Details popup is not proper");
			System.out.println("View Details popup loaded properly");
			
			visit.viewdataClose();
			
			visit.actionUpdate();
			Assert.assertTrue(visit.updateformDisplay(), "Update form is not proper");
			System.out.println("Update form loaded properly");
			visit.update();
			Assert.assertTrue(visit.updateSuccess(), " Update success popup is not proper");
			System.out.println("Update success popup loaded properly");
			visit.updateClose();
			login=new Loginpage(driver);
			login.prflClick();
			login.profile_logout();
			
		}

		@Test(priority=2)
		public void verifyVisitAssociate() {
			loginAs("associate");
			visit=new UpcomingVisit(driver);
			Assert.assertTrue(visit.isdisplayed(), "UpcomigVisit field is not proper");
			System.out.println("Upcoming visit loaded properly");
			
			Assert.assertTrue(visit.viewdetailsDisplay(), " View Details popup is not proper");
			System.out.println("View Details popup loaded properly");
			
			visit.viewdataClose();
			
			login=new Loginpage(driver);
			login.associateClick();
			login.profile_logout();
			
		}
}
