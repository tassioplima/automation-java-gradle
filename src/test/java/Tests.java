import appium.Hooks;
import org.junit.Test;
import screens.PageScreen;

import static org.junit.Assert.assertTrue;

public class Tests extends Hooks {

    public PageScreen pageScreen;

    @Test
    public void firstTest() {
        pageScreen = new PageScreen(driver);
        assertTrue(pageScreen.getValue().isDisplayed());
    }
}
