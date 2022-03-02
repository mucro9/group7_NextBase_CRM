package com.nextbasecrm.tests.US_12_Nazir;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com/auth/?logout=yes&backurl=%2Fstream%2F");

        //1-User on the homepage
        driver.get("https://login2.nextbasecrm.com/");
        CRM_Utilities.crm_login(driver);
    }






    @Test
    public void announcement_set_Up() throws InterruptedException {
        //********* more dropdown feature ******************
        WebElement moreDropDown = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreDropDown.click();
        Thread.sleep(2000);

        //******** Announcement option is located and clciked
        WebElement announcementOption = driver.findElement(By.xpath("//span[.='Announcement']"));
        announcementOption.click();


        //************ Message Editor is located (identified) and write the text down in it
        // this text editor is located in iframe
        WebElement frameElm = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(frameElm);



        WebElement msgEditor = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        msgEditor.sendKeys("");
        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        //********* Send Button is located and clicked amq
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendBtn.click();
        Thread.sleep(3000);

        WebElement messageNotSpecified=driver.findElement(By.xpath("//span[@class='feed-add-info-text']"));
        Thread.sleep(3000);



    }

    @AfterMethod
    public void tearDown()  {
        driver.quit();
    }















}

