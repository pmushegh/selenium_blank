package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage extends LoadableComponent<BasePage> {

    private WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected void open(String pageURL, String pageTitle, boolean checkTitle) {
        //webDriver.manage().window().maximize(); not working with aerokube need to be checked
        webDriver.get(System.getProperty("application.site.url") + pageURL);
        final WebDriverWait wait = new WebDriverWait(webDriver, Long.parseLong(System.getProperty("application.page.open.delay")));
        if (checkTitle) {
            wait.until(ExpectedConditions.titleContains(pageTitle));
        }
    }

    protected void open(String pageURL, String pageTitle) {
        this.open(pageURL, pageTitle, true);
    }

    protected void open(String pageURL) {
        this.open(pageURL, null, false);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
