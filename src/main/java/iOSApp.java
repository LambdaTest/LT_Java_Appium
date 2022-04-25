import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import org.testng.annotations.Test;

public class iOSApp {

    String userName = System.getenv("LT_USERNAME") == null ? "shantanuw" : System.getenv("LT_USERNAME");
    String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "rsS1I3BEWoWcAUJHtfa5TZaLjRV1NTeKmyRVJ8QjtCHhMIK3BW" : System.getenv("LT_ACCESS_KEY");

    public String gridURL = "@beta-hub.lambdatest.com/wd/hub";

    AppiumDriver driver;

    @Test
    @org.testng.annotations.Parameters(value = {"device", "version", "platform"})
    public void iOSApp1(String device, String version, String platform) {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build","Java TestNG iOS");
            capabilities.setCapability("name",platform+" "+device+" "+version);
            capabilities.setCapability("deviceName", device);
            capabilities.setCapability("platformVersion",version);
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("isRealMobile", true);
            //AppURL (Create from proverbial.ipa sample in project)
            capabilities.setCapability("app", "lt://APP100202371650863410340867"); //Enter your app url
            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
            //capabilities.setCapability("geoLocation", "HK");

            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AppiumDriver(new URL(hub), capabilities);

            WebDriverWait Wait = new WebDriverWait(driver,30);

            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("color"))).click();
            Thread.sleep(1000);

            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Text"))).click();
            Thread.sleep(1000);

            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("toast"))).click();
            Thread.sleep(1000);

            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("notification"))).click();
            Thread.sleep(4000);

            //Open the geolocation page
            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("geoLocation"))).click();
            Thread.sleep(4000);

            //Takes back
            driver.navigate().back();

            //Takes to speed test page
            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("speedTest"))).click();
            Thread.sleep(4000);

            driver.navigate().back();

            //Opens the browser
            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Browser"))).click();
            Thread.sleep(1000);

            MobileElement url = (MobileElement) driver.findElementByAccessibilityId("url");
            url.click();
            url.sendKeys("https://www.lambdatest.com");

            Wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("find"))).click();
            Thread.sleep(1000);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try{
                driver.quit();
            }catch(Exception e1){
                e.printStackTrace();
            }
        }


    }
}
