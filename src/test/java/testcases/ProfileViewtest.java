package testcases;


import base.Basetest;
import pages.Loginpage;
import pages.ProfileView;


import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileViewtest extends Basetest {
    
    ProfileView pro;
    Loginpage login ;
    
    @Test(priority = 1)
    public void testProfileViewManager() {
        loginAs("manager");  // Login using common method

        pro = new ProfileView(driver);
        login =new Loginpage(driver);
        pro.profileManager();
        pro.click_Profile();
        pro.isDisplayed();
        Assert.assertTrue(pro.profileManager(), "Profile loading not proper");
        System.out.println("Manager profile loaded successfully");
        pro.resetPassword("Managertest@123", "NewPassword@2024");
        login.prflClick();
        login.profile_logout();
    }

    @Test(priority = 2)
    public void testProfileViewAssociate() {
        loginAs("associate");  // Login using common method

    	pro = new ProfileView(driver);
        login =new Loginpage(driver);
        pro.profileAssociate();
        login.associateClick();
        login.profile_logout();
    }
}
