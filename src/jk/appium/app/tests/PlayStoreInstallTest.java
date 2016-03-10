package jk.appium.app.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import jk.appium.app.base.BaseEnvoSetUp;
import jk.appium.app.pageobjects.PlayStoreInstallPage;

public class PlayStoreInstallTest extends BaseEnvoSetUp {

	private AndroidDriver andoDriver;
	PlayStoreInstallPage inst;

	@BeforeClass
	public void setUp() {

	}

	@Test
	public void verifyFreshInstall() {

		inst=new PlayStoreInstallPage(andoDriver);
		inst.install_uninstallApp();
	}


	@AfterClass
	public void tearDown() {
	}

}
