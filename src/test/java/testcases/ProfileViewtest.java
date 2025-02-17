package testcases;

import base.Basetest;
import pages.Loginpage;
import pages.ProfileView;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileViewtest extends Basetest {

    ProfileView pro;
    Loginpage login;

    @Test(priority = 1)
    public void testProfileViewManager() {
        testProfileView("manager", true);
    }

    @Test(priority = 2)
    public void testProfileViewAssociate() {
        testProfileView("associate", false);
    }

    // Reusable method for both roles
    public void testProfileView(String role, boolean isManager) {
        loginAs(role);  // Login using common method

        pro = new ProfileView(driver);
        login = new Loginpage(driver);

        if (isManager) {
            pro.profileManager();
            pro.click_Profile();
            pro.isDisplayed();
            Assert.assertTrue(pro.profileManager(), "Profile loading not proper");
            System.out.println("Manager profile loaded successfully");
            pro.resetPassword("Managertest@123", "NewPassword@2024");
            login.prflClick();
        } else {
            pro.profileAssociate();
            login.associateClick();
        }
        login.profile_logout();
    }
}
