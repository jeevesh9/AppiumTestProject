package jk.appium.app.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AppNotificationPopUp {
	
	private AndroidDriver andoDriver;
	
	private By yesBtn =By.name("Yes");

	WebDriverWait waitfor;

	public AppNotificationPopUp(AndroidDriver andoDriver)
	{
		this.andoDriver=andoDriver;
		waitfor = new WebDriverWait(andoDriver, 150);
	}
	
	public void acceptNotifications()
	{
		waitfor.until(ExpectedConditions.elementToBeClickable(yesBtn)).click();// Taps on the "Yes" button for enabling Push notifications
		System.out.println("The push notifications has been enabled");
	}
}
