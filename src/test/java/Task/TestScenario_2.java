package Task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestScenario_2  {
       WebDriver driver;
		 	
@BeforeSuite
public void LaunchChrome() {
	   //Launch Browser
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.get( "http://leaftaps.com/opentaps/control/main");
	   driver.manage().window().maximize();
}
			
@Test(description="This method validates the loginpage functionality")
public void testWeb1() {
				
	   // Find Username Webelement located using xpath and value entered
	   WebElement	username=driver.findElement(By.xpath("//input[@id='username']"));
	   username.sendKeys("DemoSalesManager");
		    
	   // Find Password Webelement located using xpath and value entered
	   WebElement password=driver.findElement(By.xpath("//input[@name='PASSWORD']"));
	   password.sendKeys("crmsfa");
		    
	   //Find Submitbutton Webelement located using xpath and click 
	   WebElement Submitbutton=driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
	   Submitbutton.click();
			
	   //Find the CRM /SFA link using linktext locator
	   WebElement crmbutton=driver.findElement(By.linkText("CRM/SFA"));
	   crmbutton.click();
}

@Test(description="This method validates the lead functionality")

public void testleadPage1() {

	   //click lead button
	   WebElement leadsbutton = driver.findElement(By.linkText("Leads"));
	   leadsbutton.click();
		    	
	   //click findleads button
	   WebElement Findleadsbutton = driver.findElement(By.linkText("Find Leads"));
	   Findleadsbutton.click();
		    	
	   //Enter the CompanyName 
	   WebElement Companyname=driver.findElement(By.xpath("//input[@style='width: 212px;'][@name='companyName']"));
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   Companyname.sendKeys("YokeshCN");
		    	
	   //Click leads button
	   WebElement leads=driver.findElement(By.linkText("Find Leads"));
	   leads.click();
	   WebElement showndata = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-companyName']/a"));
	   showndata.click();
}
		    	
@Test(description="This method validates the edit lead functionality")

public void testleadPage3() {
		    		
	   WebElement editbutton=driver.findElement(By.xpath("//a[text()='Edit']"));
	   editbutton.click();
		 
	   //clear company name 
	   WebElement editcompanyname = driver.findElement(By.id("updateLeadForm_companyName"));
	   editcompanyname.clear();
		    	
	   //update company name
	   WebElement updatecompanyname = driver.findElement(By.id("updateLeadForm_companyName"));
	   updatecompanyname.sendKeys("RajCN");
		    	
	   //click update button
	   WebElement updateButton = driver.findElement(By.xpath("//input[@name='submitButton'][@value='Update']"));
	   updateButton.click();
}
		    
@Test(description="This method Check company name and updated company same")

public void testleadPage4() {
		    		
	   WebElement updatedCompanyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
	   String companyName = updatedCompanyName.getText();
	   if (companyName.contains("RajCN")) {
	   System.out.println("Test case passed.");
	   } 
	   else {
	   System.out.println("Test case failed.");
	   }
		    	
}
		    
@AfterSuite
public void closechrome() {
driver.close();
}
}
