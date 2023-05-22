package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class AddCustomerPage {

    WebDriver driver;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By customer_menu = By.xpath("(//li[@class='nav-item has-treeview'])[4]//p");
    By customer_menu_item = By.xpath("//li//p[text()=' Customers']");
    By Addnew = By.xpath("//a[normalize-space()='Add new']");
    By Addanewcustomerpage = By.xpath("//h1[contains(text(),'Add a new customer')]");
    By Email = By.xpath("//input[@id='Email']");
    By Savebutton = By.xpath("//button[@name='save']");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickOnCustomeMenu() {
        driver.findElement(customer_menu).click();
    }

    public void clickCustomerMenuItem() {
        driver.findElement(customer_menu_item).click();
    }

    public void clickAddNew() {
        driver.findElement(Addnew).click();
    }

    public void EnterEmail(String email) {
        driver.findElement(Email).sendKeys(email);
    }

    public void clickOnSaveButton() {
        driver.findElement(Savebutton).click();
    }
}
