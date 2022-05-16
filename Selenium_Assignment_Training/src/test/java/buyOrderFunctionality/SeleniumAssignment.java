
package buyOrderFunctionality;
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumAssignment {
	public static WebDriver driver= null;
	public static Actions action = null;
	
	@BeforeTest
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		action= new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test(priority = 1)
	public void testLogin()
	{
		try {
		driver.get("http://automationpractice.com/index.php");
		
		//click Signup
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
		WebElement txtbx_username= driver.findElement(By.name("email"));
		txtbx_username.sendKeys("rima321@gmail.com");

		//password is set
		driver.findElement(By.name("passwd")).sendKeys("music1");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		String expected_title= "My account - My Store";
		String actual_title= driver.getTitle();

		//check point
		Assert.assertEquals(expected_title,actual_title);
		}catch(Exception e) {
			Assert.fail("login failed" +e);
		}
	}
	
	@Test(priority = 2)
	public void testSelectTshirt() {
		try {
			Thread.sleep(3000);
			WebElement menu= driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
			action.moveToElement(menu).perform();
			//submenu_tshirts
			driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
			String expected_title = "T-shirts - My Store";
			String actual_title = driver.getTitle();
			Assert.assertEquals(expected_title, actual_title);
			
			}catch(Exception e)
			{
				Assert.fail("product selection failed" +e);
			}
		
	}
	@Test(priority = 3)
	public void testClickMore() {
		try {
			Thread.sleep(3000);
			//clickonmore
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]")).click();
			String expected_title = "Faded Short Sleeve T-shirts - My Store";
			String actual_title = driver.getTitle();
			Assert.assertEquals(expected_title, actual_title);
			
			}catch(Exception e) {
				Assert.fail("click on more failed : "+e);
			}
		
	}
	@Test(priority = 4)
	public void testSetProductDetails() {
		try {
			WebElement txtbox_quantity= driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]"));
			txtbox_quantity.clear();
			txtbox_quantity.sendKeys("2");

			//sizewanted

			driver.findElement(By.xpath("//*[@id=\"group_1\"]")).click();

			driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[3]")).click();

			driver.findElement(By.xpath("//*[@id=\"color_14\"]")).click();
			
			
		}catch(Exception e)
		{
			Assert.fail("adding product details failed" +e);
		}
	}
	
	@Test(priority = 5)
	public void testProductCheckout() {
		try {
			driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();

			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
			String expected_title = "Order - My Store";
			String actual_title = driver.getTitle();
			Assert.assertEquals(expected_title, actual_title);
			
		}catch(Exception e) {
			
			Assert.fail("Product Checkout failed" +e);
			
		}
	}
	
	
	@AfterTest
	public void close() {
		driver.close();
	}



}
