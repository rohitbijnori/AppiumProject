package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Switches extends Utility{
	AppiumDriver driver;
    private String platform;
    public Switches(AppiumDriver driver, String platform) {
        super(driver);

        this.driver = driver;       // Important fix
        this.platform = platform;

        PageFactory.initElements(
            new AppiumFieldDecorator(driver), this
        );
    }
    
  
    @AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]")
    private WebElement addToCart;
    
    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;
    
    @iOSXCUITFindBy(accessibility = "Switches")
    private WebElement switches;
    
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSwitch[@value=\"1\"])[1]")
    private WebElement defaultSwitch;
    
    public void switchTest() throws InterruptedException {

        if (driver == null) {
            throw new RuntimeException("Driver is NULL");
        }

        if (platform == null) {
            throw new RuntimeException("Platform is NULL");
        }

        if (platform.equalsIgnoreCase("Android")) {

        	addToCart.click();
        	cart.click();

        } else if (platform.equalsIgnoreCase("iOS")) {

            switches.click();
            defaultSwitch.click();

        } else {
            throw new IllegalArgumentException(
                "Invalid platform: " + platform
            );
        }

        Thread.sleep(3000);
    }
}


    

