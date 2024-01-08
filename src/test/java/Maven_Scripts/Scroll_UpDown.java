package Maven_Scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll_UpDown {
	
	WebDriver driver ;
	
	@BeforeTest
	public void launch_browser()
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.silent.Output", "true");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
	}
	
	@Test
	public void scroll_page() throws InterruptedException
	{
		driver.get("https://www.selenium.dev/");
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");  // from up to down
		Thread.sleep(4000);
	
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)"); // From down to up
		Thread.sleep(4000);
		
		WebElement word = driver.findElement(By.xpath("//h2[text()='News']"));
		js.executeScript("arguments[0].scrollIntoView()",word );
		Thread.sleep(4000);
		System.out.println(word.getText());
	}
	
	@AfterTest
	public void close_browser()
	{
		driver.close();
	}
	
	
	
}
