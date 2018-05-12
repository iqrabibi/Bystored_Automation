package TestCases;

import General.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

import static General.InitMethods.Url;
import static General.InitMethods.My_Info_Object;


/**
 * Created by VenD on 4/25/2018.
 */
public class MyinfoFlows extends Main {

  //  MyInfoObjects in;
   // String url=getUrl();

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
        //in=new MyInfoObjects(driver);
        Thread.sleep(2000);
      My_Info_Object.openMyAccountPage(email,pasword,Url);
        Thread.sleep(2000);
        My_Info_Object.gotoMyInfoPage();
        Thread.sleep(2000);
        My_Info_Object.openPasswordReset();
        Thread.sleep(2000);
        My_Info_Object. enterPassword( newPassword,reNewInvalidPassword);
        Thread.sleep(2000);
        My_Info_Object.clickSubmitButton();
        actualForInvalidPassword=My_Info_Object.getResponseForReInvalidPassword();
        Assert.assertEquals(""+expectedForInvalidPassword,""+actualForInvalidPassword);
        System.out.print("\n Actual For invalid Reset Password \n"+actualForInvalidPassword+"\n Expected For invalid Reset Password\n"+expectedForInvalidPassword);
        Thread.sleep(2000);
        My_Info_Object.pageRefreshes();


    }

    @Test
    public void updatefields() throws InterruptedException
    {
       // in=new MyInfoObjects(driver);
        Thread.sleep(2000);
        My_Info_Object.update(name,phonenumber);
        My_Info_Object.clickSubmitButton();
        actualForUpdate=My_Info_Object.getResponseForUpdate();
        Assert.assertEquals(""+expectedForUpdate,""+actualForUpdate);
        System.out.print("\n Actual For update fields \n"+actualForUpdate+"\n Expected For update fields\n"+actualForUpdate);
        Thread.sleep(2000);
        My_Info_Object.pageRefreshes();




    }
    @Test
    public void reSetPassword() throws InterruptedException
    {
        My_Info_Object.openPasswordReset();
        Thread.sleep(2000);
        My_Info_Object. enterPassword( newPassword,reNewPassword);
        Thread.sleep(2000);
        My_Info_Object.clickSubmitButton();
        actualForResetPassword=My_Info_Object.getResponseForResetPassword();
     //   in.clickLogoutButton();
        Assert.assertEquals(""+actualForResetPassword,""+expectedForResetPassword);
        System.out.print("\n Actual For reset password happpy flow \n"+actualForResetPassword+"\nExpected For reset password happpy flow\n"+expectedForResetPassword);
        Thread.sleep(2000);




    }


}
