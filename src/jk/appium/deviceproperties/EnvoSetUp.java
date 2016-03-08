package jk.appium.deviceproperties;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class EnvoSetUp {
	public AndroidDriver adir;
	DesiredCapabilities capabilities= new DesiredCapabilities();;

	public void setCapabilities() throws MalformedURLException{

		//	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		//	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 4");
		//	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
		//	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"4dfca3c836d9504f");
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,"com.android.vending");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.android.vending.AssetBrowserActivity");
		capabilities.setCapability("appiumVersion", "1.4.16.1");
		adir =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	
	}

	public void installTestApp() throws MalformedURLException{
		File classpathRoot = new File("F:/TestWorkSpace/Appium_Test");
		File appDir = new File(classpathRoot, "/apk");
		File app = new File(appDir, "VCStar.apk");
		capabilities.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		adir =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	
	}
}
