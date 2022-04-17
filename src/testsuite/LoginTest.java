package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl ="https://courses.ultimateqa.com/";
    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully (){
        //signin elements
        WebElement signinField=driver.findElement(By.linkText("Sign In"));
        signinField.click();

        //actual result
        WebElement actualresult = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualmsg = actualresult.getText();
        System.out.println(actualmsg);

        //expectedresult
        String expectedmsg = "Welcome Back!";

        //match actual and expected result
        Assert.assertEquals("",actualmsg, expectedmsg);
    }
    @Test
    public void verifyTheErrorMessage(){
        //signin elements
        WebElement signinField=driver.findElement(By.linkText("Sign In"));
        signinField.click();

        //emailfield element
        WebElement emailField = driver.findElement(By.name("user[email]"));
        emailField.sendKeys("mac123@gmail.com");

        //Password element
        WebElement PasswordField = driver.findElement(By.id("user[password]"));
        PasswordField.sendKeys("mac123");

        //signin element
        WebElement signinField1= driver.findElement(By.xpath("//div/input[@value='Sign in']"));
        signinField1.click();


        //actual result
        WebElement actualresult = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualmsg = actualresult.getText();
        System.out.println(actualmsg);

        //expectedresult
        String expectedmsg = "Invalid email or password";

        //match actual and expected result
        Assert.assertEquals("",actualmsg, expectedmsg);

    }
    @After
    //Here After method for close the browser
    public void teardown() {
        //closebrowser();
    }

}
