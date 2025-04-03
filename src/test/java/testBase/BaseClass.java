package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
public static AndroidDriver driver;
public Properties prop;
public Logger logger;
public FileReader file;

@BeforeClass
public void setup() throws IOException
{
	//Loading of config.properties file
	file = new FileReader("./src/test/resources/config.properties");
	prop = new Properties();
	prop.load(file);
	
	//Initializing logger *log4j2 setup
	logger = LogManager.getLogger(this.getClass());	
	
	//Setting up desired capabilities for connection
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("appium:platformName", prop.getProperty("platformName"));
	caps.setCapability("appium:devicename", prop.getProperty("deviceName"));
	caps.setCapability("appium:automationName", prop.getProperty("automationName"));
	caps.setCapability("appium:app", prop.getProperty("app"));
	caps.setCapability("appium:apppackage", prop.getProperty("appPackage"));
	caps.setCapability("appium:autoGrantPermissions", true); //To grant permission during runtime
	
	//Initializing AndroidDriver
	driver = new AndroidDriver(URI.create(prop.getProperty("URI")).toURL(),caps);
	
	logger.info("                                                                  ");
	logger.info("                                                                  ");
	
}

public String captureScreen(String tname)
{
	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
	TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
	File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	File targetFile = new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
	
	return targetFilePath;
}

public void tearDown() throws IOException
{
	file.close();
	driver.quit();
}



}
