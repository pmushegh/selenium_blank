import org.testng.annotations.Test;
import utils.Log;

public class SampleTest extends BaseTest {

    @Test
    public void someTest() {
        Log.testCaseStart("Sample test");
        samplePage.open();
    }
}
