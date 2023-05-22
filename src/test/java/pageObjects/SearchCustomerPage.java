package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver driver;
    public SearchCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    By Email= By.id("SearchEmail");
    By SearchButton=By.id("search-customers");
    By tableGrid=By.xpath("//table[@id='customers-grid']");
    @FindBy(how= How.XPATH,using="//table[@id='customers-grid']/tbody/tr")
    List<WebElement> tableRows;
    @FindBy(how= How.XPATH,using="//table[@id='customers-grid']/tbody/tr/td")
    List<WebElement> tableColoumns;
    public void setEmail(String email)
    {
        driver.findElement(Email).sendKeys(email);
    }
    public void clickSearchButton()
    {
        driver.findElement(SearchButton).click();
    }
    public int getNoOfRows(){
        return(tableRows.size());
    }
    public int getNoOfColumns(){
        return(tableColoumns.size());
    }
    public boolean searchCustomerByEmail(String email)
    {
        boolean flag=false;
        for(int i=1;i<=getNoOfRows();i++)
        {
        String emailid=driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
        System.out.println(emailid);
        if(email.equals(email))
            {
                flag=true;
            }
        }
        return flag;
    }
}
