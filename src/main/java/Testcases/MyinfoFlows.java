package Testcases;

import General.Main;
import PageObjects.MyInfoObjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.PackageUtils;

/**
 * Created by VenD on 4/25/2018.
 */
public class MyinfoFlows extends Main {

    MyInfoObjects in;
    String url=getUrl();

    public String email="iqrabibi25@yahoo.com";
    public String pasword ="bystored";
    public String newPassword="iqrabibi";
    public String reNewPassword="iqrabibi";
    public String reNewInvalidPassword="iqra1234";
    public String actualForInvalidPassword;
    public String expectedForInvalidPassword="Passwords do not match";
    public String name="Aroma Gul";
    public String phonenumber="021 33698754";
    public String expectedForUpdate="Profile Updated Successfully";
    public String actualForUpdate;
    public String actualForResetPassword;
    public String expectedForResetPassword="Password Changed Successfully";


    @Test
    public void NegativeCaseForResetPassword() throws  InterruptedException
    {
        in=new MyInfoObjects(driver);
        Thread.sleep(2000);
        in.openMyAccountPage(email,pasword,url);
        Thread.sleep(2000);
        in.gotoMyInfoPage();
        Thread.sleep(2000);
        in.openPasswordReset();
        Thread.sleep(2000);
        in. enterPassword( newPassword,reNewInvalidPassword);
        Thread.sleep(2000);
        in.clickSubmitButton();
        actualForInvalidPassword=in.getResponseForReInvalidPassword();
        Assert.assertEquals(""+expectedForInvalidPassword,""+actualForInvalidPassword);
        System.out.print("\n Actual For invalid Reset Password \n"+actualForInvalidPassword+"\n Expected For invalid Reset Password\n"+expectedForInvalidPassword);
        Thread.sleep(2000);
        in.pageRefreshes();


    }

    @Test
    public void updatefields() throws InterruptedException
    {
        in=new MyInfoObjects(driver);
        Thread.sleep(2000);
        in.update(name,phonenumber);
        in.clickSubmitButton();
        actualForUpdate=in.getResponseForUpdate();
        Assert.assertEquals(""+expectedForUpdate,""+actualForUpdate);
        System.out.print("\n Actual For update fields \n"+actualForUpdate+"\n Expected For update fields\n"+actualForUpdate);
        Thread.sleep(2000);
        in.pageRefreshes();




    }
    @Test
    public void reSetPassword() throws InterruptedException
    {
        in.openPasswordReset();
        Thread.sleep(2000);
        in. enterPassword( newPassword,reNewPassword);
        Thread.sleep(2000);
        in.clickSubmitButton();
        actualForResetPassword=in.getResponseForResetPassword();
     //   in.clickLogoutButton();
        Assert.assertEquals(""+actualForResetPassword,""+expectedForResetPassword);
        System.out.print("\n Actual For reset password happpy flow \n"+actualForResetPassword+"\nExpected For reset password happpy flow\n"+expectedForResetPassword);
        Thread.sleep(2000);




    }


}
