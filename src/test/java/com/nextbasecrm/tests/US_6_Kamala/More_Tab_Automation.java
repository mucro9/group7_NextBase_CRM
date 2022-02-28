package com.nextbasecrm.tests.US_6_Kamala;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;




    public class More_Tab_Automation {
        WebDriver driver;

        @BeforeMethod
        public void setupMethod() {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        }
        @Test
        public void crmMoreTabButton() {

            driver.get(" https://login1.nextbasecrm.com/");

            WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-inp']"));
            loginButton.sendKeys("hr19@cydeo.com");

            WebElement passwordButton = driver.findElement(By.xpath("//input[@placeholder='Password']"));

            passwordButton.sendKeys("UserUser" + Keys.ENTER);


            WebElement moreTabButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));

            moreTabButton.click();

        }
        @AfterMethod
        public void tearDown(){
            driver.quit();
        }

    }




