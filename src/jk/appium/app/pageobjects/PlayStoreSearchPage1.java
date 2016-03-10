package jk.appium.app.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class PlayStoreSearchPage1 {
	
	private AndroidDriver andodriver;
	private By searchFieldControl =By.id("com.android.vending:id/search_box_idle_text");
	private By searchTextField =By.id("com.android.vending:id/search_box_text_input");
	private By listTitleNames =By.id("com.android.vending:id/li_title");
	private By uninstallBtn =By.id("com.android.vending:id/uninstall_button");
	private By acceptBtn =By.id("android:id/button1");
	
	WebDriverWait waitfor;

	public PlayStoreSearchPage1(AndroidDriver andodriver)
	{
		this.andodriver=andodriver;
		waitfor = new WebDriverWait(andodriver, 150);
	}

	public void tap_inputText() 
	{
		System.out.println("Tapping on the search field & entering the text");
		waitfor.until(ExpectedConditions.presenceOfElementLocated(searchFieldControl)).click();
		waitfor.until(ExpectedConditions.presenceOfElementLocated(searchTextField)).sendKeys("VCStar");

		String adbpath ="C:\\Android\\android-sdk-windows\\platform-tools\\adb.exe";                // Passing the actual path for adb in processbuilder
		ProcessBuilder pb = new ProcessBuilder(adbpath,"shell", "input", "keyevent", "66");			// Parameters to run the adb command to tap enter on softkeyboard
		try
		{
			Process pc = pb.start();
			pc.waitFor();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void verifyAppList()
	{
		String expectedAppName ="Ventura County Star";
		List<WebElement> playCardsTitles = andodriver.findElements(listTitleNames); // Adding the title names of the search results to the list
		for(WebElement e : playCardsTitles)
		{
			if(e.getText().equalsIgnoreCase(expectedAppName))  // Comparing the name of the title with the app name that we want to install
			{
				System.out.println("Found the app in PlayStore now performing actions");
				e.click();
				waitfor.until(ExpectedConditions.visibilityOfElementLocated(uninstallBtn)).click(); // Taps on Uninstall button
				waitfor.until(ExpectedConditions.visibilityOfElementLocated(acceptBtn)).click(); // Taps on "OK" from the alert
			}
			else
			System.out.println("Could not find the app in PlayStore");
		}
	}
}
