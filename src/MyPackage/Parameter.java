package MyPackage;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Parameter {

	static DesiredCapabilities caps = new DesiredCapabilities();
	static AndroidDriver driver;

	void AdditionFunction(String number1, String number2) {

		List<WebElement> allDigits = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < allDigits.size(); i++) {
			if (allDigits.get(i).getAttribute("resource-id").contains(number1)) {
				allDigits.get(i).click();
				driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
			} else if (allDigits.get(i).getAttribute("resource-id").contains(number2)) {
				allDigits.get(i).click();
			}
		}
	}

	void SubFunction(String number3, String number4) {
		List<WebElement> allDigits = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < allDigits.size(); i++) {
			if (allDigits.get(i).getAttribute("resource-id").contains(number3)) {
				allDigits.get(i).click();
				driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
			} else if (allDigits.get(i).getAttribute("resource-id").contains(number4)) {
				allDigits.get(i).click();

			}

		}
	}

	void PowerFunction(String number5, String number6) {
		List<WebElement> allDigits = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < allDigits.size(); i++) {
			if (allDigits.get(i).getAttribute("resource-id").contains(number5)) {
				allDigits.get(i).click();

				driver.findElement(By.id("com.google.android.calculator:id/op_pow")).click();

			} else if (allDigits.get(i).getAttribute("resource-id").contains(number6)) {
				allDigits.get(i).click();

			}
		}

	}
	
	static void TakeScreenShotFunction() throws IOException {
		Date currentDate = new Date() ; 
		String ActualDate = currentDate.toString().replace(":", "-"); 
		System.out.println(currentDate);
		
		TakesScreenshot src = ((TakesScreenshot) driver);
		File srcFile = src.getScreenshotAs(OutputType.FILE); 
		File dest = new File(".//myPictures/"+ ActualDate+".png"); 
		
		FileUtils.copyFile(srcFile, dest);
	}
}
