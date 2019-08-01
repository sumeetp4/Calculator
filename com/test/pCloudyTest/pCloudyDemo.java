package com.test.pCloudyTest;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class pCloudyDemo {


    private AndroidDriver driver;


    @Parameters({"deviceName"})
    @BeforeTest
    public void prepareTest(String deviceName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", "sumeet.panjabi@vuclip.com");
        capabilities.setCapability("pCloudy_ApiKey", "r525tghtytvkwvgqsbrsb86f");
        capabilities.setCapability("pCloudy_ApplicationName", "vuclip-prod-autopCloudy.apk");
        capabilities.setCapability("pCloudy_DurationInMinutes", 20);
        capabilities.setCapability("pCloudy_DeviceManafacturer", deviceName);
        driver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
    }

    @Test
    public void firstTest() {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Hindi')]")).click();
    }

    @Test
    public void secondTest() {
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Hindi')]")).click();
    }
}
