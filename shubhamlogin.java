package step;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class shubhamlogin {
	
	WebDriver driver=new ChromeDriver();
	

	@Given("browser is open new")
	public void browser_is_open_new() {
	    System.out.println("inside step-browser is open new");
		System.setProperty("webdriver.Chrome.driver","/home/pratik/eclipse-workspace/cucumbe/driver/chromedriver");
		  // driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
            @After
        	public void takescreenshot(Scenario scenario)
        	{
        	boolean failed=scenario.isFailed();
//        		System.out.println("is Failed" +failed);
        		if(failed)
        		{

        			TakesScreenshot shubham=(TakesScreenshot) driver;
        			byte[] src=shubham.getScreenshotAs(OutputType.BYTES);
        			scenario.attach(src, "image/png","screenshot");
        			//driver.close();
        			//driver.quit();
        		}
        	
        	}
//        	public void teardown() {
//    		System.out.println("===========bye============");
//    		driver.close();
//    		driver.quit();
 	//}

        	@BeforeStep
        	public  void beforesteps(Scenario scenario )
        	{
        		TakesScreenshot ts=(TakesScreenshot) driver;

        		byte[] src =ts.getScreenshotAs(OutputType.BYTES);
        		scenario.attach(src,"image/png","screenshot");

        		System.out.println("i am in before steps=====");
        		
        	}
        	@AfterStep
        	
        	public void aftersteps(Scenario scenario)
        	{
        		TakesScreenshot ts=(TakesScreenshot) driver;

        		byte[] src =ts.getScreenshotAs(OutputType.BYTES);
        		scenario.attach(src,"image/png","screenshot");
        		System.out.println(" i am in aftersteps=====");
    
        		
        	}
        	
        	public void teardown() {
        		System.out.println("===========bye============");
        		driver.close();
        		driver.quit();
        	}

	@And("user is login page new")
	public void user_is_login_page_new() {
	   System.out.println("inside step-user is login page new");
	   driver.navigate().to("https://www.actitime.com/free-online-trial");
	}

	@When("^user enters (.*) and (.*) and (.*)$")
	public void user_enters_firstname_and_lastname_and_email(String firstname,String lastname,String email ) {
	  System.out.println("inside step-user enters username and password valid");
	  
	  

	  driver.findElement(By.id("FirstName")).sendKeys(firstname);
	  driver.findElement(By.id("LastName")).sendKeys(lastname);
	  driver.findElement(By.id("Email")).sendKeys(email);
	}

@And("user click on login button")
public void user_click_on_login_button() {
   System.out.println("inside step-user click on login button");
   driver.findElement(By.id("confirm-button")).click();
}


	@Then("user is navigated next page")
	public void user_is_navigated_next_page() {
	    System.out.println("inside step-user is navigated next page");
   
	}




}
