package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {

	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty(){
		configreader = new ConfigReader();
		prop = configreader.init_prop();
	}
	
	@Before(order = 1)
	public void launchBrowser(){
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browserName);
	}
	
	@After(order =0)
	public void quit(){
		driver.quit();
	}
	
	@After(order =1)
	public void tearDown(Scenario scenario){
		if(scenario.isFailed()){
			//takeScreenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}
