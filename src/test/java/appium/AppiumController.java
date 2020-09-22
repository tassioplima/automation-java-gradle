package appium;

import java.io.FileNotFoundException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Utils;

public class AppiumController {

    public static final String AUTOMATE_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");

    public static final String server = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static AppiumDriver driver;

    String mobile = System.getProperty("MOBILE");

    public void startAppium() throws Exception {

        if (mobile.contains("ANDROID")){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("device", "Google Pixel 3");
            caps.setCapability("os_version", "9.0");
            caps.setCapability("project", "Android Project");
            caps.setCapability("build", "Automation");
            caps.setCapability("name", "Android");
            caps.setCapability("app", Utils.pathToJSON().getApps()[0]);

            driver = new AppiumDriver<MobileElement>(new URL(server), caps);
        } else if (mobile.contains("iOS")){

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("device", "iPhone 11 Pro");
            caps.setCapability("os_version", "13");
            caps.setCapability("project", "iOS Project");
            caps.setCapability("build", "Automation");
            caps.setCapability("name", "iOS");
            caps.setCapability("app", Utils.pathToJSON().getApps()[1]);

            driver = new AppiumDriver<MobileElement>(new URL(server), caps);

        }

    }

    public void stopAppium() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
