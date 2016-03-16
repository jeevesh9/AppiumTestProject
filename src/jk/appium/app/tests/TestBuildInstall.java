package jk.appium.app.tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import jk.appium.app.base.BaseEnvoSetUp;

public class TestBuildInstall extends BaseEnvoSetUp{

	AndroidDriver andoDriver;

	@Test
	public void installTestApk() throws MalformedURLException {
		andoDriver= installTestApp();
		System.out.println("Test app has been installed successfully and launched");
	}
	@BeforeClass
	public void beforeClass() throws MalformedURLException 
	{
		this.andoDriver = getDriver();  
	}

	@AfterClass
	public void afterClass() {
	}

}
