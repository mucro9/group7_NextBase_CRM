package com.nextbasecrm.tests.US_14_Kozbek;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US14_IsDisplayed {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com/");
    }

    @Test
    public void threeDesktopOptions() {
        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("helpdesk22@cydeo.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement MacOs = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-macos']"));
        boolean MacOsDisplayed = MacOs.isDisplayed();
        System.out.println("MacOsDisplayed = " + MacOsDisplayed);
        WebElement Windows = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-windows']"));
        boolean WindowsDisplayed = Windows.isDisplayed();
        System.out.println("WindowsDisplayed = " + WindowsDisplayed);
        WebElement Linux = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-linux']"));
        boolean LinuxDisplayed = Linux.isDisplayed();
        System.out.println("LinuxDisplayed = " + LinuxDisplayed);
        driver.close();
    }

    @Test
    public void desktopThreeItems2() {
        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("hr22@cydeo.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement MacOs = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-macos']"));
        boolean MacOsDisplayed = MacOs.isDisplayed();
        System.out.println("MacOsDisplayed = " + MacOsDisplayed);
        WebElement Windows = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-windows']"));
        boolean WindowsDisplayed = Windows.isDisplayed();
        System.out.println("WindowsDisplayed = " + WindowsDisplayed);
        WebElement Linux = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-linux']"));
        boolean LinuxDisplayed = Linux.isDisplayed();
        System.out.println("LinuxDisplayed = " + LinuxDisplayed);

    }

    @Test
    public void desktopThreeItems3() {
        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("marketing22@cydeo.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement MacOs = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-macos']"));
        boolean MacOsDisplayed = MacOs.isDisplayed();
        System.out.println("MacOsDisplayed = " + MacOsDisplayed);
        WebElement Windows = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-windows']"));
        boolean WindowsDisplayed = Windows.isDisplayed();
        System.out.println("WindowsDisplayed = " + WindowsDisplayed);
        WebElement Linux = driver.findElement(By.xpath("//span[@class='b24-app-icon b24-app-icon-linux']"));
        boolean LinuxDisplayed = Linux.isDisplayed();
        System.out.println("LinuxDisplayed = " + LinuxDisplayed);
    }
}