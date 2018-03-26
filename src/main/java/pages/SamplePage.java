package pages;

import org.openqa.selenium.WebDriver;

public class SamplePage extends BasePage {

    private String strPageTitle = "Google";
    private String strPageURL = "";

    public SamplePage(WebDriver webDriver) {
            super(webDriver);
    }

    @Override
    protected void load() {
        open(strPageURL);
    }

    @Override
    protected void isLoaded() throws Error {
        checkPageTitle(strPageTitle);
        checkPageURL(strPageURL);
    }
}