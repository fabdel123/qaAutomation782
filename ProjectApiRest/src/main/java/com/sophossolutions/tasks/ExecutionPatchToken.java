package com.sophossolutions.tasks;

import com.sophossolutions.constants.ApiConstants;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import org.apache.http.HttpHeaders;

import java.util.Map;

public class ExecutionPatchToken implements Task {

    private String endpoint;
    private Map<String, String> body;

    public ExecutionPatchToken(String endpoint, DataTable body) {
        this.endpoint = endpoint;
        this.body = body.asMap(String.class, String.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Patch.to(endpoint).with(request ->
                request.header(HttpHeaders.CONTENT_TYPE, ContentType.JSON).auth().oauth2(ApiConstants.TOKEN).body(body)));
    }

    public static ExecutionPatchToken modificateUser(String endpoint, DataTable body) {
        return Tasks.instrumented(ExecutionPatchToken.class, endpoint, body);
    }

}
