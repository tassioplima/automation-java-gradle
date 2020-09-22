package utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class iOSCapabilities {

    public static DesiredCapabilities getIOSCapabilities(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "iPhone 11 Pro");
        caps.setCapability("os_version", "13");
        caps.setCapability("project", "iOS Project");
        caps.setCapability("build", "Automation");
        caps.setCapability("name", "iOS");
        caps.setCapability("app", Utils.pathToJSON().getApps()[1]);
        return caps;
    }
}
