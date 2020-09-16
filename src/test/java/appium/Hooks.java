package appium;

import org.junit.After;
import org.junit.Before;
import screens.PageScreen;

public class Hooks extends AppiumController{

    public PageScreen pageScreen;

    @Before
    public void setUp() throws Exception {

        pageScreen = new PageScreen(driver);
    }

    @After
    public void tearDown() throws Exception {
        stopAppium();
    }
}
