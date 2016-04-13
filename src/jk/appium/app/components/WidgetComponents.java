package jk.appium.app.components;

import org.openqa.selenium.By;

public class WidgetComponents {
	
	/*
	 * Playstore widgets
	 */
	public final By searchFieldControl =By.id("com.android.vending:id/search_box_idle_text");//Id of the search field control 
	public final By searchTextField =By.id("com.android.vending:id/search_box_text_input");//Id of the search field
	public final By listTitleNames =By.id("com.android.vending:id/li_title");//Id for finding list of search results
	public final By listValue=By.xpath("//android.widget.LinearLayout[contains(@resource-id,'bucket_items') and @index='0']");//Xpath for selecting the app from the search results
	
	/*
	 * Test app widgets
     */
	public final By yesBtn =By.name("Yes");//Name of the button on the notifications pop-up
	public final By menuBtn =By.id("com.scripps.vcstar.mobile:id/sectionSelector_button");//Id of the menu button
	public final By settingsBtn =By.id("com.scripps.vcstar.mobile:id/settings");//Id of the settings button
	public final By aboutUsOptn =By.id("com.scripps.vcstar.mobile:id/aboutApp");//Id of the about us option
	public final By footerTextList =By.id("com.scripps.vcstar.mobile:id/footer");//Id of the version text field
	
	public final By installBtn =By.id("com.android.vending:id/buy_button"); //Id of the install button
	public final By acceptBtn =By.id("com.android.vending:id/continue_button"); // Id of the accept button for permissions
	public final By openAppBtn =By.id("com.android.vending:id/launch_button"); //Id of the open button
	public final By uninstallBtn =By.id("com.android.vending:id/uninstall_button"); //Id of the uninstall button
	public final By uninstallOkBtn =By.id("android:id/button1"); //Id of the OK button to confirm uninstallation 
	
	public final By refreshBtn =By.id("com.scripps.vcstar.mobile:id/refresh"); //Id of the refresh button
	public final By timeLineBtn =By.id("com.scripps.vcstar.mobile:id/timeline_settings"); //Id of the timeline button	
	
	

}
