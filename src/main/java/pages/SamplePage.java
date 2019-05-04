package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SamplePage extends BasePage {

    private String strPageTitle = "Հայկական դրամ՝ բոլոր փոխարժեքները";
    private String strPageURL = "/";

    @FindBy(css = "table.mainmenu")
    private WebElement weFirstLanguage;

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
        checkIfElementIsVisible(weFirstLanguage);
    }
}