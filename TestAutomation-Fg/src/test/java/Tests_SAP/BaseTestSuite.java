package Tests_SAP;

import POM.FiltrarObjetoDeBusqueda;
import POM.Login;
import POM.WebElementsLogin;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTestSuite {
    protected WebDriver ChromeDriver;

    Login login;
    WebElementsLogin webElementsLogin;

    FiltrarObjetoDeBusqueda filtrarObjetoDeBusqueda;

    private void inicializarPagina(WebDriver driver){
        login = new Login(driver);
        webElementsLogin = new WebElementsLogin(driver);
        filtrarObjetoDeBusqueda = new FiltrarObjetoDeBusqueda(driver);
    }


    @Before
    //Crear un método public que no devuelve nada, por eso es void
    public void abrirDriver()

    {

        //Encontrar el archivo del Webdriver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //Creamos opciones sobre nuestro driver
        ChromeOptions options = new ChromeOptions();

        //Estamos agregando características al navegador y se llaman capabilities, le estamos diciendo que no es un navegador de tipo marionette
        options.setCapability("marionette", true);

        //El Webdriver nos permite que el navegador se agrande al tamaño de la pantalla inicial
        options.addArguments("--start-maximized");

        //Vamos a crear un nuevo firefoxdriver o ChromeDriver, es decir una nueva instancia del navegador para ser considerada para futuras configuraciones
        ChromeDriver = new ChromeDriver(options);

        //Definimos tiempo de espera hasta que aceptemos un timeout
        ChromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        inicializarPagina(ChromeDriver);

    }

    @After
    public void cerrarDriver()
    {
        //Se cierra el navegador para evitar gasto innecesario de memoria
        ChromeDriver.quit();

    }

}
