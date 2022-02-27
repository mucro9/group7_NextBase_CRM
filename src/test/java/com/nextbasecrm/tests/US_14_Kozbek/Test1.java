package com.nextbasecrm.tests.US_14_Kozbek;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class Test1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://apple.com");
        //setup commit

    }
}
