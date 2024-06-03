package Task;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;



public class TestScenario_3 {
 
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
       WebElement crmbutton=driver.findElement(By.linkText("CRM/SFA"));
       crmbutton.click();
   
       //title of homepage
       String HomepageTitle=driver.getTitle();
       System.out.println("LeafTapspage Title" + HomepageTitle);
}
    
@Test(description="This method validates the Homepage functionality")
public void testWeb3() {
   
	   //Find the element for DemoSalesManager 
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'DemoSalesManager')]"))); 
       WebElement text = driver.findElement(By.xpath("//b[contains(text(),'DemoSalesManager')]"));
     
       //the name is equals to DemoSalesManager the test case should be passed or else it should failed
       String UsernameText=text.getText();
       if(UsernameText.equals("DemoSalesManager"))
	   {
	   System.out.println("Test cases pass");
	   }
	   else {
	   System.out.println("Test cases fail");
	   }
}
   
@Test(description="Create lead functionality")
public void testWebHomePage1() {
	
	   //click lead button
       WebElement createlinkbutton=driver.findElement(By.linkText("Create Lead"));
       createlinkbutton.click();
		
	   //enter first name
	   WebElement companyname=driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']"));
	   String companyName="YokeshRajECND";
	   companyname.sendKeys(companyName);
		
	   //enter first name
	   WebElement firstname=driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']"));
	   firstname.sendKeys("Yokesh Raj");
		
	   //enter last name
	   WebElement lastname=driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']"));
	   lastname.sendKeys("E");
		
	   //enter phone number
	   WebElement phonenumber=driver.findElement(By.xpath("//input[@id='createLeadForm_primaryPhoneNumber']"));
	   phonenumber.sendKeys("9486201413");
		
	   //click create leadbutton
	   WebElement leadbutton=driver.findElement(By.xpath("//input[@name='submitButton']"));
	   leadbutton.click();
		
       //Click leads button
	   WebElement leads1=driver.findElement(By.linkText("Find Leads"));
	   leads1.click();
		
	   //Enter the CompanyName 
		
	   WebElement Company=driver.findElement(By.xpath("//input[@name='companyName'][@style='width: 212px;']"));
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   Company.sendKeys("YokeshRajECND");
	   WebElement showndata = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-companyName']/a"));
	   showndata.click();
}

@Test(description="This method validates the delete lead functionality")
public void testleadPage3() {
			 
	   WebElement deletebutton=driver.findElement(By.xpath("//a[text()='Delete']"));
	   deletebutton.click();
}
	
@Test(description="This method validates the No records to display lead functionality")

public void testleadPage4() {

	   //click findleads button
	   WebElement Findleadsbutton1 = driver.findElement(By.linkText("Find Leads"));
	   Findleadsbutton1.click();
			    
	   //Enter the CompanyName 
	   WebElement Companyname1=driver.findElement(By.xpath("//input[@style='width: 212px;'][@name='companyName']"));
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   Companyname1.sendKeys("YokeshRajECND");
				
	   //Click leads button
	   WebElement leads1=driver.findElement(By.linkText("Find Leads"));
	   leads1.click();
				
	   //No records to display message
	   WebElement noRecordsText = driver.findElement(By.xpath("//div[@class='x-paging-info']"));
	   String noRecordsMessage = noRecordsText.getText();
		        
	   //No records to display 
	   if (noRecordsMessage.equals("No records to display")) {
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
