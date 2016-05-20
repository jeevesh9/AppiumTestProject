package jk.appium.app.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.android.AndroidDriver;

public class ValidateElement {
	
	private AndroidDriver andoDriver;

	public ValidateElement(AndroidDriver andoDriver)
	{
		this.andoDriver=andoDriver;
	}

	/*
	 * This method checks if an element is present or not
	 */
	public boolean isTestElementPresent(By locator) 
	{
		try
		{
			andoDriver.findElement(locator);
			return true;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}
}
