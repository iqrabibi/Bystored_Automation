package Testcases;

import General.Main;
import PageObjects.BusinessPageObjects;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static General.Main.getDriver;
import static General.Main.closeDriver;

/**
 * Created by VenD on 4/16/2018.
 */
public class BusinessFlows extends Main{

    BusinessPageObjects bp;
    String url=getUrl();
    public String firstName="iqra";
    public String lastName="bibi";
    public String email="iqrabibi25@yahoo.com";
    public String phoneNumber="0345935256310623";
    public String description="This is my message";
    public String invalidEmail="iqrayahoo.com";
    public String invalidPhoneNumber="eeeeeeeee------";
    public String actualForBusiness;
    public String actualForInvalidEmail;
    public String actualForInvalidPhoneNumber;
    public String expectedForBusiness="Thank you for your enquiry. We will get back to you within one business day.";
    public String expectedForInvalidEmail="Email Address is invalid";
    public String expectedForInvalidPhoneNumber="Please enter a valid number.";


   // @Parameters({ "firstName" ,"lastName","email","phoneNumber","description"})
    @Test
    public  void businessPageHappyFlow() throws InterruptedException
    {

        bp=new BusinessPageObjects(driver);
        bp.openBusinessPage(url);
        Thread.sleep(2000);
        bp.goToForm();
        Thread.sleep(2000);
        bp.enterBusinessDetailForHappyFlow(firstName,lastName,email,phoneNumber,description);
        Thread.sleep(2000);
        actualForBusiness=bp.submitButton();


        Thread.sleep(3000);
        Assert.assertEquals(expectedForBusiness,actualForBusiness);
        System.out.print("\n Expected for business happy flow :\n"+expectedForBusiness+"\n Actual for business happy flow:\n"+actualForBusiness);
        bp.pageRefreshes();
        Thread.sleep(2000);


    }



  // @Parameters({"firstName","lastName","invalidEmail","phoneNumber"})
   @Test
    public void emailValidation() throws InterruptedException
    {

        bp=new BusinessPageObjects(driver);

        bp.goToForm();
        Thread.sleep(2000);
        bp.enterBusinessDetailsForInvalidEmail(firstName,lastName,invalidEmail,phoneNumber);
        Thread.sleep(2000);
        actualForInvalidEmail=bp.invalidEmailText();
        Thread.sleep(2000);
        Assert.assertEquals(expectedForInvalidEmail,actualForInvalidEmail);
        System.out.print("\n Expected for email validation  for business \n"+expectedForInvalidEmail+"\n Actual for email validation for business \n "+actualForInvalidEmail);

        bp.pageRefreshes();
        Thread.sleep(2000);

    }

 // @Parameters({ "firstName" ,"lastName","email","invalidPhoneNumber","description"})
   @Test

    public void phoneNumberValidation() throws  InterruptedException
    {
        bp=new BusinessPageObjects(driver);
        Thread.sleep(2000);
        bp.goToForm();
        Thread.sleep(2000);

        bp.enterBusinessDetailForHappyFlow(firstName,lastName,email,invalidPhoneNumber,description);
        Thread.sleep(2000);
        actualForInvalidPhoneNumber=bp.invalidPhoneNumberText();
        Thread.sleep(2000);
        Assert.assertEquals(expectedForInvalidPhoneNumber,actualForInvalidPhoneNumber);
        System.out.print("\n Expected for phonenumber validation for business\n"+expectedForInvalidPhoneNumber+"\n Actual for phonenumber validation for business\n "+actualForInvalidPhoneNumber);


    }

}
