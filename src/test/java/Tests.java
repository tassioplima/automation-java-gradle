import appium.AppiumController;
import org.junit.Test;
import screens.PageScreen;

import static org.junit.Assert.assertTrue;

public class Tests extends AppiumController {

    private PageScreen pagescreen;

    public Tests(){
        pagescreen = new PageScreen(driver);
    }

    @Test
    public void firstTest() {
        assertTrue(pagescreen.getValue().isDisplayed());
    }
}
