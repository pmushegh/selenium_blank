package pages;

import org.openqa.selenium.WebDriver;

public class SamplePage extends BasePage {

    public SamplePage(WebDriver webDriver) {
            super(webDriver);
    }

    public void open() {
        super.open("http:\\www.google.com");
    }
}
