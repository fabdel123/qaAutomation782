package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FiltrarObjetoDeBusqueda {

    //Input de Identificación
    @FindBy(name = "pay_terms_buyer_list_pay_terms_request_ref_sch")
    WebElement inputIdentificacion;

    @FindBy(xpath = "//a[contains(text(),'EC0PTQ00024526')]")
    WebElement clickIdentificador;

    @FindBy(css = "body.layoutBase:nth-child(2) div.containerWrap:nth-child(7) div.f1:nth-child(2) div.contentWrapper:nth-child(1) div.detailPageWrap:nth-child(2) div.badgeWrapper div.badgeWrapperInner div.newBadge:nth-child(1) ul.badgeList.cl.displayFlex.flexWrap li:nth-child(2) > div.values")
    WebElement estadoCsow;

    public void campoInputIdentificacion (String id){
        inputIdentificacion.sendKeys(id);
        inputIdentificacion.submit();
    }

        public void completarCampoIdentificacion(String id) {
            completarCampoIdentificacion(id);
        }


    public void clickLinkID (String linkId){
        clickIdentificador.click();
    }

    public boolean statusResultCSOW (String status){
        System.out.println(status);
        System.out.println(estadoCsow.getText());
        return status.equals(estadoCsow.getText());
    }

        public void clickIdentificadorLink(String linkId){
            clickIdentificadorLink(linkId);
        }



    public FiltrarObjetoDeBusqueda (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
