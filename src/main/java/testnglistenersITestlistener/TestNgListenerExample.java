package testnglistenersITestlistener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListeners.class)

public class TestNgListenerExample {
	
	WebDriver driver;
	
@Test	
public void tittleTest() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
    String title = driver.getTitle();
    Assert.assertEquals(title, "OrangeHRM");
    
    driver.quit();
    
}






}
