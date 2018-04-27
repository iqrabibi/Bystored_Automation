package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by VenD on 4/21/2018.
 */
public class MyFinanceObjects {
    WebDriver driver;
    loginObjects lo;
    public static By financelink=By.cssSelector("body > section > div > div > div > div > div.col-lg-3.col-md-3.col-sm-3.col-xs-3.hidden-xs.bhoechie-tab-menu > div > a:nth-child(8) > span");

    public static By addFinanceButton=By.id("addNewCard");
    public static By CardHolderName=By.id("cardName");
    public static By cardNumber=By.id("ccnumber");

   public static By expMonth=By.id("cc-exp-month");
    public static By expYear=By.id("cc-exp-year");

    public static By ccvCard=By.id("cardCvv");
    public static By termAgreement=By.id("termsAgreement");
    public static By clcikSubmitButton=By.id("addCard");
    public boolean  responseForAddingCard;
    public static By getResponseForAddingtCrad=By.cssSelector("#cardsContainer > div.credit-detail > form > div:nth-child(2) > label");
    public static By getResponseForDeleteCard=By.cssSelector("#cardsContainer > div.credit-detail > form > div > label");
    public static By deleteButton=By.cssSelector("#cardsContainer > div.credit-detail > form > div:nth-child(2) > div.col-md-3.col-sm-3.col-xs-3.top-right > span:nth-child(1) > img");
    public static By getCardError=By.id("ccnumber-error");
    public String cardInvalidResponse;
    public boolean responseForDeleteCard;
    public String monthYearInvalidResponse;
    public static By getMonthYearError =By.id("cardExpiry-error");
    public static By termOfUse=By.linkText("Terms of Service");
    public static By standrdLiability=By.id("insurancesummary");
    public int a=0;
    public static By downloadinvoices= By.linkText("View invoice");


  public   MyFinanceObjects(WebDriver driver)


  {

      this.driver=driver;
  }

  public void openMyaccountPage(String email,String password) throws InterruptedException {
      lo=new loginObjects(driver);
      lo.openLoginPage();
      Thread.sleep(2000);
      lo.enterDataForLogin(email,password);
      Thread.sleep(2000);
      lo.submit_Button();
  }

public void gOToMyFinance() throws InterruptedException
{
    Thread.sleep(2000);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(financelink) );
    Thread.sleep(2000);
    driver.findElement(financelink).click();
    Thread.sleep(2000);



}
public void addCardOpen() throws InterruptedException

{
    Thread.sleep(2000);
    driver.findElement(addFinanceButton).click();
}

public void enterDataForNewCard(String name,String number, String month,String year,String cvv) throws InterruptedException
    {

        getcardHolderName(name);
        getCardNumber(number);
        getCardExpiryMonth(month);
        getCardExpiryYear(year);
        getCardCvv(cvv);

    }

    public void getcardHolderName(String name) throws  InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(CardHolderName).sendKeys(name);

    }
    public void getCardNumber(String number) throws  InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(cardNumber).sendKeys(number);

    }
    public void getCardExpiryMonth(String date) throws  InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(expMonth).sendKeys(date);

    }
    public void getCardExpiryYear(String year) throws  InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(expYear).sendKeys(year);

    }
    public void getCardCvv(String cvv) throws  InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(ccvCard).sendKeys(cvv);

    }

    public void clickAggrement() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(termAgreement).click();
    }
    public void clickSubmitButton() throws InterruptedException
    {

        Thread.sleep(2000);
        driver.findElement(clcikSubmitButton).click();

    }

    public boolean getResonseForAddingCard() throws InterruptedException
    {
        Thread.sleep(2000);
       responseForAddingCard= driver.findElement(getResponseForAddingtCrad).isDisplayed();
        return responseForAddingCard;
    }


    public boolean finddeleteButton() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(deleteButton).click();
        Thread.sleep(2000);
        responseForDeleteCard=driver.findElement(getResponseForDeleteCard).isDisplayed();
        return responseForDeleteCard;

    }


    public void enterDataForInvalidCardNumber(String name,String number,String month)throws InterruptedException
    {
        getcardHolderName(name);
        getCardNumber(number);
        getCardExpiryMonth(month);
    }

    public String getResponseForInvalidCardNumber() throws InterruptedException

    {
        Thread.sleep(2000);
      cardInvalidResponse=  driver.findElement(getCardError).getText();
        return cardInvalidResponse;

    }
    public void pageRefreshes() throws InterruptedException
    {
        driver.navigate().refresh();
    }

    public String getResponseForInvalidMonthYear() throws InterruptedException
    {
        Thread.sleep(2000);
        monthYearInvalidResponse=driver.findElement(getMonthYearError).getText();
        return monthYearInvalidResponse;
    }


    public int getTermOfUsePage() throws InterruptedException
    {

        String parentHandle1 = driver.getWindowHandle(); // get the current window handle
        System.out.println(parentHandle1);               //Prints the parent window handle
        driver.findElement(termOfUse).click();//Assuming u are clicking on a link which opens a new browser window
        Thread.sleep(5000);                              //Clicking on this window
        for (String winHandle : driver.getWindowHandles()) { //Gets the new window handle
            System.out.println(winHandle);

            driver.switchTo().window(winHandle);

            a=a+1;
            // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        driver.close();                                 // close newly opened window when done with it
        driver.switchTo().window(parentHandle1);
        Thread.sleep(3000);


        String parentHandle2 = driver.getWindowHandle(); // get the current window handle
        System.out.println(parentHandle2);               //Prints the parent window handle
        driver.findElement(standrdLiability).click();//Assuming u are clicking on a link which opens a new browser window
        Thread.sleep(5000);                              //Clicking on this window
        for (String winHandle : driver.getWindowHandles()) { //Gets the new window handle
            System.out.println(winHandle);

            driver.switchTo().window(winHandle);
            a=a+1;
            // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        driver.close();                                 // close newly opened window when done with it
        driver.switchTo().window(parentHandle1);
        Thread.sleep(3000);



//        String parentHandle2 = driver.getWindowHandle(); // get the current window handle
//        System.out.println(parentHandle2);               //Prints the parent window handle
//
//        driver.findElement(standrdLiability).click();//Assuming u are clicking on a link which opens a new browser window
//
//        Thread.sleep(5000);                              //Clicking on this window
//        for (String winHandle : driver.getWindowHandles()) { //Gets the new window handle
//            System.out.println(winHandle);
//            driver.switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)
//        }



//Now your driver works on the current new handle
//Do some work here.....
//Time to go back to parent window
                                      // close newly opened window when done with it






       // driver.navigate().to("http://qa1.bystored.com/myStored/finance");
       // driver.navigate().back();





        return a;

    }


    public void downloadClick()throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(downloadinvoices).click();

    }


    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag=true;
        }

        return flag;
    }

}
