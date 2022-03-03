package com.nextbasecrm.tests.US13_Koray;

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

public class US13_Appreciation_Module {
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
    public void tearDown() throws InterruptedException {
        BrowserUtils.sleep(2);
        driver.close();
    }
    @Test
    public void text_create_appreciation(){
        //click MORE button to see appreciation option
        WebElement moreButton=driver.findElement(By.xpath("//*[@class='feed-add-post-form-link-text']"));
        moreButton.click();
        //click Appreciation option
        WebElement appreciationButton= driver.findElement(By.xpath("//*[text()='Appreciation']"));
        appreciationButton.click();
        //changing focus to iframe
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[1]")));
        //enter some content
        WebElement content= driver.findElement(By.xpath("//body[@contenteditable='true']"));
        content.sendKeys("Hello B25 Test18");
        //changing focus to parent frame
        driver.switchTo().parentFrame();
        //click send button
        WebElement sendButton=driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        //verify appreciation message is displayed
        WebElement isDisplayed=driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
        System.out.println("isDisplayed.isDisplayed() = " + isDisplayed.isDisplayed());

        String expected="Hello B25 Test18";
        String actual=isDisplayed.getText();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test_appreciation_withNoContent(){

        //click MORE button to see appreciation option
        WebElement moreButton=driver.findElement(By.xpath("//*[@class='feed-add-post-form-link-text']"));
        moreButton.click();
        //click Appreciation option
        WebElement appreciationButton= driver.findElement(By.xpath("//*[text()='Appreciation']"));
        appreciationButton.click();
        //click send button
        WebElement sendButton=driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        //verify if the message title is not specified is displayed
        WebElement errorText= driver.findElement(By.xpath("//*[text()='The message title is not specified']"));
        Assert.assertTrue(errorText.isDisplayed());

        String expectedText="The message title is not specified";
        String actualText=errorText.getText();
        Assert.assertEquals(actualText,expectedText,"Warning Message did not appear!");
    }
}
