package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

 public TendersPage selectTenersTab(){
     driver.findElement(By.id("form_tenders")).click();
     return new TendersPage(driver);
 }
}
