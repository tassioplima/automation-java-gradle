package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class PageScreen {

    private MobileDriver<MobileElement> driver;

    public PageScreen(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(className = "android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "Text Button")
    private MobileElement value;

    public MobileElement getValue(){
        return this.value;
    }
}
