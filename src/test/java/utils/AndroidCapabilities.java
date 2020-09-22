package utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidCapabilities {

    public static DesiredCapabilities getAndroidCapabilities(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");
        caps.setCapability("project", "Android Project");
        caps.setCapability("build", "Automation");
        caps.setCapability("name", "Android");
        caps.setCapability("app", Utils.pathToJSON().getApps()[0]);
        return caps;
    }

}
