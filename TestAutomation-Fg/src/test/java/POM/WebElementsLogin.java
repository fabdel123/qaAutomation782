package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElementsLogin {

    //Input UserName
    @FindBy(xpath = "//input[@id='usernameId_new']")
    WebElement inputUser;

    //Input de Password
    @FindBy(xpath = "//input[@id='passwordId_new']")
    WebElement inputPassword;

    public void camposInputUser (String user){
        inputUser.sendKeys(user);
    }

    public void camposInputPass (String password){
        inputPassword.sendKeys(password);
    }

    public void completarCampoUser(String user) {
        completarCampoUser(user);
    }

    public void completarCampoPassword(String password) {
        completarCampoPassword(password);
    }

    public WebElementsLogin (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
