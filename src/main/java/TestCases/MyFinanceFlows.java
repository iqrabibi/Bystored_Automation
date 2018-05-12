package TestCases;

import General.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static General.InitMethods.My_Finanace_Object;
import static General.InitMethods.Url;
import static General.InitMethods.downloadPath;



/**
 * Created by VenD on 4/22/2018.
 */
public class MyFinanceFlows extends Main {
    //MyFinanceObjects mfo;
    //String url=getUrl();
    public String email = "iqrabibi25@yahoo.com";
    public String password = "bystored";
    public String name = "iqra";
    public String number = "4111111111111111";
    public String month = "10";
    public String year = "2019";
    public String cvvCode = "123";
    public boolean actualForAddingCard;
    public boolean actualForDeleteCard;
    public String invalidNumber="1234568212222";
    public String invalidMonth="25";
    public String invalidYear="2015";
    public String actualForInvalidCardNumber;
    public String expectedForInvalidCardNumber="Invalid card number";
    public String actualForInvalidMonthYear;
    public String expectedForInvalidMonthYear="Credit expiry date is invalid.";
    public int expectedForTermOfUse=4;
    public int actualForTermOfUse;
    public String invoicesId;
    public String invRefrence;
 //  public  String downloadingPath = "C:\\Users\\VenD\\Downloads";

    public boolean responseForDownloadInvoices;




    @Test

    public void MyFinnaceHappyFlowForAddingAccount() throws InterruptedException {

      //  mfo = new MyFinanceObjects(driver);
        Thread.sleep(2000);
      My_Finanace_Object.openMyaccountPage(email, password,Url);
        Thread.sleep(2000);
        My_Finanace_Object.gOToMyFinance();
        Thread.sleep(2000);
        My_Finanace_Object.addCardOpen();
        Thread.sleep(2000);
        My_Finanace_Object.enterDataForNewCard(name, number, month, year, cvvCode);
        Thread.sleep(2000);
        My_Finanace_Object.clickAggrement();
        Thread.sleep(2000);
        My_Finanace_Object.clickSubmitButton();
        Thread.sleep(3000);

        actualForAddingCard = My_Finanace_Object.getResonseForAddingCard();
        Assert.assertTrue(actualForAddingCard);
        System.out.print(actualForAddingCard);
        Thread.sleep(5000);
        My_Finanace_Object.pageRefreshes();


    }
    @Test

    public void deleteCreditCard() throws InterruptedException {

       // My_Finanace_Object = new MyFinanceObjects(driver);
        Thread.sleep(2000);
        actualForDeleteCard = My_Finanace_Object.finddeleteButton();
        Assert.assertTrue(actualForDeleteCard);
        System.out.print(actualForDeleteCard);
        Thread.sleep(5000);
        My_Finanace_Object.pageRefreshes();


    }
    @Test

    public void negativeCasesForCardNumber() throws InterruptedException
    {
      //  mfo = new MyFinanceObjects(driver);
        Thread.sleep(2000);
        My_Finanace_Object.addCardOpen();
        Thread.sleep(2000);
        My_Finanace_Object.enterDataForInvalidCardNumber(name,invalidNumber,month);
        Thread.sleep(2000);
        actualForInvalidCardNumber=My_Finanace_Object.getResponseForInvalidCardNumber();
        Thread.sleep(2000);
        Assert.assertEquals(""+expectedForInvalidCardNumber,""+actualForInvalidCardNumber);
        System.out.print("\n Actual For negative cases for card number\n"+actualForInvalidCardNumber+"\n Expected Fornegative cases for card number\n"+expectedForInvalidCardNumber);
        Thread.sleep(5000);
        My_Finanace_Object.pageRefreshes();



    }
    @Test
    public void negativeCasesForMonthYear() throws InterruptedException
    {
        //My_Finanace_Object= new MyFinanceObjects(driver);
        Thread.sleep(2000);
        My_Finanace_Object.addCardOpen();
        Thread.sleep(2000);
        My_Finanace_Object.enterDataForNewCard(name,number,invalidMonth,invalidYear,cvvCode);
        Thread.sleep(2000);
        actualForInvalidMonthYear=My_Finanace_Object.getResponseForInvalidMonthYear();
        Assert.assertEquals(""+expectedForInvalidMonthYear,""+actualForInvalidMonthYear);
        System.out.print("\n Actual For negative cases for Month year for credit card\n"+actualForInvalidMonthYear+"\nFor negative cases for Month year for credit card\n"+expectedForInvalidCardNumber);
        Thread.sleep(5000);




    }
    @Test

    public void termOfUse() throws InterruptedException
    {
        //mfo = new MyFinanceObjects(driver);
        Thread.sleep(2000);
        actualForTermOfUse=My_Finanace_Object.getTermOfUsePage();
        Assert.assertEquals(""+expectedForTermOfUse,""+actualForTermOfUse);
        System.out.print("\n Actual For term of use\n"+actualForTermOfUse+"\n Expected For term of use\n"+expectedForTermOfUse);
        Thread.sleep(5000);
        My_Finanace_Object.pageRefreshes();


    }
    @Test
    public void downloadInvoices()throws InterruptedException
    {


        Thread.sleep(2000);
        My_Finanace_Object.openMyaccountPage(email, password,Url);
        Thread.sleep(2000);
        My_Finanace_Object.gOToMyFinance();
      //  Thread.sleep(2000);
       // My_Finanace_Object = new MyFinanceObjects(driver);
        Thread.sleep(2000);
        My_Finanace_Object.downloadClick();
        Thread.sleep(2000);
      //  invoicesId=driver.findElement(By.linkText("View invoice")).getText();
        WebElement element3 = driver.findElement(By.linkText("View invoice"));
        System.out.println(element3.getAttribute("href"));

       invRefrence= element3.getAttribute("href");
        String lastDigitOfRefrence=invRefrence.substring((invRefrence.length()-4));
        System.out.print(lastDigitOfRefrence);
        invoicesId="invoice-"+lastDigitOfRefrence+".pdf";

        System.out.print(downloadPath);
        System.out.print(invoicesId);

        Assert.assertTrue(My_Finanace_Object.isFileDownloaded(downloadPath,invoicesId), "Failed to download Expected document");




    }





}

