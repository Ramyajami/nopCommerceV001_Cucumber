package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageFactory {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="Email")
    public WebElement txtEmail;

    @FindBy(id="Password")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement btnLogin;

    @FindBy(linkText = "Logout")
    public WebElement lnkLogot;
    public  void setUserName(String uname)
    {
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }
    public  void setPassword(String pwd)
    {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }
    public void clickLogin()
    {
        btnLogin.click();
    }
    public void clickLogout()
    {
        lnkLogot.click();
    }
}
