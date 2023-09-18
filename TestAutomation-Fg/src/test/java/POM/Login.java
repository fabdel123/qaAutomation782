package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    //ELEMENTO WEB BOTON - INICIAR SESION
    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    private WebElement buttonSignIn;

    //DECLARACIÓN DEL ELEMENTO PUBLIC - BOTÓN SIGN IN
    public void signIn(){
        buttonSignIn.click();
    }

    //ELEMENTO WEB  BOTON - VER
    @FindBy(xpath = "//body/div[@id='main']/div[3]/div[1]/nav[1]/ul[1]/li[2]/figure[1]/a[1]")
    private WebElement clickEnVer;

    //DECLARACIÓN DEL ELEMENTO PUBLIC - VER
    public void irAVer(){
        clickEnVer.click();
    }

    //ELEMENTO WEB  BOTON - DECLARACIÓN DE TRABAJO
    @FindBy(xpath = "//a[@id='viewMenu_1_sow.serviceRequest_link']")
    private WebElement clickEnDeclaracionDeTrabajo;


    //DECLARACIÓN DEL ELEMENTO PUBLIC - DECLARACIÓN DE TRABAJO
    public void irADeclaracionDeTrabajo(){
        clickEnDeclaracionDeTrabajo.click();
    }


    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
