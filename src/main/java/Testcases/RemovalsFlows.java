package Testcases;

import General.Main;
import PageObjects.RemovalsObjects;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by VenD on 4/19/2018.
 */
public class RemovalsFlows extends Main{

   // WebDriver driver;
    RemovalsObjects ro;
    public String name="iqra";
    public String email="iqrabibi25@yahoo.com";
    public String invalidEmail="yahoo.com";
    public String phonenumber="034569865342";
    public String invalidPhoneNumber="cfgvhbn12352@";
    public String actualForRemovalhappyFlow;
    public String expectedForRemovalHappyFlow="Thank you for your enquiry. We will get back to you within one business day";
    public String actualForInvalidEmailForRemovals;
    public String expectedForInvalidEmailRemovals="Email Address is invalid";
    public String actualForInvalidPhoneNumberForRemovals;
    public String expectedForInvalidPhoneNumberForRemovals="Invalid format.";
    public boolean actualForClickHere;




    @Test

    public void removalstestCasesHappyFlow() throws InterruptedException
    {

        ro = new RemovalsObjects(driver);
        ro.openBrowser();
        ro.enterDataforHappyFlow(name, email, phonenumber);
        Thread.sleep(2000);
        actualForRemovalhappyFlow = ro.submit();
        Thread.sleep(2000);
        Assert.assertEquals(""+actualForRemovalhappyFlow,""+expectedForRemovalHappyFlow);
        System.out.print("\n Actual For happy flows of Removals\n"+actualForRemovalhappyFlow+"\n Expected For happy flows of Removals \n"+expectedForRemovalHappyFlow);

        Thread.sleep(1000);


    }

    @Test
    public void removalForInvalidEmail() throws InterruptedException
    {
        ro = new RemovalsObjects(driver);
        ro.openBrowser();
        Thread.sleep(2000);
       actualForInvalidEmailForRemovals= ro.enterDataForInvalidEmail(name,invalidEmail,phonenumber);

        Thread.sleep(2000);

        Assert.assertEquals(""+actualForInvalidEmailForRemovals,""+expectedForInvalidEmailRemovals);
        System.out.print("\n Actual For invalid Email for login\n"+actualForInvalidEmailForRemovals+"\n Expected For invalid Email for login\n"+expectedForInvalidEmailRemovals);
        Thread.sleep(2000);
    }

    @Test
    public void removalForInvalidPhoneNumber() throws InterruptedException
    {
        ro = new RemovalsObjects(driver);
        ro.openBrowser();
        Thread.sleep(2000);
        actualForInvalidPhoneNumberForRemovals= ro.enterDataForInvalidPhoneNumber(name,email,invalidPhoneNumber);

        Thread.sleep(2000);

        Assert.assertEquals(""+actualForInvalidPhoneNumberForRemovals,""+expectedForInvalidPhoneNumberForRemovals);
        System.out.print("\n Actual For invalid Phonenumber in Removals\n"+actualForInvalidPhoneNumberForRemovals+"\n Expected for invalid Phonenumber in Removals\n"+expectedForInvalidPhoneNumberForRemovals);
        Thread.sleep(2000);
    }

    @Test
    public void removalClickHere() throws InterruptedException
    {
        ro = new RemovalsObjects(driver);
        ro.openBrowser();
        Thread.sleep(2000);
        actualForClickHere=ro.clickhere();
       Assert.assertTrue(actualForClickHere);


    }
}
