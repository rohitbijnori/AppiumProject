package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.Register;
import PageObject.Switches;
import Test.BaseTest;



public class Runner extends BaseTest{
	
	
//	 @Test
//	    @Parameters({"platform"})
//	    public void registerUser() throws InterruptedException {
//		 Register register = new Register(driver, platform);
//	        
//	        register.registerToApp();
//
//	    }
	 
	 @Test
	 public void registerUser() throws InterruptedException {

	     System.out.println("Runner platform = " + platform);

	     Register register = new Register(driver, platform);
	     register.registerToApp();
	 }
	 
	 @Test
	 public void switchTest() throws InterruptedException {

	     System.out.println("Runner platform = " + platform);

	     Switches sw = new Switches(driver, platform);
	     sw.switchTest();
	 }
	 
//	 @DataProvider (name="getData")
//	 public Object[][] getData(){
//		 Object[][] data = new Object[2][2];
//		data[0][0]="FirstName";
//		data [0][1]="LastName";
//		data [1][0]="email";
//		data [1][1]="Phone";
//		return data;
//	 }
	 
}	 


 