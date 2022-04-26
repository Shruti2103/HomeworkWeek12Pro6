package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void teirtest() {
        closeBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter valid user name
      //  WebElement validusername = driver.findElement(By.xpath("//input[@name='username']"));
      //  validusername.sendKeys("primeDevani");
        sendTextToElement(By.xpath("//input[@name='username']"),"primeDevani");
        // valid password
      //  WebElement validpassword = driver.findElement(By.xpath("//input[@name='password']"));
      //  validusername.sendKeys("prime123");
        sendTextToElement(By.xpath("//input[@name='password']"),"prime123");
        //click on login button
     //   WebElement loginbtn = driver.findElement(By.xpath("//input[@value='Log In']"));
    //    loginbtn.click();
        clickOnElement(By.xpath("//input[@value='Log In']"));
        // varify account overview is displayed
        String expectedmessage="Accounts Overview";
    //   WebElement actualmessage=driver.findElement(By.xpath("//h1[@class='title']"));
    //   String actualmessage1=actualmessage.getText();
        String actualmessage1=getTextFromElement(By.xpath("//h1[@class='title']"));
    // Asscert result
        Assert.assertEquals("Accounts Overview",expectedmessage,actualmessage1);

    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter invalid username
      //  WebElement invalidusername = driver.findElement(By.xpath("//input[@type='text']"));
      //  invalidusername.sendKeys("prime456");
       sendTextToElement(By.xpath("//input[@type='text']"),"prime456");
        //Enter invalid password
      //  WebElement invalidpassword = driver.findElement(By.xpath("//input[@type='password']"));
     //   invalidpassword.sendKeys("prime22");
        sendTextToElement(By.xpath("//input[@type='password']"),"prime22");
        //click on login button
     //   WebElement loginbutton = driver.findElement(By.xpath("//input[@type='submit']"));
     //   loginbutton.click();
        clickOnElement(By.xpath("//input[@type='submit']"));
        // varify the error message
        String expectedmessage = "The username and password could not be verified.";
      //  WebElement actualmessage = driver.findElement(By.xpath("//p[@class='error']"));
      //  String actualmessage1 = actualmessage.getText();
        String actualmessage2= getTextFromElement(By.xpath("//p[@class='error']"));// the actual message is not coming the enviornment issue
        // accser message
        Assert.assertEquals("The username and password could not be verified.", expectedmessage, actualmessage2);


    }

    @Test
    public void userShouldLogOutSuccessfully() {
        // enter valid username
     //   WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
     //   username.sendKeys("primeDevani");
        sendTextToElement(By.xpath("//input[@name='username']"),"primeDevani");
        // Valid password enter
      //  WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
     //   password.sendKeys("prime123");
        sendTextToElement(By.xpath("//input[@name='password']"),"prime123");
        // click omn login button
     //   WebElement loginbtn = driver.findElement(By.xpath("//input[@value='Log In']"));
     //   loginbtn.click();
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //  logout click
     //  WebElement logout = driver.findElement(By.xpath("//a[text()='Log Out']"));
     //  logout.click();
        clickOnElement(By.xpath("//a[text()='Log Out']"));
        // varify text customer login
       String expectedmsg = "Customer Login";
     //   WebElement actualmsg = driver.findElement(By.xpath("//h2[text()='Customer Login']"));
     //  String actualmsg1 = actualmsg.getText();
        String actualmsg1= getTextFromElement(By.xpath("//h2[text()='Customer Login']"));
        //Asscert result
        Assert.assertEquals("Customer Login", expectedmsg, actualmsg1);


    }


}
