package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class AppManager {
    private WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(AppManager.class);

    public WebDriver getDriver() {
        return driver;
    }

    public AppManager() {
    }

    @BeforeMethod
    public void setup(Method method) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        logger.info("start testing with method ---> " + method.getName());
    }

    @AfterMethod(enabled = false)
    public void tearDown(Method method) {
        if (driver != null) {
            driver.quit();
            logger.info("stop testing with method ---> " + method.getName());
        }
    }

}
