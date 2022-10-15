package com.datadriven.base;

import com.datadriven.utilities.ExcelReader;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase<driverPath> {

    /*WebDriver -done
     * Properties -done
     * logs
     * ExtentReports
     * DB
     * Excel
     * Mail
     * ReportNG
     * ExtentReports
     * Jenkins
     * */

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = LogManager.getLogger(TestBase.class.getName());
//    String log4jConfPath = "E:\\Automation_projects\\APITestingAutomation\\RahulArora_Course\\DataDrivenFramework\\src\\test\\resources\\properties\\log4j2.properties";
    public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testData.xlsx");
    public static WebDriverWait wait;

    @BeforeSuite
    public void setUp() throws IOException {
        if (driver == null) {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
            config.load(fis);
            log.debug("Config File loaded!!!!");

            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
            OR.load(fis);
            log.debug("OR File loaded!!!!");
        }

        if (config.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
            driver = new FirefoxDriver();
            log.debug("***Firefox launched***");
        }else if (config.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
            driver = new ChromeDriver();
            log.debug("***Chrome launched***");
        }
        driver.get(config.getProperty("testSiteUrl"));
        log.debug("Navigated to : "+config.getProperty("testSiteUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }catch(NoSuchElementException e) {
            return false;
        }
    }

    @AfterSuite
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
            log.debug("Test execution completed!!!");
        }
    }

    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "./resources/properties/log4j2.properties");
    }
}
