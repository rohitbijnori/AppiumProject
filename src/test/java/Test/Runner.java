
package Test;

import org.testng.annotations.Test;

import PageObject.Register;
import PageObject.Switches;

public class Runner extends BaseTest {

    @Test
    public void registerUser() throws InterruptedException {

        System.out.println("Runner platform = " + platform);

        Register register = new Register(driver, platform);
        register.registerToApp();
    }

//    @Test
//    public void switchTest() throws InterruptedException {
//
//        System.out.println("Runner platform = " + platform);
//
//        Switches sw = new Switches(driver, platform);
//        sw.switchTest();
//    }
}
 