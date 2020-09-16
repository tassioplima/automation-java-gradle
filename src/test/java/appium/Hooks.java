package appium;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import screens.PageScreen;

public class Hooks extends AppiumController{

    public PageScreen pageScreen;

    @BeforeAll
    public void setUp() throws Exception {
        startAppium();

        pageScreen = new PageScreen(driver);
    }

    @AfterAll
    public void tearDown() throws Exception {
        stopAppium();
    }
}
