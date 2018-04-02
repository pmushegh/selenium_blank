import driverFactory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import pages.SamplePage;

public abstract class BaseTest {

    private ThreadLocal<WebDriver> driver;

    public SamplePage samplePage;

    protected WebDriver webDriver() {
        return driver.get();
    }

    @BeforeTest(alwaysRun = true)
    public void warmUp() {
        driver = new ThreadLocal<>();
        driver.set(WebDriverFactory.createWebDriver());

        // Pages initialisation
        samplePage = PageFactory.initElements(webDriver(), SamplePage.class);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }
}
