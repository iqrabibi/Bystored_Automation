package Testcases;

import General.Main;
import PageObjects.loginObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by VenD on 4/16/2018.
 */
public class LoginFlows extends Main{


  //  WebDriver driver=getDriver();
    loginObjects log;
    public String  email="iqrabibi25@yahoo.com";
    public String invalidEmail="by@bystored.com";

    public String password="bystored";

    public String invalidPassowrd="by12345";
    public String actualForForgetPassword;
    public boolean actualForLogin;
    public boolean  actualForForgetPasswordForInvalidEmail;
    public String expectedForForgetPassword="A link to update your password has been sent to your email address.";
    public String actualForInvalidEmailForLogin;
    public String expectedForInvalidEmailForLogin="No such User Found.";
    public String actualForInvalidPasswordForLogin;
    public String expectedForInvalidPasswordForLogin="Invalid username or password";
   // public String expectedForForgetPasswordForInvalidEmail="Sorry, we couldn't find your email address\n"+"in our system.";





    @Test
    public void forgetPasswordTestCasesHappyFlow() throws InterruptedException
    {

        log=new loginObjects(driver);
        log.openLoginPage();
        Thread.sleep(2000);
        actualForForgetPassword =log.forget_password(email);

        Assert.assertEquals(""+expectedForForgetPassword,""+actualForForgetPassword);
        System.out.print("\n Actual For forget password\n"+actualForForgetPassword+"\n Expected For forget password\n"+expectedForForgetPassword);

    }
    @Test
    public void forgetPasswordForInvalidEmail() throws InterruptedException
    {
        log=new loginObjects(driver);
        log.openLoginPage();
        Thread.sleep(2000);
        actualForForgetPasswordForInvalidEmail=log.forgetPasswordForInvalidEmail(invalidEmail);
        Assert.assertTrue(actualForForgetPasswordForInvalidEmail);

    }




    @Test
    public void loginTestCasesHappyFlow()throws InterruptedException
    {

        log=new loginObjects(driver);
        log.openLoginPage();
        Thread.sleep(2000);
        log.enterDataForLogin(email,password);
        Thread.sleep(2000);
        actualForLogin = log.submit_login_button();
        Thread.sleep(2000);
        log.logoutButton();
        Thread.sleep(2000);
        Assert.assertTrue(actualForLogin);
        System.out.print("\n"+actualForLogin);


    }
    @Test
    public void logintestcasesForInvalidEmail() throws InterruptedException
    {
        log=new loginObjects(driver);
        log.openLoginPage();
        Thread.sleep(2000);
        actualForInvalidEmailForLogin=log.enterDataForInvalidEmailForLogin(invalidEmail,password);

        Thread.sleep(2000);
        Assert.assertEquals(""+expectedForInvalidEmailForLogin,""+actualForInvalidEmailForLogin);
        System.out.print("\n Actual For login test cases For Invalid Email\n"+actualForInvalidEmailForLogin+"\n Expected For login test cases For Invalid Email\n"+expectedForInvalidEmailForLogin);



    }
    @Test
    public void loginTestCasesForInvalidPassword() throws  InterruptedException
    {
        log=new loginObjects(driver);
        log.openLoginPage();
        Thread.sleep(2000);
        actualForInvalidPasswordForLogin=log.enterDateForInvalidPasswordForLogin(email,invalidPassowrd);
        Assert.assertEquals(""+expectedForInvalidPasswordForLogin,""+actualForInvalidPasswordForLogin);
        System.out.print("\n Actual For login Test Cases For Invalid Password\n"+expectedForInvalidPasswordForLogin+"\n Expected For login Test Cases For Invalid Password\n"+expectedForInvalidPasswordForLogin);


    }





}
