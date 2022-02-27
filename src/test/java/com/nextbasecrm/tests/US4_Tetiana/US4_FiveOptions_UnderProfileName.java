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

import java.util.concurrent.TimeUnit;

public class US4_FiveOptions_UnderProfileName {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env2"));

        //1.Users go on the homepage
        CRM_Utilities.crm_login(driver,ConfigurationReader.getProperty("usernameHelp3"),ConfigurationReader.getProperty("password"));

        WebElement userProfileName= driver.findElement(By.xpath("//div[@class='user-block']"));
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
    public void My_Profile_Option_test(){
        //Checks if My Profile Option is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='My Profile']")).isDisplayed());

    }
    @Test
    public void EditProfileSetting_Option_test(){
        //Checks if Edit Profile Settings Option is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='Edit Profile Settings']")).isDisplayed());
    }

    @Test
    public void Themes_Option_test(){
        //Checks if Themes Option is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='Themes']")).isDisplayed());


    }
    @Test
    public void ConfigureNotifications_Option_test(){
        //Checks if Configure notifications Option is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='Configure notifications']")).isDisplayed());


    }
    @Test
    public void Logout_Option_test(){
        //Checks if Log out Option is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='Log out']")).isDisplayed());


    }

}
