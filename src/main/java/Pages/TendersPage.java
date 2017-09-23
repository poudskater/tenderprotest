package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TendersPage extends Page {
    public SearchResultList searchResultList;

    public TendersPage(WebDriver driver) {
        super(driver);
        searchResultList = new SearchResultList();
    }

    public void enterTenderID(String id) {
        driver.findElement(By.cssSelector("input[name='tender_id']")).sendKeys(id);
    }

    public void clickSearchButton() {
        driver.findElement(By.cssSelector(".formHolder button[type='submit']")).click();
    }

    public class SearchResultList {
    public int getNumberOfRows(){
    return driver.findElements(By.cssSelector(".baseTable tbody tr")).size();
    }

    public String getID(int row){
        String css= String.format(".baseTable tbody tr:nth-of-type(%d) td:nth-of-type(1)",row);
        return driver.findElement(By.cssSelector(css)).getText();
    }
    }

}
