import appium.Hooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import screens.PageScreen;

import static org.junit.Assert.assertTrue;

public class Tests extends Hooks {



    @Test
    public void firstTest() {
        assertTrue(pageScreen.getValue().isDisplayed());
    }

}