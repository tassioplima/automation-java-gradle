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
    
    @Test
    public void secondTest() {
        assertTrue(pageScreen.getValue().isDisplayed());
    }
    
     @Test
    public void thirdTest() {
        assertTrue(pageScreen.getValue().isDisplayed());
    }
    
     @Test
    public void fourthTest() {
        assertTrue(pageScreen.getValue().isDisplayed());
    }


}
