package jk.appium.app.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;

public class PlayStoreInstallPage {
	
	private AndroidDriver andoDriver;
	
	private By installBtn =By.id("com.android.vending:id/buy_button"); //Id of the install button
	private By acceptBtn =By.id("com.android.vending:id/continue_button"); // Id of the accept button for permissions
	private By openAppBtn =By.id("com.android.vending:id/launch_button"); //Id of the open button
	private By uninstallBtn =By.id("com.android.vending:id/uninstall_button"); //Id of the uninstall button
	private By uninstallOkBtn =By.id("android:id/button1"); //Id of the OK button to confirm uninstallation 
	
	WebDriverWait waitfor;

	public PlayStoreInstallPage(AndroidDriver andoDriver)
	{
		this.andoDriver=andoDriver;
		waitfor = new WebDriverWait(this.andoDriver, 150);
	}

	public void install_uninstallApp()
	{
		if(IsTestElementPresent()==true)
		{
			andoDriver.findElement(uninstallBtn).click(); // Taps on Uninstall button
			waitfor.until(ExpectedConditions.visibilityOfElementLocated(uninstallOkBtn)).click(); // Taps on "OK" from the alert
			System.out.println("Un-installation was successfull procceding with Installation");
			install();
		}
		else
		{
			install();
		}
	}
	
	//Method that checks if an element is present or not
		public boolean IsTestElementPresent()
		{
			try
			{
				andoDriver.findElement(uninstallBtn);// To check if the Uninstall button/element is present or not
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
			waitfor.until(ExpectedConditions.elementToBeClickable(installBtn)).click();// Taps on the Install button
			waitfor.until(ExpectedConditions.elementToBeClickable(acceptBtn)).click();//Taps on the "Accept" button from the alert
			waitfor.until(ExpectedConditions.elementToBeClickable(openAppBtn)).click();// Taps on the Open button to launch the app
			System.out.println("Installation was successfull");
		}
}