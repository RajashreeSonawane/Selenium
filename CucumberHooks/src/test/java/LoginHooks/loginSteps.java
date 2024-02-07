package LoginHooks;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps
{

	WebDriver driver;
	@Before("@smoke")
	public void browser_setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	@Before(order=0)
	public void setup2()
	{
		System.out.println("I am inside setup2 \n");
	}
	@After(order=1)
	public void teardown()
	{
		System.out.println("I am inside teardown \n");
		//driver.close();
		//driver.quit();
	}
	@After(order=0)
	public void teardown2()
	{
		System.out.println("I am inside teardown2 \n");
	}
	@BeforeStep
	public void beforestep()
	{
		System.out.println("I am inside before step  \n");
	}
	@AfterStep
	public void afterstep()
	{
		System.out.println("I am inside after step  \n");
	}

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("inside step-browser is open");

	}



	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("inside Step - user is on login page");
		driver.navigate().to("https://login.salesforce.com/?locale=in");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		System.out.println("inside step- user enter username and password");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Abc@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Kraj@123");
		Thread.sleep(2000);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		System.out.println("inside step- clicks on login button");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(2000);

	}

	@Then("user should be display my login page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("inside step-should display my login page");

	}

}
