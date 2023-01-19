package StepDefination;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectStepTestPOM {
	WebDriver driver=null;
	loginPage login;
	@Given("browser is open")
	public void browser_is_open() {
		
		System.out.println("########### POM Project############");
	   System.out.println("inside step-browser is open");
	   String projectPath=System.getProperty("user.dir");
	   System.out.println("Project path is: "+projectPath);
	   System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
	   driver=new ChromeDriver();
	   
	   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	   driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	
	}
	
	

	@And("user is on login page")
	public void user_is_on_login_page() {
	   System.out.println("inside Step - user is on login page");
	   driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username,String password) throws InterruptedException {
	   login=new loginPage(driver);
	   login.enterUsername(username);
	   login.enterPassword(password);
	   Thread.sleep(2000);
	}

	@And("user clicks on login")
	public void clicks_on_login_button(){
		login.clickLogin();
	   
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		login.checkLogOutisDisplayed();
		driver.close();
		driver.quit();
		}
	}
