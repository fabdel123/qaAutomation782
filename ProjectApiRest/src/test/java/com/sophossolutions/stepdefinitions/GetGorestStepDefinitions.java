package com.sophossolutions.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

import com.sophossolutions.tasks.ExecutionGetToken;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class GetGorestStepDefinitions {

    @Before
    public void setup(){
        setTheStage(new OnlineCast());
    }

    @Given("{string} Estable la base url {string} del servicio")
    public void estableLaBaseUrlDelServicio(String actorName, String baseUrl) {
        theActorCalled(actorName).whoCan(CallAnApi.at(baseUrl));
    }

    @When("consulta en el endpoint {string} por id {string}")
    public void consultaEnElEndpointPorId(String endpoint, String id) {
        theActorInTheSpotlight().attemptsTo(ExecutionGetToken.getInformation(endpoint, id));
    }

    @Then("valida que el estatus code sea {int} y la respuesta contenga el nombre {string}")
    public void validaQueElEstatusCodeSeaYLaRespuestaContengaElNombre(Integer status, String name) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(status).body(
                "data.name", equalTo(name))));
    }

}
