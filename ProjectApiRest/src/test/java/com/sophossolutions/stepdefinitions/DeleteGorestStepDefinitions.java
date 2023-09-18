package com.sophossolutions.stepdefinitions;

import com.sophossolutions.tasks.ExecutionDeleteToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class DeleteGorestStepDefinitions {

    @Given("{string} Establece la base url {string}")
    public void estableceLaBaseUrl(String actor, String baseUrl) {
        theActorCalled(actor).whoCan(CallAnApi.at(baseUrl));
    }

    @When("El usuario a eliminar en el api {string}")
    public void elUsuarioAEliminarEnElApi(String endpoint, Map<String, String> dataTable) {
        theActorInTheSpotlight().attemptsTo(ExecutionDeleteToken.deleteUser(endpoint, dataTable.get("id")));
    }

    @Then("valido el id {string} con estado {string}")
    public void validoElIdConEstado(String id, Integer status) {
        theActorInTheSpotlight().should(seeThatResponse(response -> response.statusCode(status).body(
                "data.id", equalTo(id))));
    }


}
