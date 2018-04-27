package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * Created by VenD on 4/16/2018.
 */
public class Main {

   public  static WebDriver driver;

  @BeforeTest
  public  static  WebDriver getDriver()
  {
      System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
      driver = new ChromeDriver();
      //driver.navigate().to("http://qa1.bystored.com/");
      //
      return driver;

  }





    @AfterTest
    public static  void closeDriver()

    {
        driver.close();
    }
}
