package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Basetest;
import pages.FollowUp;
import pages.Loginpage;
import pages.UpcomingVisit;
import pages.VisitLogs;

public class UpcomingVisitTest extends Basetest {
    Loginpage login;
    UpcomingVisit visit;
    FollowUp follow;
    VisitLogs log;

    // Reusable method for both Manager & Associate
    private void performVisitActions(String role) {
        loginAs(role);
        visit = new UpcomingVisit(driver);
        
        //upcoming visit display
        Assert.assertTrue(visit.isdisplayed(), "Upcoming Visit field is not displayed properly.");
        System.out.println("Upcoming Visit loaded properly for " + role);
        
        log= new VisitLogs(driver);
        log.click_logs(); 
        
        Assert.assertTrue(visit.viewdetailsDisplay(), "View Details popup is not displayed properly.");
        System.out.println("View Details popup loaded properly for " + role);

        visit.viewdataClose();
        System.out.println("View Details Tab closed for " + role);
        
        //Action Update
        visit.actionUpdate();
        System.out.println("Update icon clicked for " + role);

        visit.update("Action Needed"); 
        System.out.println("Status updated for " + role);

        visit.updateSuccessClose();
        System.out.println("Update popup closed for " + role);
        
        //Action Delete
//        visit.actionDlt();
//        visit.handleDeletePopup(role);
//        visit.handleDeletePopup("No longer needed");

        // Logout
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
    public void verifyVisitManager() {
        performVisitActions("manager");  // Manager actions
    }

    @Test(priority = 2)
    public void verifyVisitAssociate() {
        performVisitActions("associate");  // Associate actions
    }
    
    //Follow-Up Action
    @Test(priority=3)
    public void testFollowUpAction() {
    	loginAs("manager");
    	log= new VisitLogs(driver);
        log.click_logs();
        follow=new FollowUp(driver);
    	follow.followupClick();
        follow.enterActionDetails();
        follow.enterActionDescription();
        follow.enterActionDueDate();
        follow.selectStatus();
        follow.checkAddVisit();
        follow.clickSubmit();
    }
}
