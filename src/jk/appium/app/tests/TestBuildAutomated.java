package jk.appium.app.tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import jk.appium.app.base.BaseEnvoSetUp;
import jk.appium.app.pageobjects.AboutUsPage;
import jk.appium.app.pageobjects.AppNotificationPopUp;
import jk.appium.app.pageobjects.SectionFrontPage;

public class TestBuildAutomated extends BaseEnvoSetUp{

	AndroidDriver andoDriver;
	AboutUsPage abtUs;
	SectionFrontPage secFrnt;
	AppNotificationPopUp appNotify;

	@BeforeClass
	public void beforeClass() throws MalformedURLException 
	{
		this.andoDriver = getDriver();  
	}

	/*
	 * This test is to install the app under test
	 */
	@Test(priority=0)
	public void installTestApk() throws MalformedURLException {
		andoDriver= installTestApp();
		System.out.println("Test app has been installed successfully and launched");
	}

	/*
	 * This test is to enable the notifications pop-up
	 */
	@Test(priority=1)
	public void notificationEnable()
	{
		appNotify=new AppNotificationPopUp(andoDriver);
		appNotify.acceptNotifications();
	}

	/*
	 * This test is to verify if the installed apps version is similar to that of app under test
	 */
	@Test(priority=3)
	public void versionCheck()
	{
		abtUs=new AboutUsPage(andoDriver);
		abtUs.verifyAppVersion();
	}


	/* 
	 * This test is to check if the icons and buttons are visible on the section front
	 */
	@Test(priority=2)
	public void sectionFrontCheck() {
		secFrnt=new SectionFrontPage(andoDriver);
		secFrnt.verifyMenuBtn();
		secFrnt.verifyRefreshBtn();
		secFrnt.verifyTimeLineBtn();
	}
	
	@AfterClass
	public void afterClass() {
		andoDriver.quit();
	}

}
