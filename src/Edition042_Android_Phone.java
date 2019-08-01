import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Edition042_Android_Phone {

    private AndroidDriver driver;
    private String APP = "/Users/sumeetpanjabi/Documents/dev-code-base/viu-android/viuapp-tv/build/outputs/apk/debug/viuapp-tv-debug.apk";
    private String firstTile = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Spotlight\"]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ImageView";

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", "192.168.1.151:5555");
        //capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android_TV");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.vuclip.viu");
        capabilities.setCapability("appActivity", "com.vuclip.viu.view.splash.TvSplashActivity");
        capabilities.setCapability("platformVersion", "8.1.0");


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void navigateApp() {

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement hindiButton = driver.findElement(By.xpath("//*[@resource-id='com.vuclip.viu:id/pref_language_button'][@text='Hindi']"));

        if(hindiButton.getAttribute("focused").equalsIgnoreCase("true")) {
            driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
        }

        try {
            if (driver.findElement(By.id("com.vuclip.viu:id/error_screen_retry_button")).isDisplayed()) {
                driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));
            }

        } catch (Exception e) {

        }

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
    }


    @Test
    public void playVideo() throws InterruptedException {
        System.out.print("Play video method");
        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));

        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));

        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));

        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));

        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));



        /*driver.findElement(By.xpath(firstTile)).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath(firstTile)).click();

        Thread.sleep(5000);

        driver.findElement(By.id("com.vuclip.viu.tv:id/main_image")).click();

        Thread.sleep(5000);

        driver.findElement(By.id("com.vuclip.viu.tv:id/lb_action_button")).click();*/
    }

    @Test
    public void addToPlaylist() throws InterruptedException {
        System.out.print("Add to Playlist method");
        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));

        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));

        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));

        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));

        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));

        Thread.sleep(5000);

        driver.pressKey(new KeyEvent(AndroidKey.DPAD_CENTER));

    }
}

