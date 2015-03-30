import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;

import org.jbehave.core.annotations.Given; 
import org.jbehave.core.annotations.Pending; 
import org.jbehave.core.annotations.Then; 
import org.jbehave.core.annotations.When; 
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver; 

public class MySteps extends JUnitStories{         
	static WebDriver driver;    
	
	@Given("I am in FF")     
	public void invokeBrowser()     {         
		driver = new FirefoxDriver();     
		}         
	
	@Given("I navigate to google")     
	public void navigate()     {         
		driver.get("http://www.google.co.in"); 
		
		}         
	
	@Given("I type jbehave in search field")
	public void search() {
		driver.findElement(By.id("gbqfq")).clear();
	    driver.findElement(By.id("gbqfq")).sendKeys("seleniumhq");
	    driver.findElement(By.id("gbqfb")).click();
	}
	
	@Then("I verify search field")     
	public void verify() throws InterruptedException     {
		// verifying search element in google home page       
		System.out.println(driver.getPageSource().contains("seleniumhq.org"));
		
		assertTrue(driver.findElement(By.linkText("selenium")).isDisplayed()); 
		driver.quit();             
		}  
	
	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
	}
	
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("my.story");
	}

	@Override
	@Test
	public void run() throws Throwable {
		super.run();
	}
	
	public void verifyTextPresent(String value)
	{
	}


	
}