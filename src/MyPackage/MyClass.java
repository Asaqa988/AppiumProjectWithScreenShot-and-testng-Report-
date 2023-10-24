package MyPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyClass extends Parameter {

//	@BeforeMethod
//	public void myBeforeMethod() throws MalformedURLException {
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//
//	}

	@BeforeTest
	public void mySetup() {

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "qa");
		File CalculatorApp = new File("src/MyApplications/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, CalculatorApp.getAbsolutePath());
	}

	@Test(groups = "high priortiy")

	public void TestAdditionProcess() throws IOException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		AdditionFunction("7", "5");
		TakeScreenShotFunction();
	}

	@Test(groups = "low priortiy")
	public void TestSubtractionProcess() throws IOException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		SubFunction("8", "3");
		TakeScreenShotFunction();
	}

	@Test(groups = "high priortiy")
	public void PowerFunctionTest() throws IOException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		PowerFunction("6", "3");
		TakeScreenShotFunction();
	}

	@AfterTest
	public void postTesting() {
	}

}
