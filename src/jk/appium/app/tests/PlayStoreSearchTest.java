package jk.appium.app.tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import jk.appium.app.base.BaseEnvoSetUp;
import jk.appium.app.pageobjects.PlayStoreSearchPage;

public class PlayStoreSearchTest extends BaseEnvoSetUp{


	@BeforeClass
	public void setUp() throws MalformedURLException
	{
		andoDriver = setCapabilities();
	}
	
	@Test
	public void verifyAppSearchList()
	{
		System.out.println("Searching the app in PlayStore...");
		PlayStoreSearchPage playsrch=new PlayStoreSearchPage(andoDriver);
		playsrch.tap_inputText();
		playsrch.verifyAppList();
	}
	
	/*@AfterClass
	public void tearDown() 
	{
		andodriver.quit();
	}*/
}