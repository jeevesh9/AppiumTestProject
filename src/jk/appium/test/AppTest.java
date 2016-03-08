package jk.appium.test;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import jk.appium.deviceproperties.EnvoSetUp;

public class AppTest {


	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		EnvoSetUp setEnvo=new EnvoSetUp();		
		setEnvo.setCapabilities();


		//		WebElement splashProg=setEnvo.adir.findElement(By.id("android:id/progress"));
		//		WebDriverWait wait = new WebDriverWait(setEnvo.adir,10);
		//		wait.until(ExpectedConditions.visibilityOf(splashProg));

		Thread.sleep(30000);

		// Using AndroidElement also we can do our operations
		/*AndroidElement Btn1 = (AndroidElement) adir.findElement(By.name("Yes"));
	    Btn1.click();*/
		/*AndroidElement ImageButton = (AndroidElement) adir.findElement(By.id("com.mylocaltv.kmgh:id/sectionSelector_button"));
	    ImageButton.click();*/

		//AndroidElement splashProg=(AndroidElement) setEnvo.adir.findElement(By.id("android:id/progress"));
//		Wait<AndroidDriver> wait = new FluentWait<AndroidDriver>(setEnvo.adir).withTimeout(60,TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));

		//setEnvo.adir.findElement(By.id("android:id/button1")).click();
		setEnvo.adir.findElement(By.name("Yes")).click();
		setEnvo.adir.findElement(By.id("com.whiz.paysonroundup:id/sectionSelector_button")).click();

		List<WebElement> seclist = setEnvo.adir.findElements(By.id("com.whiz.paysonroundup:id/label"));
		System.out.println(seclist.size());  
		for(WebElement a:seclist)
		{
			if(a.getText().equalsIgnoreCase("Top Stories"))
			{
				System.out.println(a.getText());
			}
			else
			{
				a.click();
				Thread.sleep(2000);
				setEnvo.adir.navigate().back();
				setEnvo.adir.findElement(By.id("com.whiz.paysonroundup:id/sectionSelector_button")).click();
			}
			Thread.sleep(2000);
		}
		Thread.sleep(1000);
		setEnvo.adir.quit();
	}
}