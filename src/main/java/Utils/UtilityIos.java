package Utils;

import java.time.Duration;
import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class UtilityIos {
	protected AppiumDriver driver;

    public UtilityIos(AppiumDriver driver2) {
        this.driver = driver2;
    }
    public void scroll(int startX, int startY, int endY) {
    	PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");
    	Sequence scroll=new Sequence(finger, 1);
    	
    	scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
    	scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    	scroll.addAction(finger.createPointerMove(Duration.ofMillis(15), PointerInput.Origin.viewport(), startX, endY));
    	scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    	
    	driver.perform(Arrays.asList(scroll));
    	
    }
    
    public void screenShot() throws IOException {
    	TakesScreenshot scr=((TakesScreenshot)driver);
    	File src=scr.getScreenshotAs(OutputType.FILE);
    	File dest=new File("//");
    	FileUtils.copyFile(src, dest);
    	
    }
    
    public void excelReader(String sheet, int row, int col) throws IOException {
    	FileInputStream fis=new FileInputStream("//filepath.......");
    	XSSFWorkbook xw=new XSSFWorkbook(fis);
    	XSSFSheet xs= xw.getSheet(sheet);
    	xs.getRow(row).getCell(col);
    	
    }
}
