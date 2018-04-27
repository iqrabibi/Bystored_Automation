package PageObjects;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by VenD on 4/16/2018.
 */
public class BusinessPageObjects {

    static WebDriver driver;

    public  String firstName;
    public  String lastname;
    public  String email;
    public  String phoneNumber;
    public String description;
    public String actualResult;
    public String actualForInvalidEmail;
    public String actulaForInvalidPhoneNumber;


   // public static By businessLink=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]");
    public static By getInTouchButton=By.cssSelector("body > section.business-storage > div > div.text-center > a");
    public static By Name=By.name("firstName");
    public static By lName=By.name("lastName");
    public static By Email=By.name("email");
    public static By PhoneNumber=By.name("phoneNumber");
    public static By message=By.name("message");
    public static By clickSubmit=By.id("drop-note-submit");
    public static By actualText=By.className("modal-body");
    public static By crossButton=By.xpath("//*[@id=\"dropNoteSubmitModal\"]/div/div/div[1]/button/span");
    public static By invalidEmailTextDetection=By.id("email-error");
    public static By invalidPhoneNumberTextDetection=By.id("phoneNumber-error");

    public BusinessPageObjects(WebDriver driver)

    {
        this.driver=driver;
    }
    public void openBusinessPage() throws InterruptedException{



       driver.navigate().to("http://qa1.bystored.com/business");
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }
    public void goToForm() throws InterruptedException{
        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(getInTouchButton) );

        Thread.sleep(2000);
        driver.findElement(getInTouchButton).click();
        Thread.sleep(2000);
    }
    public  void enterBusinessDetailForHappyFlow(String firstName,String lastname,String email,String phoneNumber,String description) throws InterruptedException

    {

        getfirstName(firstName);
        getlastName(lastname);
        getemail(email);
        getphoneNumber(phoneNumber);
        getdescription(description);

    }
    public void enterBusinessDetailsForInvalidEmail(String firstName,String lastname,String email,String phoneNumber) throws InterruptedException
    {
        getfirstName(firstName);
        getlastName(lastname);
        getemail(email);
        getphoneNumber(phoneNumber);
    }


    public  void getfirstName(String firstName) throws InterruptedException
    {
        driver.findElement(Name).sendKeys(firstName);
        Thread.sleep(2000);

    }


    public  void getlastName(String lastname) throws InterruptedException
    {
        driver.findElement(lName).sendKeys(lastname);
        Thread.sleep(2000);

    }
    public  void getemail(String email) throws InterruptedException

    {

        driver.findElement(Email).sendKeys(email);
        Thread.sleep(2000);

    }
    public  void getphoneNumber(String phoneNumber) throws InterruptedException
    {
        driver.findElement(PhoneNumber).sendKeys(phoneNumber);
        Thread.sleep(2000);

    }
    public  void getdescription(String description) throws InterruptedException
    {
        driver.findElement(message).sendKeys(description);
        Thread.sleep(2000);

    }

    public String submitButton() throws InterruptedException
    {
        driver.findElement(clickSubmit).click();
        Thread.sleep(2000);
        actualResult=driver.findElement(actualText).getText();
        Thread.sleep(2000);
        driver.findElement(crossButton).click();
        return actualResult;

    }
    public String invalidEmailText() throws InterruptedException
    {

        Thread.sleep(2000);
        actualForInvalidEmail=driver.findElement(invalidEmailTextDetection).getText();
        Thread.sleep(2000);
        return actualForInvalidEmail;
    }
    public String invalidPhoneNumberText() throws InterruptedException
    {
        Thread.sleep(2000);
        actulaForInvalidPhoneNumber=driver.findElement(invalidPhoneNumberTextDetection).getText();
        Thread.sleep(2000);
        return actulaForInvalidPhoneNumber;
    }

    public void pageRefreshes() throws InterruptedException
    {
        driver.navigate().refresh();
    }

}
