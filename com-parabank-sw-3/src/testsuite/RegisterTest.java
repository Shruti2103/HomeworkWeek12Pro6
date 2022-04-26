package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearclose() {
        closeBrowser();
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //log in click register button

        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // varify signing up easy text message
        String expectedmessage = "Signing up is easy!";

        String actualmessage1 = getTextFromElement(By.xpath("//h1[@class='title']"));
        // Assert actual message with expected message
        Assert.assertEquals("Signinig up is easy", expectedmessage, actualmessage1);


    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        // click on register link

        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Enter first name

        sendTextToElement(By.xpath("//input[@id='customer.firstName']"), "Prime3");
        //Enter last Name

        sendTextToElement(By.xpath("//input[@id='customer.lastName']"), "Devani");
        //Enter address

        sendTextToElement(By.xpath("//input[@id='customer.address.street']"), "3,Butler Road");
        //Enter city

        sendTextToElement(By.id("//input[@id='customer.address.city']"), "London");
        //Enter state

        sendTextToElement(By.xpath("//input[@id='customer.address.state']"), "Middlesex");
        //Enter zipcode

        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"), "Ha1 3sd");
        //phone number

        sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"), "04587853256");
        //Enter SSN

        sendTextToElement(By.xpath("//input[@id='customer.ssn']"), "123");
        //Enter valid username

        sendTextToElement(By.xpath("//input[@name='customer.username']"), "primeDevani");
        //Enter valid password

        sendTextToElement(By.xpath("//input[@id='customer.password']"), "prime123");
        // confirm password

        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"), "prime123");
        //click on login button

        clickOnElement(By.xpath("//input[@class='button'and @value='Register']"));
        //varify account overview text display
        String expectedmessage = "Your account was created successfully. You are now logged in.";

        String actualmessage1 = getTextFromElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
        //  Assert message compare actual and expected
        Assert.assertEquals("Your account was created successfully. You are now logged in.", expectedmessage, actualmessage1);


    }


}
