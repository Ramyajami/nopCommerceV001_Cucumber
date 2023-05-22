package stepDefinitions;
import io.cucumber.java.en.*;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.util.logging.Logger;

public class Steps extends Baseclass{
    //    @Before
//    public void setup() throws IOException {
//        configProp = new Properties();
//        FileInputStream configProfile = new FileInputStream("config.properties");
//        configProp.load(configProfile);
//        logger = Logger.getLogger("nopComerce");
//        PropertyConfigurator.configure("log4j.properties");
//        String br = configProp.getProperty("browser");
//        if (br.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
//            driver = new ChromeDriver();
//        } else if (br.equals("firefox")) {
//            System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
//            driver = new FirefoxDriver();
//        }
//    }
    @Given("User lunch chrome browser")
    public void user_lunch_chrome_browser() {
        logger=Logger.getLogger("nopComerce");
        PropertyConfigurator.configure("log4j.properties");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        lp=new LoginPage(driver);
    }
    @When("user opens url {string}")
    public void user_opens_url(String url) {
        logger.info("*** opening url ***");
        driver.get(url);
        driver.manage().window().maximize();
    }
    @When("user enters Email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {
        logger.info("*** enter login details ***");
        lp.setUserName(email);
        lp.setPassword(pwd);
    }
    @When("click on Login")
    public void click_on_login() {
        logger.info("*** started login ***");
        lp.clickLogin();
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        System.out.println(driver.getPageSource());
        Assert.assertEquals(title,driver.getTitle());
        logger.info("*** successful login  ***");
    }
    @When("user click on logout out link")
    public void user_click_on_logout_out_link() throws InterruptedException {
        lp.clickLogout();
        logger.info("*** successful logout  ***");
        Thread.sleep(3000);
    }
    @Then("close browser")
    public void close_browser() {
        logger.info("*** closing browser  ***");
        driver.quit();
    }

    @Then("user can view dashboard")
    public void user_can_view_dashboard() {
        addcust=new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addcust.getPageTitle());
    }
    @When("user click on customers menu")
    public void user_click_on_customers_menu() {
       addcust.clickOnCustomeMenu();
    }
    @When("click on customers menu item")
    public void click_on_customers_menu_item() {
        addcust.clickCustomerMenuItem();
    }
    @When("click on Add new button")
    public void click_on_add_new_button() {
      addcust.clickAddNew();
    }
    @Then("user can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        addcust=new AddCustomerPage(driver);
        Assert.assertEquals("Add a new customer / nopCommerce administration",addcust.getPageTitle());
    }
    @When("user enter customer info")
    public void user_enter_customer_info() {
        logger.info("*** Adding customer info  ***");
        String email=randomstring()+"@gmail.com";
        addcust.EnterEmail(email);
    }
    @When("click on save button")
    public void click_on_save_button() {
        logger.info("*** saving customer details  ***");
        addcust.clickOnSaveButton();
    }
    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String text) {
       Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
    }
    @When("Enter customer Email")
    public void enter_customer_email() throws InterruptedException {
        logger.info("*** searching a customer by email id ***");
        searchCust=new SearchCustomerPage(driver);
        searchCust.setEmail("anadzxcd@gmail.com");
        Thread.sleep(5000);
    }
    @When("click on Search button")
    public void click_on_search_button() {
        searchCust.clickSearchButton();
    }
    @Then("user should found Email in the Search table")
    public void user_should_found_email_in_the_search_table() {
        boolean status=searchCust.searchCustomerByEmail("anadzxcd@gmail.com");
        Assert.assertEquals(true,status);
    }
}
