package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Utility {
	
	protected AppiumDriver driver;

    public Utility(AppiumDriver driver) {
        this.driver = driver;
    }

    // =========================================================
    // SCROLL DOWN
    // =========================================================

    public void scrollDown() {

        int height = driver.manage()
                           .window()
                           .getSize()
                           .getHeight();

        int width = driver.manage()
                          .window()
                          .getSize()
                          .getWidth();

        int startX = width / 2;
        int startY = (int) (height * 0.80);
        int endY = (int) (height * 0.20);

        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger"
                );

        Sequence scroll = new Sequence(finger, 1);

        scroll.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        startY
                )
        );

        scroll.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        scroll.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(800),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY
                )
        );

        scroll.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        driver.perform(Arrays.asList(scroll));
    }


    // =========================================================
    // SWIPE LEFT
    // =========================================================

    public void swipeLeft() {

        int height = driver.manage()
                           .window()
                           .getSize()
                           .getHeight();

        int width = driver.manage()
                          .window()
                          .getSize()
                          .getWidth();

        int startX = (int) (width * 0.80);
        int endX = (int) (width * 0.20);
        int y = height / 2;

        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger"
                );

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        y
                )
        );

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(800),
                        PointerInput.Origin.viewport(),
                        endX,
                        y
                )
        );

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        driver.perform(Arrays.asList(swipe));
    }


    // =========================================================
    // SWIPE RIGHT
    // =========================================================

    public void swipeRight() {

        int height = driver.manage().window().getSize().getHeight();
                           
        int width = driver.manage().window().getSize().getWidth();
                          
        int startX = (int) (width * 0.20);
        int endX = (int) (width * 0.80);
        int y = height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
             Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),  startX, y));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), endX, y));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }


    // =========================================================
    // SCROLL UNTIL TEXT IS VISIBLE
    // =========================================================

    public void scrollUntilTextVisible(String text) {

        By locator = By.xpath(
                "//*[contains(@text,'" + text + "') " +
                "or contains(@label,'" + text + "') " +
                "or contains(@name,'" + text + "')]"
        );

        for (int i = 0; i < 10; i++) {

            if (!driver.findElements(locator).isEmpty()) {

                System.out.println(
                        "Text found: " + text
                );

                return;
            }

            scrollDown();
        }

        throw new RuntimeException(
                "Text not found after scrolling: " + text
        );
    }


    // =========================================================
    // CLICK
    // =========================================================

    public void click(WebElement element) {

        element.click();
    }


    // =========================================================
    // ENTER TEXT
    // =========================================================

    public void enterText(WebElement element, String text) {

        element.clear();
        element.sendKeys(text);
    }


    // =========================================================
    // CHECK ELEMENT DISPLAYED
    // =========================================================

    public boolean isElementDisplayed(WebElement element) {

        try {

            return element.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    // =========================================================
    // SCREENSHOT
    // =========================================================

    public void takeScreenshot(String fileName)
            throws IOException {

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        File destination =
                new File(
                        System.getProperty("user.dir")
                        + "/screenshots/"
                        + fileName
                        + ".png"
                );

        FileUtils.copyFile(source, destination);

        System.out.println(
                "Screenshot saved: "
                + destination.getAbsolutePath()
        );
    }


    // =========================================================
    // WAIT
    // =========================================================

    public void waitForSeconds(int seconds)
            throws InterruptedException {

        Thread.sleep(seconds * 1000L);
    }
}
