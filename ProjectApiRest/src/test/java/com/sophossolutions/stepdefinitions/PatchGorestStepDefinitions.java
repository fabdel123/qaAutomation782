package com.sophossolutions.stepdefinitions;

import com.sophossolutions.tasks.ExecutionPatchToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class PatchGorestStepDefinitions {

    @Given("{string} Estable la base url {string} del Api")
    public void estableLaBaseUrlDelApi(String actor, String baseUrl) {
        theActorCalled(actor).whoCan(CallAnApi.at(baseUrl));
    }

    @When("Se Ingresa la informacion a modificar del usuario en el endpoint {string}")
    public void seIngresaLaInformacionAModificarDelUsuarioEnElEndpoint(String endpoint, DataTable userInformationChanged) {
        theActorInTheSpotlight().attemptsTo(ExecutionPatchToken.modificateUser(endpoint, userInformationChanged));
    }

    @Then("valido la respuesta en el campo {string} y el codigo de status sea {int}")
    public void validoLaRespuestaEnElCampoYElCodigoDeStatusSea(String name, Integer statusCode) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(statusCode)
                .body("data.name", equalTo(name))));
    }

}
