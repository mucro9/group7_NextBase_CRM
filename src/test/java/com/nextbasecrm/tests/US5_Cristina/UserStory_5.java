package com.nextbasecrm.tests.US5_Cristina;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory_5 {
    WebDriver driver;

    @DataProvider(name="UserCredentials")
    public Object[][] credentials(){
        return new Object[][]{
                {"hr19@cydeo.com","UserUser"},

                {"helpdesk20@cydeo.com","UserUser"},
                {"marketing19@cydeo.com","UserUser"}

        };
    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env1"));
    }
    @Test(dataProvider = "UserCredentials")
    public void send_message_successfully(String username, String password) throws InterruptedException {
        //1. When users click the MASSAGE tab, they should be able to write the message body and
//send a message successfully to the feed.

        //login with valid userCredentials
        CRM_Utilities.crm_login(driver,username,password);


        Thread.sleep(2000);
//locating and clicking the message butt.
        WebElement messTab= driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messTab.click();

        //switch focus to iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        //locating the bodymessage and sending message text
        WebElement bodymessage= driver.findElement(By.xpath("//html//body[@contenteditable='true']"));
        bodymessage.sendKeys("illegal1");

        driver.switchTo().parentFrame();

        //locating the Send Button
        WebElement sendButt= driver.findElement(By.id("blog-submit-button-save"));
        sendButt.click();

        //checking if we see the message in the feed


        WebElement feedtext = driver.findElement(By.xpath("//div[@class = 'feed-post-text-block']//div[@class = ' feed-post-contentview feed-post-text-block-inner']/div"));

        Assert.assertEquals(feedtext.getText(),"illegal1","The text in the feed is not matching");

    }

    @Test (dataProvider = "UserCredentials")
    public void send_empty_message(String username, String password) throws InterruptedException {
//2. “The message title is not specified”. Should be displayed when users send a message
//without a content.

        //login with valid userCredentials
        CRM_Utilities.crm_login(driver,username,password);

        driver.findElement(By.xpath("//a[@title='Activity Stream']")).click();

        //locating and clicking the message butt.
        WebElement messTab= driver.findElement(By.id("feed-add-post-form-tab-message"));
        messTab.click();

        //locating the Send Button
        WebElement sendButt= driver.findElement(By.id("blog-submit-button-save"));
        sendButt.click();

        WebElement warningmessage = driver.findElement(By.xpath("//span[.='The message title is not specified']"));
        String actualtext= warningmessage.getText();

        Assert.assertEquals(actualtext,"The message title is not specified","Warning message is not matching");
    }


}
