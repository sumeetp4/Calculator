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

public class PerimeterXTest {

    private AppiumDriver driver;

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
/*
    @Test
    public void testAddition() {

        numtoXpath(2).click();

        driver.findElementByXPath(basicGroupPath + "/AXButton[@AXDescription='add']").click();

        numtoXpath(3).click();

        driver.findElementByXPath(basicGroupPath + "/AXButton[@AXDescription='equals']").click();

        WebElement result = driver.findElementByXPath(resultGroupPath + "/AXStaticText[@AXDescription='main display']");

        Assert.assertEquals("5", result.getText());
    }*/

}
