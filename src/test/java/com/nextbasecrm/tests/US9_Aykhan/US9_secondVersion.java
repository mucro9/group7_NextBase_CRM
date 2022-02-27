package com.nextbasecrm.tests.US9_Aykhan;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US9_secondVersion {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env2"));

        //1-User on the homepage
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("usernameHelp1"), ConfigurationReader.getProperty("password"));
    }


    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.quit();
    }


   @DataProvider(name = "modules")
    public Object[][] provideModuleName() {

       return new Object[][]{
               {"Activity Stream", "Portal"},
               {"Tasks", "Site map"},
               {"Chat and Calls", "Chat and Calls"},
               {"Workgroups", "Workgroups and projects"},
               {"Drive", "Site map"},
               {"Calendar","Site map"},
               {"Contact Center","Contact Center"},
               {"Time and Reports", "Absence Chart"},
               {"Employees", "Company Structure"},
               {"Services", "Meeting Rooms"},
               {"Company", "Company"}


   };
   }


   @Test(dataProvider = "modules")
    public void checkModules(String moduleName, String expectedTitle){

       driver.findElement(By.xpath("//a[@title='" + moduleName+ "']")).click();
       Assert.assertEquals(driver.getTitle(),expectedTitle);

   }


}
