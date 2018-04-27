package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by VenD on 4/19/2018.
 */
public class RemovalsObjects {

    WebDriver driver;
    public static By removalInputName= By.id("clientName");
    public static By removalInputEmail=By.id("clientEmail");
    public  static By removalInputPhoneNumber=By.id("clientPhone");
    public static By removalSubmitButton=By.id("moves-submit");
    public static By remoavlmsg=By.className("modal-body");
    public String response;
    public static By getInvalidEmailText= By.id("clientEmail-error");
    public static By getInvalidPhoneNumberText= By.id("clientPhone-error");
    public static By clickHereText=By.linkText("Click here");
    public static By clickHereNavigate=By.id("btn-less-than");


    public String responseForInvalidEmail;
    public String responseForInvalidPhoneNumber;
    public boolean responseForClickHere;

    public RemovalsObjects(WebDriver driver)

    {
        this.driver=driver;
    }
    public void openBrowser() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.navigate().to("http://qa1.bystored.com/removals");
        driver.manage().window().maximize();
    }
    public void enterDataforHappyFlow(String name,String email,String phonenumber) throws InterruptedException
    {
        getRemovalName(name);

        getRemovalEmail(email);

        getRemovalPhonenumber(phonenumber);



    }
    public void getRemovalName(String name) throws InterruptedException
    {

        driver.findElement(removalInputName).sendKeys(name);
        Thread.sleep(2000);
    }
    public void getRemovalEmail(String email) throws InterruptedException
    {
        driver.findElement(removalInputEmail).sendKeys(email);
        Thread.sleep(2000);

    }
    public void getRemovalPhonenumber(String phonenumber) throws InterruptedException
    {
        driver.findElement(removalInputPhoneNumber).sendKeys(phonenumber);
        Thread.sleep(2000);


    }
    public String submit() throws InterruptedException

    {

        driver.findElement(removalSubmitButton).click();
        Thread.sleep(1000);
        response=driver.findElement(remoavlmsg).getText();
        return response;



    }
    public void submitButton() throws InterruptedException
    {
        driver.findElement(removalSubmitButton).click();
        Thread.sleep(1000);
    }

    public String enterDataForInvalidEmail(String name,String email,String phoneNumber) throws InterruptedException
    {

        getRemovalName(name);
        getRemovalEmail(email);
        getRemovalPhonenumber(phoneNumber);
        submitButton();
        responseForInvalidEmail=driver.findElement(getInvalidEmailText).getText();
        return responseForInvalidEmail;

    }

    public String enterDataForInvalidPhoneNumber(String name,String email,String phoneNumber) throws InterruptedException
    {
        getRemovalName(name);
        getRemovalEmail(email);
        getRemovalPhonenumber(phoneNumber);
        submitButton();
        Thread.sleep(2000);
        responseForInvalidPhoneNumber=driver.findElement(getInvalidPhoneNumberText).getText();
        return responseForInvalidPhoneNumber;

    }

    public boolean clickhere() throws InterruptedException
    {
        driver.findElement(clickHereText).click();
        Thread.sleep(2000);
        responseForClickHere=driver.findElement(clickHereNavigate).isDisplayed();
        return responseForClickHere;
    }



}
