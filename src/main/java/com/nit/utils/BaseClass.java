package com.nit.utils;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties p;
	public static org.slf4j.Logger log;
	
		  @BeforeClass(groups={"sanity","Regeression","master"})
		  @Parameters({"browser","os"})
		  public void openBrowser(String browser, String os) throws MalformedURLException, Exception {
		     FileInputStream fis = new FileInputStream("G:\\WorkSpeace\\seleniunm\\suresh715\\pratice\\HybridFrameWork\\src\\main\\resources\\config\\global.properties");
		      p = new Properties();
		      p.load(fis);
		      log = LoggerFactory.getLogger(getClass());
		      PropertyConfigurator.configure("src/main/resources/config/log4j.properties");
		      log.info("Logger setUp is ready");
		      log.info("Properties File SetUp also ready");
		      
		    
		 //seting webDrivr
				if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
					
					DesiredCapabilities cap=new DesiredCapabilities();
					//os
					if(os.equalsIgnoreCase("windows")) {
						cap.setPlatform(Platform.WIN10);
						System.out.println("remote System is executed in Windows10");
						log.info("remote System is Exceted in Windows10");
					}
					else if(os.equalsIgnoreCase("linux")) {
						cap.setPlatform(Platform.LINUX);
						System.out.println("remote System is executed in Linux");
						log.info("remote System is Exceted in Linux");
					}
					else if(os.equalsIgnoreCase("mac")) {
						cap.setPlatform(Platform.MAC);
						System.out.println("remote System is executed in MAC");
						log.info("remote System is Exceted in Mac");
					}
					else {
						System.out.println("chosee correct os");
						log.info("chosee corect os");
					}
					//browser
					if(browser.equalsIgnoreCase("chrome")) {
						cap.setBrowserName("chrome");
						System.out.println("remote System is executed in browser chrome");
						log.info("remote System is Exceted in in browser chrome");
						
					}
					else if(browser.equalsIgnoreCase("edge")) {
						cap.setBrowserName("MicrosoftEdge");
					System.out.println("remote System is Exceted in in browser MicroSoftEdge");
					log.info("remote System is Exceted in in browser chrome");
					}
					else if(browser.equalsIgnoreCase("firefox")) {
						cap.setBrowserName("firefox");
					System.out.println("remote System is Exceted in in browser MicroSoftEdge");
					log.info("remote System is Exceted in in browser chrome");
					}
					else {
						System.out.println("choose correct browser");
						log.info("chosse Correct browser");

				        }
					System.out.println("come in remote webDriver");
					driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					System.out.println("Remonte Driver is created");
					log.info("Remote Driver software is Created");
				  }
				
				if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			   switch(browser.toLowerCase()) {
			   case "chrome":
				   WebDriverManager.chromedriver().setup();
				   driver=new ChromeDriver();
				   System.out.println("local executed in Chrome Driver");
				   log.info("local executed in Chrome Driver");
				   break;
			   case "edge":
				   WebDriverManager.edgedriver().setup();
				   driver=new EdgeDriver();
				   System.out.println("local executed in Edge  Driver");
				   log.info("local executed in Edge Driver");
				   break;
			   case "firefox":
				   WebDriverManager.firefoxdriver().setup();
				   driver=new FirefoxDriver();
				   System.out.println("executed in Firfox Driver");
				 break;
				 default:
					 System.out.println("plz selected valid Driver");
					 log.info("plz selected valid Driver");
					 break;
			        }
				
			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			   
				 driver.manage().window().maximize();
			   }
			}

	        @BeforeMethod(groups={"sanity","Regeression","master"})  
			public void navgateToURl() {
				driver.get(p.getProperty("url"));
				log.info("navigate the URL");
			  }
	        @AfterClass(groups={"sanity","Regeression","master"})
			public void closeCurrentBrowser() {
				driver.close();
				log.info("close The Current Browser");
			}
			public static void closeAllOpenBrowsers() {
				driver.quit();
				log.info("close the All Browsers in Selenium");
			}
			
			
			
	   }
		

	



