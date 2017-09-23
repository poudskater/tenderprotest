package gui_test;

import Pages.MainPage;
import Pages.TendersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TenderPageTest {

    private  WebDriver driver;
    @BeforeTest
    public void initDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://tender.pro");
    }
    @Test
    public void TenderIDSearchTest(){
        MainPage mainPage = new MainPage(driver);
        TendersPage tendersPage = mainPage.selectTenersTab();
        Assert.assertEquals(tendersPage.getTitle(), "Закупки и тендеры");
        tendersPage.enterTenderID("12345");
        tendersPage.clickSearchButton();
        int rowCount=tendersPage.searchResultList.getNumberOfRows();
        Assert.assertEquals(rowCount,1);
        String id = tendersPage.searchResultList.getID(1);
        Assert.assertEquals(id,"12345");


    }
}
