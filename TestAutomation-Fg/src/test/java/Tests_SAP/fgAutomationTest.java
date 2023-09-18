package Tests_SAP;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class fgAutomationTest extends BaseTestSuite {



    @Test
    //Crear un método public que no devuelve nada, por eso es void
    public void hacer_compra() throws InterruptedException {

        //Abrir la URL destino
        ChromeDriver.get("https://xcore3.fgvms.com/?next=%2Fdesktop.do");
        //Input de UserName
        webElementsLogin.camposInputUser("E2_PTRGCON_EC0P");
        //Input de Password
        webElementsLogin.camposInputPass("Ecop3tr0l#07");
        //Click en botón de Sign In
        login.signIn();
        //Click en botón de VER
        login.irAVer();
        //Click en botón de Declaración de trabajo
        login.irADeclaracionDeTrabajo();
        //Click en campo Identificación y pulsar Enter para buscarlo
        filtrarObjetoDeBusqueda.campoInputIdentificacion("EC0PTQ00024526");
        //Click en link del Identificador buscado anteriormente
        filtrarObjetoDeBusqueda.clickLinkID("EC0PTQ00024526");
        //Valida el estado del ID Identificador buscado anteriormente que se encuentre en estado Aprobado
        Assert.assertTrue(filtrarObjetoDeBusqueda.statusResultCSOW("Aprobado"));


        Thread.sleep(5000);

    }

}