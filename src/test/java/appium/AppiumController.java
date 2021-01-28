package appium;

import java.net.URL;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import utils.AndroidCapabilities;
import utils.Utils;
import utils.iOSCapabilities;

public class AppiumController {

    String mobile = System.getProperty("MOBILE");

    public static final String AUTOMATE_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY") ;

    public static String userName = Utils.pathToJSON().getUserName();
    public static String accessKey = Utils.pathToJSON().getAccessKey();

    public static final String server = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final String local = "https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";

    public static AppiumDriver driver;


    public void startAppium() throws Exception {

        if (mobile.contains("IOS")){
            if (Boolean.getBoolean("EXEC")){
                driver = new AppiumDriver<MobileElement>(new URL(server), iOSCapabilities.getIOSCapabilities());
            } else {
                driver = new AppiumDriver<MobileElement>(new URL(local), iOSCapabilities.getIOSCapabilities());
            }

        } else if (mobile.contains("ANDROID")){
            if (Boolean.getBoolean("EXEC")){
                driver = new AppiumDriver<MobileElement>(new URL(server), AndroidCapabilities.getAndroidCapabilities());
            } else {
                driver = new AppiumDriver<MobileElement>(new URL(local), AndroidCapabilities.getAndroidCapabilities());
            }
        }

    }

    public void stopAppium() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}