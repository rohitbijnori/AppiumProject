package Test;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	protected AppiumDriver driver;
	protected String platform;
    
	private AppiumDriverLocalService service;
	

//public URL startServer() {
//
//    File appiumJS = new File(
//        "/usr/local/lib/node_modules/appium/build/lib/main.js"
//    );
//
//    if (!appiumJS.exists()) {
//        throw new RuntimeException(
//            "Appium JS file not found: " + appiumJS.getAbsolutePath()
//        );
//    }
//
//    AppiumServiceBuilder builder = new AppiumServiceBuilder()
//        .withAppiumJS(appiumJS)
//        .withIPAddress("127.0.0.1")
//        .usingPort(4723)
//        .withLogFile(new File(
//            System.getProperty("user.dir") + "/appium-server.log"
//        ));
//
//    service = AppiumDriverLocalService.buildService(builder);
//
//    service.start();
//
//    if (!service.isRunning()) {
//        throw new RuntimeException("Appium server failed to start");
//    }
//
//    System.out.println("Appium server started: " + service.getUrl());
//
//    return service.getUrl();
//}
//
//	
//	@BeforeClass
//    @Parameters({"platform"})
//    public void configureAppium(String platform) throws Exception {
//		this.platform = platform;
//
//	    System.out.println("Starting Appium for: " + platform);
//
//	    URL serverURL = startServer();
//
//	    System.out.println("Creating driver using: " + serverURL);
//
//        if (platform.equalsIgnoreCase("Android")) {
//
//            UiAutomator2Options options = new UiAutomator2Options();
//
//            options.setDeviceName("Pixel_8_Pro");
//            options.setPlatformVersion("10");
//            options.setAutomationName("UiAutomator2");
//            options.setCapability("appium:avd", "Pixel_8_Pro");
//            options.setIgnoreHiddenApiPolicyError(true);
//            options.setAutoGrantPermissions(true);
//            options.setNoReset(true);
//
//            options.setApp(
//                System.getProperty("user.dir")
//                + "/Resource/General-Store.apk"
//            );
//
//            driver = new AndroidDriver(serverURL, options);
//
//        } else if (platform.equalsIgnoreCase("iOS")) {
//
//            XCUITestOptions options = new XCUITestOptions();
//
//            options.setDeviceName("iPhone 17 Pro");
//            options.setPlatformVersion("26.5");
//            options.setAutomationName("XCUITest");
//
//            options.setApp(
//                System.getProperty("user.dir")
//                + "/Resource/UIKitCatalog.app"
//            );
//
//            driver = new IOSDriver(serverURL, options);
//
//        } else {
//            stopServer();
//            throw new IllegalArgumentException(
//                "Invalid platform: " + platform
//            );
//        }
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDown() {
//
//        try {
//            if (driver != null) {
//                driver.quit();
//                driver = null;
//            }
//        } finally {
//            stopServer();
//        }
//    }
//
//    public void stopServer() {
//        if (service != null && service.isRunning()) {
//            service.stop();
//            System.out.println("Appium server stopped");
//        }
//    }

	
	
    @BeforeClass
    @Parameters({"platform"})
    public void configureAppium(String platform) throws MalformedURLException {
    	this.platform = platform;  // Important fix

	    System.out.println("BaseTest platform = " + this.platform);
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
            //options.setAppPackage("com.androidsample.generalstore");
           // options.setAppActivity("com.androidsample.generalstore.MainActivity");
            options.setApp(System.getProperty("user.dir")
                    + "/Resource/General-Store.apk");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        } else if (platform.equalsIgnoreCase("iOS")) {

            XCUITestOptions options = new XCUITestOptions();

            options.setPlatformName("iOS");
            options.setDeviceName("iPhone 17 Pro");
            options.setPlatformVersion("26.5");
            //options.setUdid("D8DF7185-2D08-467E-A5E7-1F3CE4991FD1");
            options.setAutomationName("XCUITest");
            options.setApp(System.getProperty("user.dir")
                    + "/Resource/UIKitCatalog.app");

            driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        } else {
            throw new IllegalArgumentException("Invalid platform: " + platform);
        }
    }
   
	@AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        if (service != null && service.isRunning()) {
            service.stop();
        }
    }
}