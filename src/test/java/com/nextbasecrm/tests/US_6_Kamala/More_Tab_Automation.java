package com.nextbasecrm.tests.US_6_Kamala;

import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


    public class More_Tab_Automation {
        WebDriver driver;

        @BeforeMethod
        public void setupMethod() {

            String browserType = ConfigurationReader.getProperty("browser");
            driver = WebDriverFactory.getDriver(browserType);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        }
        @Test
        public void crmMoreTabButton() {
            //Go to  https://login1.nextbasecrm.com/
            driver.get(" https://login1.nextbasecrm.com/");
            //Enter valid  username
            WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-inp']"));
            loginButton.sendKeys("hr19@cydeo.com");
            // Enter valid password and  log in
            WebElement passwordButton = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            passwordButton.sendKeys("UserUser" + Keys.ENTER);

            //Locate More tab
            WebElement moreTabButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
            // Click on More tab
            moreTabButton.click();
            List<WebElement> AllOptions = driver.findElements(By.xpath("//div[@class='menu-popup-items']"));
            for (WebElement eachOption : AllOptions) {
                Assert.assertTrue(eachOption.isDisplayed());
            }
        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }

    }




