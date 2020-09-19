package appium;

import java.net.URL;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumController {

    public static final String AUTOMATE_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");

    public static final String server = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static AppiumDriver driver;

    public void startAppium() throws Exception {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("device", "Google Pixel 3");
            caps.setCapability("os_version", "9.0");
            caps.setCapability("project", "My First Project");
            caps.setCapability("build", "My First Build");
            caps.setCapability("name", "First test");
            caps.setCapability("app", "bs://d6f4857a9bd749fc33fe02160c211fb1cea500bc");

            driver = new AppiumDriver<MobileElement>(new URL(server), caps);
    }

    public void stopAppium() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
