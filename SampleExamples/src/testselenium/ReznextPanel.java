package testselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReznextPanel {

	public static void main(String[] args) {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sahana.siddaraju\\Desktop\\Back up\\Selenium Jars\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//Base url of test reznext
		String baseUrl = "http://redapptest.azurewebsites.net";
		//
		driver.get(baseUrl);
	}

}
