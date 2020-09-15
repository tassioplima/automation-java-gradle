import appium.Hooks;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class gradleJunit extends Hooks {

    @Test
    public void firstTest() {
        assertTrue(pageScreen.getValue().isDisplayed());
    }

}