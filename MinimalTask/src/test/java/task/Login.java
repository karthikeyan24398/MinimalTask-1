package task;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	WebDriver driver =null;
	@Test(priority =1)
	public void login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://minimals.cc/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Login")).click();		
		WebElement email = driver.findElement(By.id(":r28:"));
		email.sendKeys("demo@minimals.cc");		
		WebElement password = driver.findElement(By.id(":r29:"));
		password.sendKeys("demo1234");
		WebElement login = driver.findElement(By.id(":r2a:"));
		login.click();
	}
	
	
	public void billingCheck() {
		WebElement user = driver.findElement(By.xpath("//span[text() = 'user']"));
		user.click();
		driver.findElement(By.xpath("//span[text() = 'account']")).click();
		
		driver.findElement(By.xpath("//button[text() = 'Billing']")).click();
		
		driver.findElement(By.xpath("//button[text() = 'Jayvion Simon']")).click();
		driver.findElement(By.xpath("(//h6[text() = 'Deja Brady'])[2]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(), '5678')]")).click();
		
		driver.findElement(By.xpath("//h6[contains(text(), '1234')]")).click();
		driver.findElement(By.xpath("(//h6[contains(text(), '1234')]/following-sibling::button)[2]")).click();
		
	}
	
	
	@Test(priority =3)
	public void search() {
		driver.findElement(By.xpath("//span[text() = 'order']")).click();
		driver.findElement(By.xpath("//span[text() = 'list']")).click();
		WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder = 'Search customer or order number...']"));
		searchInput.sendKeys("cor");
		searchInput.sendKeys(Keys.ENTER);
		String actual = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]/div[2]/span[1]")).getText();
		
			String expected = "Cortez Herring";
			
			Assert.assertEquals(actual,expected );
			
		
		
	}
	
	
}
