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

            //Locate File option
            WebElement fileOption= driver.findElement(By.xpath("//span[@class='menu-popup-item menu-popup-no-icon feed-add-post-form-file feed-add-post-form-file-more ']"));
            //verify  if File option is displayed
            fileOption.isDisplayed();

            //Locate and verify Appreciation option is displayed
            WebElement appreciationOption= driver.findElement(By.xpath("//span[text()='Appreciation']"));
            appreciationOption.isDisplayed();
            // Locate and verify Announcement option is displayed
            WebElement announcementOption= driver.findElement(By.xpath("//span[text()='Announcement']"));
            announcementOption.isDisplayed();

            //Locate and verify Workflow option is displayed
            WebElement workflowOption= driver.findElement(By.xpath("//span[text()='Workflow']"));
            workflowOption.isDisplayed();
            // Assert File option text is as expected
            String  expectedFileOption="File";
            String actualFileOption=fileOption.getText();

            Assert.assertEquals(actualFileOption, expectedFileOption);
            // Assert Appreciation  option text is as expected
            String expectedAppreciationOption= "Appreciation";
            String actualAppreciationOption=appreciationOption.getText();

            Assert.assertEquals(actualAppreciationOption,expectedAppreciationOption);


            // Assert Announcement option text is as expected
            String expectedAnnouncementOption="Announcement";
            String actualAnnouncementOption=announcementOption.getText();

            Assert.assertEquals(actualAnnouncementOption,expectedAnnouncementOption);


            // Assert Workflow option text is as expected
            String expectedWorkflowOption="Workflow";
            String actualWorkflowOption=  workflowOption.getText();

            Assert.assertEquals(actualWorkflowOption,expectedWorkflowOption);

        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }

    }




