package StepsPO;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = {"src/test/resources/featuresPO"},                   // Onde estão os cenários em Gherkin
        glue     = {"StepsPO"}  ,                                     // Onde estão as definições de passos
        dryRun   = false,                                               // Exibição de log
        monochrome = true,                                              // Detalhes do log
        plugin = {
                "pretty",                                           // Formatação visual do Cucumber
                "html:target/reports/extentreports",                // Saida HTML do Relatório Simples
                "json:target/reports/extentreports.json"            // Saida Json com os dados
        }

)
public class Runner extends AbstractTestNGCucumberTests { // Equivale ao @RunWith do JUnit
    // Configuração de modelo de relatório ou de outra característica
}
