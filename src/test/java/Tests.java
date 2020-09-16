import appium.Hooks;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests extends Hooks {

    @Test
    public void firstTest() {
        assertTrue(pageScreen.getValue().isDisplayed());
    }

}