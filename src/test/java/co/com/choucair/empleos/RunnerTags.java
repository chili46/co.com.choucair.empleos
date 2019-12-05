package co.com.choucair.empleos;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/choucairEmpleos.feature",
        //tags = "@Registro",
        //tags = "@Tag0",
        tags="@Medico",
        snippets = SnippetType.CAMELCASE )
public class RunnerTags {
}
