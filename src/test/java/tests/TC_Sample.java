package tests;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Sample {
    WebDriver driver;

    @BeforeMethod
    public void setup_Driver() {
        System.setProperty("webdriver.chrome.driver", Paths.get("").toAbsolutePath().toString() + "/src/test/resources/chromedriver");
         driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown_Driver() {
        driver.quit();
    }
    
    @Test
    public void test_SampleOutput() {
        driver.navigate().to("https://www.google.com");
        System.out.println("This is a sample test!");
        System.out.println("This is the Website: " + driver.getTitle());
        System.out.println("This is the URL: " + driver.getCurrentUrl());
    }
}
