package com.sophossolutions.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.sophossolutions.stepdefinitions",
        features = "src/test/resources/com.sophossolutions.features/delete_gorest.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class DeleteGorest {
}