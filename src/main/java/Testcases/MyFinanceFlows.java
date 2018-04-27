package Testcases;

import General.Main;
import PageObjects.MyFinanceObjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by VenD on 4/22/2018.
 */
public class MyFinanceFlows extends Main {
    MyFinanceObjects mfo;
    String url=getUrl();
    public String email = "iqrabibi25@yahoo.com";
    public String password = "bystored";
    public String name = "iqra";
    public String number = "4242424242424242";
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
    public  String downloadPath = "C:\\Users\\VenD\\Downloads";

    public boolean responseForDownloadInvoices;




    @Test

    public void MyFinnaceHappyFlowForAddingAccount() throws InterruptedException {

        mfo = new MyFinanceObjects(driver);
        Thread.sleep(2000);
        mfo.openMyaccountPage(email, password,url);
        Thread.sleep(2000);
        mfo.gOToMyFinance();
        Thread.sleep(2000);
        mfo.addCardOpen();
        Thread.sleep(2000);
        mfo.enterDataForNewCard(name, number, month, year, cvvCode);
        Thread.sleep(2000);
        mfo.clickAggrement();
        Thread.sleep(2000);
        mfo.clickSubmitButton();
        Thread.sleep(3000);

        actualForAddingCard = mfo.getResonseForAddingCard();
        Assert.assertTrue(actualForAddingCard);
        System.out.print(actualForAddingCard);
        Thread.sleep(5000);
        mfo.pageRefreshes();


    }
    @Test

    public void deleteCreditCard() throws InterruptedException {

        mfo = new MyFinanceObjects(driver);
        Thread.sleep(2000);
        actualForDeleteCard = mfo.finddeleteButton();
        Assert.assertTrue(actualForDeleteCard);
        System.out.print(actualForDeleteCard);
        Thread.sleep(5000);
        mfo.pageRefreshes();


    }
    @Test

    public void negativeCasesForCardNumber() throws InterruptedException
    {
        mfo = new MyFinanceObjects(driver);
        Thread.sleep(2000);
        mfo.addCardOpen();
        Thread.sleep(2000);
        mfo.enterDataForInvalidCardNumber(name,invalidNumber,month);
        Thread.sleep(2000);
        actualForInvalidCardNumber=mfo.getResponseForInvalidCardNumber();
        Thread.sleep(2000);
        Assert.assertEquals(""+expectedForInvalidCardNumber,""+actualForInvalidCardNumber);
        System.out.print("\n Actual For negative cases for card number\n"+actualForInvalidCardNumber+"\n Expected Fornegative cases for card number\n"+expectedForInvalidCardNumber);
        Thread.sleep(5000);
        mfo.pageRefreshes();



    }
    @Test
    public void negativeCasesForMonthYear() throws InterruptedException
    {
        mfo = new MyFinanceObjects(driver);
        Thread.sleep(2000);
        mfo.addCardOpen();
        Thread.sleep(2000);
        mfo.enterDataForNewCard(name,number,invalidMonth,invalidYear,cvvCode);
        Thread.sleep(2000);
        actualForInvalidMonthYear=mfo.getResponseForInvalidMonthYear();
        Assert.assertEquals(""+expectedForInvalidMonthYear,""+actualForInvalidMonthYear);
        System.out.print("\n Actual For negative cases for Month year for credit card\n"+actualForInvalidMonthYear+"\nFor negative cases for Month year for credit card\n"+expectedForInvalidCardNumber);
        Thread.sleep(5000);




    }
    @Test

    public void termOfUse() throws InterruptedException
    {
        mfo = new MyFinanceObjects(driver);
        Thread.sleep(2000);
        actualForTermOfUse=mfo.getTermOfUsePage();
        Assert.assertEquals(""+expectedForTermOfUse,""+actualForTermOfUse);
        System.out.print("\n Actual For term of use\n"+actualForTermOfUse+"\n Expected For term of use\n"+expectedForTermOfUse);
        Thread.sleep(5000);
        mfo.pageRefreshes();


    }
    @Test
    public void downloadInvoices()throws InterruptedException
    {


        mfo = new MyFinanceObjects(driver);
        Thread.sleep(2000);
        mfo.downloadClick();
        Thread.sleep(2000);
        Assert.assertTrue(mfo.isFileDownloaded(downloadPath, "invoice-7647.pdf"), "Failed to download Expected document");


    }





}

