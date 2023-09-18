import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class compraAutomatizada {
    private WebDriver chromeDriver;

    @Before
    //Crear un método public que no devuelve nada, por eso es void
    public void abrirDriver() {

        //Encontrar el archivo de Webdriver
        //System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //Creamos opciones sobre nuestro driver
        ChromeOptions options = new ChromeOptions();

        //Estamos agregando características al navegador y se llaman capabilities, le estamos diciendo que no es un navegador de tipo marionette
        options.setCapability("marionette", true);

        //Vamos a crear un nuevo firefoxdriver, es decir una nueva instancia de firefox
        chromeDriver = new ChromeDriver(options);

        //Definimos tiempo de espera hasta que aceptemos un timeout
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    //Crear un método public que no devuelve nada, por eso es void
    public void hacer_compra()

    {
        //Abrir la URL destino
        chromeDriver.get("https://www.google.com/");

        //Input de UserName
        WebElement inputEmail = chromeDriver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        inputEmail.sendKeys("Linkedin");
        inputEmail.submit();

        //BOTON de INICIAR SESION
        //WebElement botonLogin = chromeDriver.findElement(By.xpath(""));
        //botonLogin.submit();

    }

    @After
    public void cerrarDriver() {
        //Se cierra el navegador
        //chromeDriver.quit();

    }

}