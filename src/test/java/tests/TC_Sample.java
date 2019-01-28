package tests;

import java.io.IOException;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Sample {
    WebDriver driver;

    @BeforeMethod
    public void setup_Driver() throws IOException {
        System.getProperties().list(System.out);
        String driverPath = Paths.get("").toAbsolutePath().toString() + "/src/test/resources/";
        switch(System.getProperty("os.name")) {
            case "Mac OS X":
                String macDriver = driverPath + "chromedriver_mac64";
                System.setProperty("webdriver.chrome.driver", macDriver);
                break;
            case "Linux":
                String linuxDriver = driverPath + "chromedriver_linux64";
                System.setProperty("webdriver.chrome.driver", linuxDriver);
                Runtime.getRuntime().exec("sudo chmod +x " + linuxDriver);
                break;
            case "Windows":
            default:
                String windowsDriver = driverPath + "chromedriver_win32";
                System.setProperty("webdriver.chrome.driver", windowsDriver);
                break;
        }
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
