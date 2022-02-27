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
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US9_accessing_correct_modules {

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



    //2-User clicks on module
    //3- User sees the correct page title
    @Test
    public void activityStream_module_test() {

        driver.findElement(By.xpath("//a[@title='Activity Stream']")).click();
        Assert.assertEquals(driver.getTitle(),"Portal");

    }

    @Test
    public void tasks_module_test() {

        driver.findElement(By.xpath("//a[@title='Tasks']")).click();
        Assert.assertEquals(driver.getTitle(),"Site map");

    }

    @Test
    public void chatAndCalls_module_test() {

        driver.findElement(By.xpath("//a[@title='Chat and Calls']")).click();
        Assert.assertEquals(driver.getTitle(),"Chat and Calls");

    }


    @Test
    public void workgroups_module_test() {

        driver.findElement(By.xpath("//a[@title='Workgroups']")).click();
        Assert.assertEquals(driver.getTitle(),"Workgroups and projects");

    }


    @Test
    public void drive_module_test() {

        driver.findElement(By.xpath("//a[@title='Drive']")).click();
        Assert.assertEquals(driver.getTitle(),"Site map");

    }


    @Test
    public void calendar_module_test() {

        driver.findElement(By.xpath("//a[@title='Calendar']")).click();
        Assert.assertEquals(driver.getTitle(),"Site map");

    }



    @Test
    public void contactCenter_module_test() {

        driver.findElement(By.xpath("//a[@title='Contact Center']")).click();
        Assert.assertEquals(driver.getTitle(),"Contact Center");

    }



    @Test
    public void timeAndReports_module_test() {

        driver.findElement(By.xpath("//a[@title='Time and Reports']")).click();
        Assert.assertEquals(driver.getTitle(),"Absence Chart");

    }

    @Test
    public void employees_module_test() {

        driver.findElement(By.xpath("//a[@title='Employees']")).click();
        Assert.assertEquals(driver.getTitle(),"Company Structure");

    }

    @Test
    public void services_module_test() {

        driver.findElement(By.xpath("//a[@title='Services']")).click();
        Assert.assertEquals(driver.getTitle(),"Meeting Rooms");

    }

    @Test
    public void company_module_test() {

        driver.findElement(By.xpath("//a[@title='Company']")).click();
        Assert.assertEquals(driver.getTitle(),"Company");

    }


}
