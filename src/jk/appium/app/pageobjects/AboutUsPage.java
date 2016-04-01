package jk.appium.app.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AboutUsPage {
	private AndroidDriver andoDriver;
	
	private By menuBtn =By.id("com.scripps.vcstar.mobile:id/sectionSelector_button");
	private By settingsBtn =By.id("com.scripps.vcstar.mobile:id/settings");
	private By aboutUsOptn =By.id("com.scripps.vcstar.mobile:id/aboutApp");
	private By footerTextList =By.id("com.scripps.vcstar.mobile:id/footer");
	
	String buildNo = "4.2.123.189";
	
	WebDriverWait waitfor;

	public AboutUsPage(AndroidDriver andoDriver)
	{
		this.andoDriver=andoDriver;
		waitfor = new WebDriverWait(andoDriver, 150);
	}
	
	public void verifyAppVersion()
	{
		waitfor.until(ExpectedConditions.elementToBeClickable(menuBtn)).click();// Taps on the menu icon in the app
		waitfor.until(ExpectedConditions.elementToBeClickable(settingsBtn)).click();// Taps on the "Settings" button in the menu
		waitfor.until(ExpectedConditions.elementToBeClickable(aboutUsOptn)).click();// Taps on the "About VCStar" from the list in the settings page
		
		List<WebElement> listTextView = andoDriver.findElements(footerTextList);
		for(WebElement e1:listTextView)
		{
			if(e1.getText().equalsIgnoreCase(buildNo))
			{
				System.out.println("The new build has been installed successfully");
			}
		}
	}

}
