package com.nextbasecrm.tests.US4_Tetiana;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US4_FiveOptions_UnderProfileName2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env2"));

        //1.Users go on the homepage
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("usernameHelp3"), ConfigurationReader.getProperty("password"));

        WebElement userProfileName = driver.findElement(By.xpath("//div[@class='user-block']"));
        userProfileName.click();

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.quit();
    }

    //2.Users click user profile name
    //User should see 5 options: My Profile,Edit Profile Settings,Themes, Configure notifications, Log out


    @Test
    public void AllFiveOptions_test() {
        //Locate and store all options in ArrayList
        List<WebElement> listOfOptionsUnderProfile = new ArrayList<>(driver.findElements(By.xpath("//div[@class='menu-popup-items']//span[2]")));

        //remove one Web Element with span tag which is not one of those 5 options
        listOfOptionsUnderProfile.remove(3);

        //Store expected results in String array
        String[] expectedOptions = {"My Profile", "Edit Profile Settings", "Themes", "Configure notifications", "Log out"};


        for (int i = 0, j = 0; i < listOfOptionsUnderProfile.size(); i++, j++) {
            String actualOptions = listOfOptionsUnderProfile.get(i).getText();

            //Checks if actual result equals to expected result
            Assert.assertEquals(actualOptions, expectedOptions[j]);

        }


    }
}