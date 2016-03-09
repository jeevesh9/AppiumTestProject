package jk.appium.app.tests;


public class DeviceProperties  {
	//List of device names
	String S3= "4dfca3c836d9504f";
	String S4= "4d00bf09bfd240d9";
	String S5= "765fba6d";
	String N4= "01ba858162dda5a2";

	//List of device os
	String S3os= "4.3";
	String S4os= "5.0.1";
	String S5os= "4.4.2";
	String N4os= "5.1.1";

	public enum DevicName{
		S3("4dfca3c836d9504f"),S4("4d00bf09bfd240d9"),N4("01ba858162dda5a2");

		private String value;
		private DevicName(String value)
		{
			this.value=value;
		}
		public String getValue() {
			return value;
		}
	}
}
