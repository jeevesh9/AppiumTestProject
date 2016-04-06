package jk.appium.app.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

import io.appium.java_client.android.AndroidDriver;

public class SectionFrontPage {
	
	private AndroidDriver andoDriver;
	
	private By menuBtn =By.id("com.scripps.vcstar.mobile:id/sectionSelector_button");
	private By refreshBtn =By.id("com.scripps.vcstar.mobile:id/refresh");
	private By timeLineBtn =By.id("com.scripps.vcstar.mobile:id/timeline_settings");	
	
	WebDriverWait waitfor;

	public SectionFrontPage(AndroidDriver andoDriver)
	{
		this.andoDriver=andoDriver;
		waitfor = new WebDriverWait(andoDriver, 150);
	}
	
	public void verifyMenuBtnVisible()
	{
		waitfor.until(ExpectedConditions.presenceOfElementLocated(menuBtn));// Checks if the menu icon is available in the app
		assertTrue(andoDriver.findElement(menuBtn).isDisplayed());
	}

	public void verifyRefreshBtnVisible()
	{
		waitfor.until(ExpectedConditions.presenceOfElementLocated(refreshBtn));// Checks if the refresh icon is available in the app
		assertTrue(andoDriver.findElement(refreshBtn).isDisplayed());		
	}

	public void verifyTimeLineBtnVisible()
	{
		waitfor.until(ExpectedConditions.presenceOfElementLocated(timeLineBtn));// Checks if the refresh icon is available in the app
		assertTrue(andoDriver.findElement(timeLineBtn).isDisplayed());
	}
	
	public void verifyMenuBtnClickable()
	{
		waitfor.until(ExpectedConditions.elementToBeClickable(menuBtn)).click();// Checks if the menu icon is clickable in the app
		assertTrue(andoDriver.findElement(menuBtn).isDisplayed());
	}
	
	public void verifyRefreshBtnClickable()
	{
		waitfor.until(ExpectedConditions.elementToBeClickable(refreshBtn)).click();// Checks if the refresh icon is available in the app
		assertTrue(andoDriver.findElement(refreshBtn).isDisplayed());		
	}
}
