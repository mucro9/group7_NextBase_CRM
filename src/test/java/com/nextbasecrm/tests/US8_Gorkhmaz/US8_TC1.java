package com.nextbasecrm.tests.US8_Gorkhmaz;


import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US8_TC1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test       // Two Bugs 1. ("Message" sub-module actual is "Message(s) ", "Activity Stream" actual is "Activity Stream ")
    public void chatAndCalls() {

        driver.get("https://login2.nextbasecrm.com/stream/?login=yes");
        CRM_Utilities.crm_login(driver);
        driver.findElement(By.xpath("//*[@id=\"bx_left_menu_menu_im_messenger\"]/a/span[1]")).click();

        List<String> expectedList = new ArrayList<>(Arrays.asList("Message", "Notifications", "Settings", "Activity Stream"));

        // "Message(s) ", "Notifications", "Settings", "Activity Stream " //

        List<String> actualList = new ArrayList<>();
//        List<WebElement> list = driver.findElements(By.xpath("//div[contains(@id,'bx-desktop-tab')]")); //
        actualList.add(driver.findElement(By.xpath("//div[@id=\'bx-desktop-tab-im']")).getAttribute("title"));
        actualList.add(driver.findElement(By.xpath("//div[@id=\'bx-desktop-tab-notify']")).getAttribute("title"));
        actualList.add(driver.findElement(By.xpath("//div[@id=\'bx-desktop-tab-config']")).getAttribute("title"));
        actualList.add(driver.findElement(By.xpath("//div[@id=\'bx-desktop-tab-im-lf']")).getAttribute("title"));


        System.out.println("actualList = " + actualList);
        System.out.println("expectedList = " + expectedList);
        Assert.assertEquals(actualList, expectedList);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}