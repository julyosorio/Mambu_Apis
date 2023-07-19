package co.com.bancopichincha.mambu.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static co.com.bancopichincha.mambu.utils.PropertiesManager.getValue;


public class HooksAPI {

    public static EnvironmentVariables environmentVariables;

    @Before
    public void actorConfig() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} requires the use of Mambu API v2.")
    public void requiresTheUseOfMambuAPIV2(String user) {
        OnStage.theActorCalled(user).whoCan(
                CallAnApi.at(environmentVariables.optionalProperty("api.url").orElse(getValue("urlSofkaMambu")))
        );
    }
}

