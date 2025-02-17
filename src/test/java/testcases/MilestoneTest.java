package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Basetest;
import pages.Loginpage;
import pages.Milestone;

public class MilestoneTest extends Basetest {
    Milestone obj;
    Loginpage login;

    @Test(priority = 1)
    public void verifyDisplaymanager() {
        verifyDisplay("manager");
    }

    @Test(priority = 2)
    public void verifyDisplayassociate() {
        verifyDisplay("associate");
    }

    // Reusable method for both roles
    public void verifyDisplay(String role) {
        loginAs(role);
        
        obj = new Milestone(driver);
        Assert.assertTrue(obj.isDisplayed(), "Display not proper");
        System.out.println("Milestone field loaded properly");
        obj.milestonedisplay();

        login = new Loginpage(driver);
        if (role.equals("manager")) {
            login.prflClick();
        } else if (role.equals("associate")) {
            login.associateClick();
        }
        login.profile_logout();
    }
}
