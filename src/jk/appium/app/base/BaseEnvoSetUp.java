package jk.appium.app.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseEnvoSetUp {

	private static AndroidDriver andoDriver;

	DesiredCapabilities capabilities= new DesiredCapabilities();

	public AndroidDriver setCapabilities() throws MalformedURLException {

		//	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		//	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 4");
		//	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
		//	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"4dfca3c836d9504f");
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.vending");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.vending.AssetBrowserActivity");
		capabilities.setCapability("appiumVersion", "1.4.16.1");
		return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	public AndroidDriver installTestApp() throws MalformedURLException{
		File classpathRoot = new File("F:/TestWorkSpace/Appium_Test");
		File appDir = new File(classpathRoot, "/apk");
		File app = new File(appDir, "VCStar.apk");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"4dfca3c836d9504f");
		capabilities.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.whiz.activity.SplashScreen");
		return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	
	}

	public AndroidDriver getDriver() throws MalformedURLException
	{
		/*if(andoDriver==null)
		{
			return andoDriver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		}*/
		return andoDriver;
		
	}

	public void setDriver(AndroidDriver andoDriver)
	{
		this.andoDriver=andoDriver;
	}
}
