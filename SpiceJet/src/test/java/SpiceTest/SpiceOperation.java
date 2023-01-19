package SpiceTest;
import java.io.File;  

import java.io.FileInputStream;  

import java.io.IOException;  

import java.util.concurrent.TimeUnit;  

import org.apache.logging.log4j.LogManager;  

import org.apache.logging.log4j.Logger;  

import org.apache.poi.hssf.usermodel.HSSFSheet;  

import org.apache.poi.hssf.usermodel.HSSFWorkbook;  

import org.openqa.selenium.By;  

import org.openqa.selenium.JavascriptExecutor;  

import org.openqa.selenium.WebDriver;  

import org.openqa.selenium.WebElement;  

import org.openqa.selenium.chrome.ChromeDriver;  

import org.testng.annotations.AfterTest;  

import org.testng.annotations.BeforeTest;  

import org.testng.annotations.Test;  

 

public class SpiceOperation
{
static Logger log =LogManager.getLogger(SpiceOperation.class); 	  

public String LoginUrl ="https://www.spicejet.com";  

String driverpath ="C:\\Users\\rajashrees\\Desktop\\Seljars\\chromedriver_win32 (3)//chromedriver.exe"; 

String driverName = "webdriver.chrome.driver";  

public WebDriver driver;  

 

@BeforeTest  

public void Chrome()  

{	  

System.setProperty(driverName,driverpath);  

driver= new ChromeDriver();				  

driver.manage().window().maximize();     

log.debug("Open the SpiceJet Url'");     

driver.get(LoginUrl);  

}	  

 

@Test(priority = 0)  

 

public void booking() 

{  

driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);  

log.debug("Click on 'Book'");  

log.debug("Click on 'Flights'");  

 //driver.findElement(By.xpath("//body/div[18]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[2]")).click(); 

log.debug("Click on 'Round tip'");  

//driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();   

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]")).click(); 

 

}  

 

@Test(priority = 1)  

 

public void City() throws IOException, InterruptedException 

{  

driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);  

log.debug("Copy value into excel file ");  

File City = new File("C:\\Users\\Dell\\Desktop\\Selenium\\Spicejet.xls");//Excel file path  

FileInputStream excel =new FileInputStream(City);  

HSSFWorkbook Book =new HSSFWorkbook(excel);	  

HSSFSheet Sheet1 = Book.getSheetAt(0);  

log.debug("Departure and Arrival Cities");  

String DepartureCity =Sheet1.getRow(1).getCell(0).getStringCellValue();  

Thread.sleep(2000); 

String ArrivalCity =Sheet1.getRow(1).getCell(1).getStringCellValue();  

log.debug("Click on 'Departure city' and put value in it");  

WebElement DepCity= driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")); 	  

DepCity.click(); 

Thread.sleep(2000); 

DepCity.sendKeys(DepartureCity);  

log.debug("Selecting the Deparature city");  

//driver.findElement(By.linkText("Pune (PNQ)")).click();	  

log.debug("Click on 'Arrival city' and put value in it");  

WebElement ArrCity= driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[3]/div[1]/div[2]/input[1]")); 	  

ArrCity.click();  

ArrCity.sendKeys(ArrivalCity);  

log.debug("Selecting the Arrival city");  

//driver.findElement(By.linkText("Mumbai (BOM)")).click();  

}  

 

 

@Test(priority = 2)  

 

public void InsertDateValue() throws InterruptedException 

{  

log.debug("Selecting DepartDate :Sept-14/09/2022");  

  

log.debug("click on Arrival city");  

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]/*[1]")).click(); 

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]")).click(); 

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[3]/div[3]/div[1]")).click(); 

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[1]")).click(); 

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[1]/*[1]")).click(); 

log.debug("click 'Next logo '>''button");  

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[4]/div[1]/div[3]/div[2]/div[6]/div[1]")).click(); 

Thread.sleep(2000); 

log.debug("Selecting ArrivalDate :Nov-10/12/2022");  

 

}  

 

@Test(priority = 3)  

public void Passengers() throws InterruptedException  

{  

driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);  

log.debug("Click on Passengers");  

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/div[2]/*[1]")).click(); 

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]")).click();  

log.debug("Click on Adult and select '2' Adult");  

Thread.sleep(2000); 

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]")).click(); 

 log.debug("Click on Child and select '1' child");  

//driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")).click();  

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]")).click(); 

}  

 

@Test(priority = 4)  

public void Curr() throws InterruptedException  

{  

driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);  

log.debug("Click on Currency");  

Thread.sleep(2000); 

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[5]/div[2]/div[1]/div[1]")).click(); 

log.debug("Select the 'INR' currency");  

 driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[5]/div[2]/div[1]/div[2]/div[1]")).click(); 

}  

 

@Test(priority = 5)  

public void Search()  

{  

driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);  

String HomePage= driver.getTitle();  

log.debug("Click on 'SEARCH'");  

driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[7]/div[2]/div[1]")).click(); 

log.debug("Verify the navigate to ");  

if(HomePage!= LoginUrl)  

{  

System.out.println("Successfully Navigate to SearchPage");  

}  

else 

{  

System.out.println("Unsuccessfully Navigate to page");  

}  

}  

 

@Test(priority = 6)  

public void Scroll()  

{  

driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);  

log.debug("Scroll To checkbox");  

JavascriptExecutor jse = (JavascriptExecutor)driver;  

jse.executeScript("window.scrollBy(0,850)");  

log.debug("Unchecked the box");  

//driver.findElement(By.xpath("//*[@id=\"ControlGroupSelectView_ContactInputGSTViewSelectView_CheckBoxGST\"]")).click();  

}  

 

@AfterTest  

public void Close() 

{  

driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);  

log.debug("Broswer Close");  

driver.close();  

}  

} 