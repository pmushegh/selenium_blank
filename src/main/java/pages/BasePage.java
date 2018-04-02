package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

public abstract class BasePage extends SlowLoadableComponent<BasePage> {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    protected BasePage(WebDriver webDriver) {
        super(new SystemClock(), 10);
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 1);
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

    protected void clickOnElement(WebElement webElement) {
        webElement.click();
    }

    protected void fillText(WebElement webElement, String strText) {
        webElement.clear();
        webElement.sendKeys(strText);
    }

    protected void checkIfElementIsVisible(WebElement webElement) throws TimeoutException {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
