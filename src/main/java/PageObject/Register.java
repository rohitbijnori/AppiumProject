package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Register extends Utility{

    AppiumDriver driver;
    private String platform;
    public Register(AppiumDriver driver, String platform) {
        super(driver);

        this.driver = driver;       // Important fix
        this.platform = platform;

        PageFactory.initElements(
            new AppiumFieldDecorator(driver), this
        );
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameEdt;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement alertViews;

    @iOSXCUITFindBy(accessibility = "Text Entry")
    private WebElement textEntry;
    
//    public void registerToApp() throws InterruptedException {
//    	 if (platform.equalsIgnoreCase("android"))
//        nameEdt.sendKeys("Rohit");
//        letsShopBtn.click();
//        Thread.sleep(3000);
//        scrollUntilTextVisible("healthier");
//    }
    
    public void registerToApp() throws InterruptedException {

        System.out.println("Platform = " + platform);
        System.out.println("Driver = " + driver);

        if (driver == null) {
            throw new RuntimeException("Driver is NULL");
        }

        if (platform == null) {
            throw new RuntimeException("Platform is NULL");
        }

        if (platform.equalsIgnoreCase("Android")) {

            Thread.sleep(3000);
        	nameEdt.sendKeys("Rohit");
            letsShopBtn.click();

            Thread.sleep(3000);
           // scrollUntilTextVisible("healthier");

        } else if (platform.equalsIgnoreCase("iOS")) {

            alertViews.click();
            textEntry.click();

        } else {
            throw new IllegalArgumentException(
                "Invalid platform: " + platform
            );
        }

        Thread.sleep(3000);
    }
}

