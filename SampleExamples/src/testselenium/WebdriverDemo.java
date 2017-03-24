package testselenium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.sun.jna.platform.FileUtils;

public class WebdriverDemo {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sahana.siddaraju\\Desktop\\Back up\\Selenium Jars\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.seleniumeasy.com");
		
		File name1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(name1, new File("C:\\Users\\sahana.siddaraju\\Desktop\\Back up\\Selenium Jars\\Sikuli Images\\Reznext Images\\screenshot.png"));
		//edit-search-block-form--2
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.id("edit-search-block-form--2")));
		act.click().build().perform();
		act.sendKeys("hello").build().perform();
		
		
		List<String>url=new ArrayList<>();
		
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		for(WebElement webele: ele){
			
			url.add(webele.getAttribute("href"));
		}
		System.out.println(ele.size());
		int invalidLinksCount=0;
		for(String a:url)
		{
	 
			
			if (a != null && !a.contains("javascript"))
		{
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(a);
		try {
			HttpResponse response = client.execute(request);
			// verifying response code and The HttpStatus should be 200 if not,
			// increment invalid link count
			////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
			if (response.getStatusLine().getStatusCode() != 200)
			{
				invalidLinksCount++;
			}
			else
			{
				System.out.println(a+"---------------pass");
				invalidLinksCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		}
		System.out.println(invalidLinksCount);
	}

}
