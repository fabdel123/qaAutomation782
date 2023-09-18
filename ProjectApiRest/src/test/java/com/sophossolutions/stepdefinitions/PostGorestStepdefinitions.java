package com.sophossolutions.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

import com.sophossolutions.tasks.ExecutionPostToken;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class PostGorestStepdefinitions {

    @When("Proporciona la informacion del usuario en el endpoint {string}")
    public void proporcionaLaInformacionDelUsuarioEnElEndpoint(String endpoint, DataTable userInformation) {
        theActorInTheSpotlight().attemptsTo(ExecutionPostToken.createUser(endpoint, userInformation));
    }
    @Then("valida que la respuesta tenga el nombre {string} y el codigo de status sea {int}")
    public void validaQueLaRespuestaTengaElNombreYElStatusSea(String name, Integer statusCode) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(statusCode)
                .body("data.name", equalTo(name))));
    }

}
