package General;

import  com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;




import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.lang.reflect.Method;
//import static General.InitMethods.Environment;

//import static General.InitMethods.Url;


/**
 * Created by VenD on 4/16/2018.
 */
public class Main {

   public  static WebDriver driver;
  public static WebDriverWait wait;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    //public  String  url;


//    public void getUrl()
//    {
//    //   return Url;
//    }


    @BeforeSuite
    public void startReport() {
        extentReports = new ExtentReports(System.getProperty("user.dir") + "/test-output/BystoredAutomation.html", true);
        extentReports.addSystemInfo("Host Name", "Bystored")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Iqra Bibi");
        extentReports.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));


    }

    @BeforeTest
  public  static  void getDriver()
  {
      System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
      driver = new ChromeDriver();



     wait= new WebDriverWait(driver,15);

      //driver.navigate().to("http://qa1.bystored.com/");


  }

  @BeforeMethod

  public static void beforeMethodCode(Method method)

  {
      extentTest = extentReports.startTest(method.getName(), "");
  }






    @AfterMethod(alwaysRun = true)
    public void QuitDriver(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(LogStatus.FAIL, "Test Case Failed reason is: " + result.getThrowable());
            // extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(Screenshots.takeScreenshot(result.getMethod().getMethodName())));

        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
        } else {
            extentTest.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Passed");
        }

        extentReports.endTest(extentTest);
       // driver.quit();
    }







    @AfterTest
    public static  void closeDriver()

    {
        driver.close();

    }

    @AfterSuite
    public void endReport() {
        extentReports.flush();
        extentReports.close();
    }


}
