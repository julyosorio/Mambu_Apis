package co.com.bancopichincha.mambu.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/loans/",
        glue = "co.com.bancopichincha.mambu.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class LoansRunner {
}