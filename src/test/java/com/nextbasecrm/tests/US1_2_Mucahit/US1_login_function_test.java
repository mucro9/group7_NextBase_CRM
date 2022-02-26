package com.nextbasecrm.tests.US1_2_Mucahit;
import com.nextbasecrm.tests.US5_Cristina.utilities.ConfigurationReader;
import com.nextbasecrm.tests.US5_Cristina.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class US1_login_function_test {
    /*As a user, I should be able to log in to the NextBaseCRM.
    1. The login page title should be “Authorization.”
    2. The user should go to the homepage after login in successfully.
    3. “Incorrect username or password” should be displayed when a user enters the wrong username or password.
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @DataProvider(name = "UserNames")
    public Object[][] provideData() {
         return new Object[][]{
                 {ConfigurationReader.getProperty("usernameHelp1")},
                 {ConfigurationReader.getProperty("usernameHelp2")},
                 {ConfigurationReader.getProperty("usernameHelp3")},
                 {ConfigurationReader.getProperty("usernameHr1")},
                 {ConfigurationReader.getProperty("usernameHr2")},
                 {ConfigurationReader.getProperty("usernameHr3")},
                 {ConfigurationReader.getProperty("usernameMark1")},
                 {ConfigurationReader.getProperty("usernameMark2")},
                 {ConfigurationReader.getProperty("usernameMark3")}
         };
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void title_verification_test(){
        driver.get(ConfigurationReader.getProperty("env1"));//login1.nextbasecrm
        assertEquals(driver.getTitle(),ConfigurationReader.getProperty("expectedNextBaseTitle"));//Authorization
    }


    @Test(dataProvider = "UserNames")
    public void loginWithValidCredentials_successfully_test(String username){
        driver.get(ConfigurationReader.getProperty("env1"));
        WebElement userName = driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']"));
        userName.sendKeys(username);

        WebElement password =driver.findElement(By.xpath("//input[@name ='USER_PASSWORD']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Log In']"));
        loginButton.click();

        assertTrue(driver.findElement(By.xpath("(//span[@class= 'menu-item-link-text'])[1]")).isDisplayed());

    }
}
