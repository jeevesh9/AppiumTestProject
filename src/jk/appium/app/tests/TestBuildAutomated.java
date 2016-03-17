package jk.appium.app.tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import jk.appium.app.base.BaseEnvoSetUp;

public class TestBuildAutomated extends BaseEnvoSetUp{

	AndroidDriver andoDriver;

	@BeforeClass
	public void beforeClass() throws MalformedURLException 
	{
		this.andoDriver = getDriver();  
	}
	
	@Test
	public void installTestApk() throws MalformedURLException {
		andoDriver= installTestApp();
		System.out.println("Test app has been installed successfully and launched");
	}

	@AfterClass
	public void afterClass() {
	}

}
