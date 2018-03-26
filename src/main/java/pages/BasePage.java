package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

public abstract class BasePage extends SlowLoadableComponent<BasePage> {

    private WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        super(new SystemClock(), 10);
        this.webDriver = webDriver;
    }

    protected void open(String strPageURL) {
        this.open(strPageURL, true);
    }

    protected void open(String strPageURL, boolean bUseBaseURL) {
        if (bUseBaseURL) {
            webDriver.get(System.getProperty("application.site.url") + strPageURL);
        } else {
            webDriver.get(strPageURL);
        }
    }

    protected void checkPageURL(String strPageURL) {
        this.checkPageURL(strPageURL, true);
    }

    protected void checkPageURL(String strPageURL, boolean bUseBaseURL) {
        if (bUseBaseURL) {
            Assert.assertEquals(webDriver.getCurrentUrl(), System.getProperty("application.site.url") + strPageURL, "Page URL is incorrect.");
        } else {
            Assert.assertEquals(webDriver.getCurrentUrl(), strPageURL, "Page URL is incorrect.");
        }
    }

    protected void checkPageTitle(String strPageTitle) {
        Assert.assertEquals(webDriver.getTitle(), strPageTitle, "Page title in incorrect.");
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}