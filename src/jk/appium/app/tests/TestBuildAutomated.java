package jk.appium.app.tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import jk.appium.app.base.BaseEnvoSetUp;
import jk.appium.app.pageobjects.AboutUsPage;

public class TestBuildAutomated extends BaseEnvoSetUp{

	AndroidDriver andoDriver;
	AboutUsPage abtUs;

	@BeforeClass
	public void beforeClass() throws MalformedURLException 
	{
		this.andoDriver = getDriver();  
	}
	
	@Test(priority=0)
	public void installTestApk() throws MalformedURLException {
		andoDriver= installTestApp();
		System.out.println("Test app has been installed successfully and launched");
	}

	@Test(priority=1)
	public void versionCheck()
	{
		abtUs=new AboutUsPage(andoDriver);
		abtUs.verifyAppVersion();
	}
	
	@AfterClass
	public void afterClass() {
	}

}
