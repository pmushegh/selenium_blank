package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Log;

import java.net.URL;

public class WebDriverFactory {

    public static WebDriver createWebDriver() {
        final WebDriver driver;

        try {
            if (System.getProperty("local") != null) {
                if (System.getProperty("os.name").startsWith("Windows")) {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                    Log.info("Using Chrome Windows driver.");
                } else {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                    Log.info("Using Chrome Linux driver.");
                }
                driver = new ChromeDriver();
            } else {
                final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName("chrome");
                desiredCapabilities.setVersion("65.0");
//            desiredCapabilities.setBrowserName(configuration.getBrowser());
//            desiredCapabilities.setVersion(configuration.getBrowserVersion());
//            desiredCapabilities.setCapability(CapabilityType.PLATFORM, configuration.getPlatform());
//            desiredCapabilities.setCapability("idleTimeout", configuration.getIdleTimeout());
//            desiredCapabilities.setCapability("build", configuration.getBuild());
                desiredCapabilities.setCapability("screenResolution", "1920x1080");
                if (System.getProperty("selenium.server.hub") != null) {
                    // Remote hub
                    driver = new RemoteWebDriver(new URL(System.getProperty("selenium.server.hub")), desiredCapabilities);
                    Log.info("Using remote Selenium hub driver.");
                } else {
                    // Local hub
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
                    Log.info("Using local Selenium hub driver.");
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return driver;
    }
}
