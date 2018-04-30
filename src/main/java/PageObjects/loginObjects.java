package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by VenD on 4/16/2018.
 */
public class loginObjects {

    public static By loginButton=By.linkText("LOGIN");
    public static By loginEmail= By.name("email");
    public static By loginPassword=By.name("password");
    public static By loginSubmitButton=By.id("btnLoginSubmit");
    public static By forgetInvalidEmailDetector=By.id("forgotMsg");
    public static By invalidEmailforLogin=By.id("loginErrorMsg");
    public String actualForInvalidEmailForLogin;
    public String actualForInvalidPasswordForLogin;

    //public String email;
    public String password;
    public static By forgetPassword=By.id("forgotPassLink");
    public static By forgotEmail=By.name("forgotEmail");
    public static By forgotLoader=By.xpath("//*[@id=\"forgotModal\"]/div/div/div[2]/div/form/div[4]/span/button");
    public static By forgotCross=By.xpath("//*[@id=\"forgotModal\"]/div/div/div[1]/button/span");
    public static By successMessage=By.id("successMsg");
    public static By homeclass=By.linkText("LOGOUT");
    public String forgetText="Forgot password?";
    public static By forgetTextId=By.cssSelector("#forgotModal > div > div > div.modal-body.fp > div > div.col-xs-12.col-sm-12.col-md-12 > h4");

    public String response;
    public String res;
    public boolean logoutButton;
    public boolean invalidEmailForForgetPasswordText;



    WebDriver driver;
    WebDriverWait wait;


    public loginObjects(WebDriver driver,WebDriverWait wait)


    {
        this.driver=driver;
        this.wait=wait;



    }

    public void openLoginPage(String url) throws InterruptedException{


        driver.navigate().to(url+"login");
        driver.manage().window().maximize();

     // Thread.sleep(2000);
    }

    public void enterDataForLogin(String email, String password) throws InterruptedException{



        wait.until(ExpectedConditions.presenceOfElementLocated(loginSubmitButton));

        getEmail(email);
      // Thread.sleep(1000);
        getPassword(password);
      // Thread.sleep(1000);


    }

    public void getEmail(String email) throws InterruptedException{
        driver.findElement(loginEmail).sendKeys(email);
      // Thread.sleep(2000);
    }
    public void getPassword(String password)throws InterruptedException
    {
        driver.findElement(loginPassword).sendKeys(password);
     //  Thread.sleep(2000);
    }

    public Boolean submit_login_button() throws InterruptedException
    {
        driver.findElement(loginSubmitButton).click();
       // Thread.sleep(8000);
        wait.until(ExpectedConditions.presenceOfElementLocated(homeclass));
        logoutButton= driver.findElement(homeclass).isDisplayed();
      // Thread.sleep(2000);
        return logoutButton;


    }

    public String forget_password(String email) throws InterruptedException
    {

        Thread.sleep(2000);
       //wait.until(ExpectedConditions.presenceOfElementLocated(loginSubmitButton));
        //wait.until(ExpectedConditions.presenceOfElementLocated(forgetPassword));
        setPassword();

       // wait.until(ExpectedConditions.textToBe(forgetTextId,forgetText));
      //  wait.until((ExpectedConditions.presenceOfElementLocated(forgotEmail)));

        setEmail(email);
       // wait.until(ExpectedConditions.presenceOfElementLocated(forgotLoader));
        res=clickResetPassword();
        System.out.print(res);
       // wait.until(ExpectedConditions.presenceOfElementLocated(forgotCross));
        clickCloseButton();
        return  res;


    }
    public void setPassword() throws InterruptedException
    {

        driver.findElement(forgetPassword).click();
        Thread.sleep(2000);
    }

    public void setEmail(String email) throws InterruptedException
    {


        driver.findElement(forgotEmail).sendKeys(email);
        Thread.sleep(2000);
    }
    public String clickResetPassword()throws InterruptedException
    {
        driver.findElement(forgotLoader).click();
        Thread.sleep(2000);
        //wait.until(ExpectedConditions.textToBe(successMessage,"A link to update your password has been sent to your email address."));
        response=driver.findElement(successMessage).getText();
        Thread.sleep(2000);
        System.out.print(response);
        return  response;

    }
    public void clickCloseButton()throws InterruptedException
    {
        driver.findElement(forgotCross).click();
       Thread.sleep(2000);
    }

    public void logoutButton()throws  InterruptedException
    {
        driver.findElement(homeclass).click();
       // Thread.sleep(2000);
    }
    public boolean forgetPasswordForInvalidEmail(String email) throws InterruptedException
    {

        setPassword();
        Thread.sleep(2000);
        setEmail(email);
        Thread.sleep(2000);
        driver.findElement(forgotLoader).click();
        Thread.sleep(3000);


       invalidEmailForForgetPasswordText= driver.findElement(forgetInvalidEmailDetector).isDisplayed();
        System.out.print(invalidEmailForForgetPasswordText);

        clickCloseButton();
        Thread.sleep(2000);

        return invalidEmailForForgetPasswordText;
    }
    public void submit_Button() throws InterruptedException
    {
        driver.findElement(loginSubmitButton).click();
        Thread.sleep(2000);
    }
    public String enterDataForInvalidEmailForLogin(String email,String password) throws InterruptedException
    {
        getEmail(email);
        getPassword(password);
        submit_Button();
        actualForInvalidEmailForLogin=driver.findElement(invalidEmailforLogin).getText();
        return actualForInvalidEmailForLogin;

    }
    public String enterDateForInvalidPasswordForLogin(String email,String password) throws InterruptedException
    {
        getEmail(email);
        Thread.sleep(2000);
        getPassword(password);
        submit_Button();
        Thread.sleep(2000);
        actualForInvalidPasswordForLogin=driver.findElement(invalidEmailforLogin).getText();
        return actualForInvalidPasswordForLogin;

    }


}
