package appium;

import org.junit.After;
import org.junit.Before;

public class Hooks extends AppiumController{

    @Before
    public void setUp() throws Exception {
        startAppium();
    }

    @After
    public void tearDown() throws Exception {
        stopAppium();
    }

}
