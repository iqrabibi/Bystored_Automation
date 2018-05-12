package General;

import PageObjects.*;
import com.aventstack.extentreports.ExtentTest;

import static General.Main.driver;
import static General.Main.wait;


/**
 * Created by VenD on 5/3/2018.
 */
public class InitMethods {
    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();
    public static String Url = appConfig.getUrl();
    public static String downloadPath=appConfig.getDownloadPath();
    public static LoginObjects Login_Object=new LoginObjects(driver);
    public static BusinessPageObjects Business_Object= new BusinessPageObjects(driver,wait);
    public static RemovalsObjects Removals_Object=new RemovalsObjects(driver);
    public static MyFinanceObjects My_Finanace_Object=new MyFinanceObjects(driver);
    public static MyInfoObjects My_Info_Object=new MyInfoObjects(driver);




    public ExtentTest test;
}
