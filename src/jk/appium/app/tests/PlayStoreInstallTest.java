package jk.appium.app.tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import jk.appium.app.base.BaseEnvoSetUp;
import jk.appium.app.pageobjects.PlayStoreInstallPage;
import jk.appium.app.pageobjects.PlayStoreSearchPage;

public class PlayStoreInstallTest extends BaseEnvoSetUp{
	BaseEnvoSetUp setEnvo;
	PlayStoreSearchPage playsrch;
	PlayStoreInstallPage inst;
	
	@BeforeClass
	public void setUp() throws MalformedURLException
	{		
		andoDriver = setCapabilities();
		this.andoDriver= getDriver();
	}
	
	@Test
	public void verifyAppSearchList()
	{
		System.out.println("Searching the app in PlayStore...");
		playsrch=new PlayStoreSearchPage(andoDriver);
		playsrch.tap_inputText();
		playsrch.verifyAppList();
	}
	
	@Test
	public void verifyFreshInstall() {

		inst=new PlayStoreInstallPage(andoDriver);
		inst.install_uninstallApp();
	}
	
	
	/*@AfterClass
	public void tearDown() 
	{
		andoDriver.quit();
	}*/
}
