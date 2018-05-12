package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static General.InitMethods.Login_Object;

/**
 * Created by VenD on 4/25/2018.
 */
public class MyInfoObjects {
    WebDriver driver;
   // WebDriverWait wait;
   // LoginObjects lo;
    public static By infoLink= By.cssSelector("body > section > div > div > div > div > div.col-lg-3.col-md-3.col-sm-3.col-xs-3.hidden-xs.bhoechie-tab-menu > div > a:nth-child(7) > span");
      public static By resetLink=By.id("changePasswordSection");
    public static By newPasswordField=By.id("password");
    public static By rePasswordField=By.id("confirmPassword");
    public static By submitButton=By.id("profileSubmit");
    public String getInvalidPasswordResponse;
    public static By invalidPasswordError=By.id("confirmPassword-error");
    public static By firstName=By.id("firstName");
    public static By phoneNumber=By.id("phone");
    public String updateResponseMessage;
    public static By updateResponse=By.id("successMessage");
    public String getResetPasswordresponse;
    public static By resetresponse=By.id("successMessage");
    public static By logoutButton=By.cssSelector("#new-header-links > li.login-btn > a");
    //public static By upperMove=By.cssSelector("body > div.quote-header.hidden-xs > div");



    public MyInfoObjects(WebDriver driver)

    {
        this.driver=driver;
    }

    public void openMyAccountPage(String email,String password,String url) throws InterruptedException
    {
       // lo=new LoginObjects(driver);
        Login_Object.openLoginPage(url);
        Thread.sleep(3000);
        Login_Object.enterDataForLogin(email,password);
        Thread.sleep(2000);
        Login_Object.submit_Button();
    }

    public void gotoMyInfoPage() throws InterruptedException
    {

        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(infoLink) );
        Thread.sleep(2000);
        driver.findElement(infoLink).click();
        Thread.sleep(2000);
    }

    public void openPasswordReset() throws InterruptedException
    {

        Thread.sleep(2000);
        driver.findElement(resetLink).click();
        Thread.sleep(2000);

    }

    public void enterPassword(String newPassword,String rePasssword) throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(newPasswordField).sendKeys(newPassword);
        Thread.sleep(2000);
        driver.findElement(rePasswordField).sendKeys(rePasssword);
        Thread.sleep(2000);

    }
    public void clickSubmitButton() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(submitButton).click();
        Thread.sleep(2000);
    }

    public String getResponseForReInvalidPassword() throws InterruptedException
    {
        Thread.sleep(2000);
        getInvalidPasswordResponse=driver.findElement(invalidPasswordError).getText();
        Thread.sleep(2000);
        return getInvalidPasswordResponse;

    }

    public void pageRefreshes() throws InterruptedException
    {
        driver.navigate().refresh();
    }

    public void update(String name,String Number) throws InterruptedException
    {
        driver.findElement(firstName).clear();
        Thread.sleep(2000);
        driver.findElement(firstName).sendKeys(name);
        Thread.sleep(2000);
        driver.findElement(phoneNumber).clear();
        Thread.sleep(2000);
        driver.findElement(phoneNumber).sendKeys(Number);
        Thread.sleep(3000);
    }

    public String  getResponseForUpdate() throws InterruptedException
    {
        Thread.sleep(2000);
        updateResponseMessage=driver.findElement(updateResponse).getText();
        Thread.sleep(2000);
        return updateResponseMessage;

    }

    public String getResponseForResetPassword() throws InterruptedException
    {
        Thread.sleep(2000);
        getResetPasswordresponse=driver.findElement(resetresponse).getText();
        Thread.sleep(2000);
        return getResetPasswordresponse;
    }

//    public void clickLogoutButton() throws InterruptedException
//    {
//        Thread.sleep(3000);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(logoutButton));
//        Thread.sleep(2000);
//        driver.findElement(logoutButton).click();
//        Thread.sleep(2000);
//    }

}


