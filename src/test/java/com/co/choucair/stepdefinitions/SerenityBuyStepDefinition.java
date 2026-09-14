package com.co.choucair.stepdefinitions;
import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.Buy;
import com.co.choucair.tasks.Login;
import com.co.choucair.userinterfaces.SerenityBuy;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static com.co.choucair.userinterfaces.SerenityBuy.TXT_Dispatched;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class SerenityBuyStepDefinition {
    @When("attempts to buy products")
    public void attemptsToBuyProducts(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Buy.onTheSite(
                        UserLoombokData.setData(dataTable).get(0)
                        )
        );
    }
    @Then("validate the purchase message {string}")
    public void validateThePurchaseMessage(String text) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(SerenityBuy.TXT_Dispatched),
                containsString(text)
                )
        );
    }
}
