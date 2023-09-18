package com.sophossolutions.tasks;

import com.sophossolutions.constants.ApiConstants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class ExecutionDeleteToken implements Task {

    private String endpoint;
    private String id;

    public ExecutionDeleteToken (String endpoint, String id){
        this.endpoint = endpoint;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(endpoint.concat(id)).with(
                response -> response.auth().oauth2(ApiConstants.TOKEN)
        ));
    }

    public static ExecutionDeleteToken deleteUser (String endpoint, String id){
        return Tasks.instrumented(ExecutionDeleteToken.class, endpoint, id);
    }
}
