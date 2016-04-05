package jk.appium.app.tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import jk.appium.app.base.BaseEnvoSetUp;
import jk.appium.app.pageobjects.AppNotificationPopUp;
import jk.appium.app.pageobjects.PlayStoreInstallPage;
import jk.appium.app.pageobjects.PlayStoreSearchPage;

public class PlayStoreInstallTest extends BaseEnvoSetUp{
	AndroidDriver andoDriver;
	BaseEnvoSetUp setEnvo;
	PlayStoreSearchPage playsrch;
	PlayStoreInstallPage inst;
	AppNotificationPopUp notify;
	
	@BeforeClass
	public void setUp() throws MalformedURLException
	{		
		andoDriver = setCapabilities();
		this.andoDriver= getDriver();
	}
	
	@Test(priority=0)
	public void verifyAppSearchList()
	{
		System.out.println("Searching the app in PlayStore...");
		playsrch=new PlayStoreSearchPage(andoDriver);
		playsrch.tapInputText();
		playsrch.verifyAppList();
	}
	
	@Test(priority=1)
	public void verifyFreshInstall() {

		inst=new PlayStoreInstallPage(andoDriver);
		inst.installUninstallApp();
	}
	
	@Test(priority=2)
	public void acceptNotificationsPopUp()
	{
		notify=new AppNotificationPopUp(andoDriver);
		notify.acceptNotifications();
	}
	
	@AfterClass
	public void tearDown() 
	{
		andoDriver.quit();
	}
}
