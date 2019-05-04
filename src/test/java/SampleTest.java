import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class SampleTest extends BaseTest {

    @Test(description = "Some test")
    @Description("Something more detailed about test")
    public void someTest() {
        samplePage.get();
    }
}