package hooks;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

public class Hooks {
    @Before
    public void setup() {
        ExtentService.getInstance().setSystemInfo("Browser",
                System.getProperty("browser", "chrome"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",
                    "Failed Step Screenshot - " + scenario.getName());
        }
        Driver.closeDriver();
    }
} 