package com.nextbasecrm.tests.US11_Hee;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US11_Verify_FiveModules {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env1"));

        WebElement inputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys(ConfigurationReader.getProperty("usernameHr1"));


        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));


        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        BrowserUtils.sleep(2);


    }


    @Test
    public void verify_myProfile_Display() {

        WebElement userNameBtn = driver.findElement(By.xpath("//span[.='Hr19 Cydeo']"));
        userNameBtn.click();

        WebElement myProfileBtn = driver.findElement(By.xpath("//span[.='My Profile']"));
        Assert.assertTrue(myProfileBtn.isDisplayed(), "My Profile Display Verification is failed");


        BrowserUtils.sleep(2);


        myProfileBtn.click();


    }

    @Test
    public void verify_FiveOptions() {


        List<WebElement> actualFiveOptions = driver.findElements(By.xpath("//div[@class='profile-menu-items']/a"));
        List<String> expectedFiveOptions = Arrays.asList("General", "Drive", "Tasks", "Calendar", "Conversations");


        for (int i = 0; i < actualFiveOptions.size(); i++) {
            Assert.assertEquals(actualFiveOptions.get(i).getText(), expectedFiveOptions.get(i));

            System.out.println(actualFiveOptions.get(i).getText() + " - " + expectedFiveOptions.get(i));
            BrowserUtils.sleep(1);

        }
    }


    @AfterMethod
    public void tearDown() {
         driver.quit();

    }

}

