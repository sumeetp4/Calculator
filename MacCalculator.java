import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MacCalculator {

    private AppiumDriver driver;

    String windowPath = "/AXApplication[@AXTitle='Calculator']/AXWindow[0]";
    String resultGroupPath = windowPath + "/AXGroup[0]";
    String basicGroupPath = windowPath + "/AXGroup[1]";
    String scientificGroupPath = windowPath + "/AXGroup[2]";
    String programmerGroupPath = windowPath + "/AXGroup[1]";

    @Before
    public void setUp() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Mac");
        caps.setCapability("deviceName", "Mac");

        caps.setCapability("app", "Calculator");
        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        try {
            //driver.quit();
        } catch (Exception ign) {}
    }

    @Test
    public void testAddition() {

        numtoXpath(2).click();

        driver.findElementByXPath(basicGroupPath + "/AXButton[@AXDescription='add']").click();

        numtoXpath(3).click();

        driver.findElementByXPath(basicGroupPath + "/AXButton[@AXDescription='equals']").click();

        WebElement result = driver.findElementByXPath(resultGroupPath + "/AXStaticText[@AXDescription='main display']");

        Assert.assertEquals("5", result.getText());
    }

    @Test
    public void testDivision() {

        numtoXpath(1).click();
        numtoXpath(5).click();
        driver.findElementByXPath(basicGroupPath + "/AXButton[@AXDescription='divide']").click();

        numtoXpath(5).click();

        driver.findElementByXPath(basicGroupPath + "/AXButton[@AXDescription='equals']").click();

        WebElement result = driver.findElementByXPath(resultGroupPath + "/AXStaticText[@AXDescription='main display']");

        Assert.assertEquals("3", result.getText());
    }

    public WebElement numtoXpath(int num) {

        switch (num) {
            case 0:
                return driver.findElementByXPath(basicGroupPath+"/AXButton[@AXDescription='zero']");
            case 1:
                return driver.findElementByXPath(basicGroupPath+"/AXButton[@AXDescription='one']");
            case 2:
                return driver.findElementByXPath(basicGroupPath+"/AXButton[@AXDescription='two']");
            case 3:
                return driver.findElementByXPath(basicGroupPath+"/AXButton[@AXDescription='three']");
            case 4:
                return driver.findElementByXPath(basicGroupPath+"/AXButton[@AXDescription='four']");
            case 5:
                return driver.findElementByXPath(basicGroupPath+"/AXButton[@AXDescription='five']");
            case 6:
                return driver.findElementByXPath(basicGroupPath+"/AXButton[@AXDescription='six']");
            case 7:
                return driver.findElementByXPath(basicGroupPath+"/AXButton[@AXDescription='seven']");
            case 8:
                return driver.findElementByXPath(basicGroupPath+"/AXButton[@AXDescription='eight']");
            case 9:
                return driver.findElementByXPath(basicGroupPath+"/AXButton[@AXDescription='nine']");
            default:
                return null;

        }
    }
}
