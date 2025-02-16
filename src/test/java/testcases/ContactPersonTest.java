package testcases;

import java.time.Duration;

import org.testng.annotations.Test;

import base.Basetest;
import pages.AddvisitManager;
import pages.ContactPerson;

public class ContactPersonTest extends Basetest{
		ContactPerson cont;
		AddvisitManager add;

	    @Test(priority = 1)
		public void verifyAddContactmanager() {
			loginAs("manager");
			
			add=new AddvisitManager(driver);
			add.add_visit();
			add.select_inst();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			cont=new ContactPerson(driver);
	        cont.addPerson();
	        cont.addContactisDisplayed();
	        cont.form();
	        cont.cancel();
		}
	    @Test(priority = 1)
		public void verifyAddContactassociate() {
			loginAs("associate");
			
			add=new AddvisitManager(driver);
			add.add_visit();
			add.select_inst();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			cont=new ContactPerson(driver);
	        cont.addPerson();
	        cont.addContactisDisplayed();
	        cont.form();
	        cont.cancel();
		}
}
