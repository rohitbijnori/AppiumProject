
package Test;

import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class BaseTest {

    protected AppiumDriver driver;
    protected String platform;

    @BeforeClass
    public void configureAppium() throws Exception {

        platform = System.getProperty("platform", "Android");
        String appiumUrl = System.getProperty(
                "appiumUrl", "http://127.0.0.1:4723");

        System.out.println("Selected platform: " + platform);
        System.out.println("Appium URL: " + appiumUrl);

        if (platform.equalsIgnoreCase("Android")) {

            UiAutomator2Options options = new UiAutomator2Options();

            options.setDeviceName("Pixel_8_Pro");
            options.setPlatformName("Android");
            options.setPlatformVersion("10");
            options.setAutomationName("UiAutomator2");
            options.setCapability("appium:avd", "Pixel_8_Pro");
            options.setIgnoreHiddenApiPolicyError(true);
            options.setAutoGrantPermissions(true);
            options.setNoReset(true);

            options.setApp(System.getProperty("user.dir")
                    + "/Resource/General-Store.apk");

            driver = new AndroidDriver(new URL(appiumUrl), options);

        } else if (platform.equalsIgnoreCase("iOS")) {

            XCUITestOptions options = new XCUITestOptions();

            options.setPlatformName("iOS");
            options.setDeviceName("iPhone 17 Pro");
            options.setPlatformVersion("26.5");
            options.setAutomationName("XCUITest");

            options.setApp(System.getProperty("user.dir")
                    + "/Resource/UIKitCatalog.app");

            driver = new IOSDriver(new URL(appiumUrl), options);

        } else {
            throw new IllegalArgumentException(
                    "Invalid platform: " + platform);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println(platform + " application session closed.");
        }
    }
}
