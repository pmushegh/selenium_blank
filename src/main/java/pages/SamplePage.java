package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SamplePage extends BasePage {

    private String strPageTitle = "My Profile : General info";
    private String strPageURL = "/workload/employeeView.do?employeeId=4060741400311846020#emplTab=general";

    @FindBy(css = "#employeeAssessmentsContainer > div:nth-child(2) > div:nth-child(1) > span")
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