package Maven_Scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_Options {
	
	WebDriver driver ;
	@BeforeTest
	public void launch_browser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void dropdown()
	{
		driver.get("https://blazedemo.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		WebElement options = driver.findElement(By.xpath("//form/select[@name='fromPort']"));
		
		Select sl = new Select(options);
		List<WebElement> list = sl.getOptions();
		System.out.println(list.size());
		
		for (int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
		}
	}
	 
	@AfterTest
	public void close_browser()
	{
		driver.close();
	}
  
}
