package testselenium;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReznextWebsiteDemo {

	public static void main(String[] args) {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sahana.siddaraju\\Desktop\\Back up\\Selenium Jars\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.reznext.com");
		
		List<String> url = new ArrayList<>();
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		for(WebElement webele : ele){
			url.add(webele.getAttribute("href"));
		}
		System.out.println("URLs count "+ ele.size());
		
		int invalidLinksCount = 0;
		int invalidbrokenlinks = 0;
		for(String a: url){
			
			if (a != null && !a.contains("javascript")){
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(a);
			
			try{
				HttpResponse response = client.execute(request);
				if (response.getStatusLine().getStatusCode() != 200)
				{
					invalidLinksCount++;
				}
				else 
					if (response.getStatusLine().getStatusCode() == 400)
					{
						invalidbrokenlinks++;
					}
					else {
						System.out.println(a+"---------------pass");
					}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
		}
		System.out.println(invalidLinksCount);
		
	}

}
