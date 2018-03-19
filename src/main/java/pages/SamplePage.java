package pages;

import org.openqa.selenium.WebDriver;

public class SamplePage extends BasePage {

    public SamplePage(WebDriver webDriver) {
            super(webDriver);
    }

    @Override
    protected void load() {
        super.open("http:\\www.google.com");
    }
}
