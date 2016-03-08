package jk.appium.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jk.appium.deviceproperties.EnvoSetUp;

public class AppstoreInstall {
	EnvoSetUp setEnvo;

	@BeforeClass
	public void setUp() throws MalformedURLException 
	{
		setEnvo=new EnvoSetUp();		
		setEnvo.setCapabilities();
	}
	// Method that installs app from appstore, this method will install an app if not installed else it will uninstall the installed version and then install the app.
	@Test
	public void playInstall() throws InterruptedException, MalformedURLException 
	{
		WebDriverWait wait= new WebDriverWait(setEnvo.adir, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/search_box_idle_text"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.vending:id/search_box_text_input"))).sendKeys("VCStar");

		String adbpath ="C:\\Android\\android-sdk-windows\\platform-tools\\adb.exe";                // Passing the actual path for adb in processbuilder
		ProcessBuilder pb = new ProcessBuilder(adbpath,"shell", "input", "keyevent", "66");			// Parameters to run the adb command to tap enter on softkeyboard
		try {
			Process pc = pb.start();
			pc.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(2000);
		List<WebElement> playCardsTitles = setEnvo.adir.findElements(By.id("com.android.vending:id/li_title")); // Adding the title names of the search results to the list
		for(WebElement e : playCardsTitles)
		{
			if(e.getText().equalsIgnoreCase("Ventura County Star"))  // Comparing the name of the title with the app name that we want to install
			{
				e.click();
				if(IsTestElementPresent()==true)
				{
					setEnvo.adir.findElement(By.id("com.android.vending:id/uninstall_button")).click(); // Taps on Uninstall button
					setEnvo.adir.findElement(By.id("android:id/button1")).click();						// Taps on "OK" from the alert
					install();	
					testAppInstall();
				}
				else
				{
					install();
				}
			}
		}
		Thread.sleep(5000);
	}

	//Method that checks if an element is present or not
	public boolean IsTestElementPresent()
	{
		try
		{
			setEnvo.adir.findElement(By.id("com.android.vending:id/uninstall_button"));// To check if the Uninstall button/element is present or not
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	//Method to install an app and launch it.
	public void install()
	{
		WebDriverWait wait = new WebDriverWait(setEnvo.adir, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.vending:id/buy_button"))).click();// Taps on the Install button
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.vending:id/continue_button"))).click();//Taps on the "Accept" button from the alert
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.vending:id/launch_button"))).click();// Taps on the Open button to launch the app
		wait.until(ExpectedConditions.elementToBeClickable(By.name("Yes"))).click();// Taps on the "Yes" button for enabling Push notifications 
	}
	//@Test
	public void testAppInstall() throws MalformedURLException
	{
		String buildNo = "4.2.123.189";
		setEnvo.installTestApp();
		WebDriverWait wait = new WebDriverWait(setEnvo.adir, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.scripps.vcstar.mobile:id/sectionSelector_button"))).click();// Taps on the menu icon in the app
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.scripps.vcstar.mobile:id/settings"))).click();//Taps on the "Settings" button in the menu
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.scripps.vcstar.mobile:id/aboutApp"))).click();// Taps on the "About VCStar" from the list in the settings page
		
		List<WebElement> listTextView = setEnvo.adir.findElements(By.id("com.scripps.vcstar.mobile:id/footer"));
		for(WebElement e1:listTextView)
		{
			if(e1.getText().equalsIgnoreCase(buildNo))
			{
				System.out.println("The new build has been installed successfully");
			}
		}
		
		// Taps on the "Yes" button for enabling Push notifications 
	}
	@AfterClass
	public void tearDown() 
	{
		setEnvo.adir.quit();
	}
}
