package com.co.choucair.stepdefinitions;
import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.Buy;
import com.co.choucair.userinterfaces.SerenityBuy;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
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
    @Then("validates the purchase message {string}")
    public void validateThePurchaseMessage(String text) {
        System.out.println("URL ACTUAL: " + BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver().getCurrentUrl());
        WaitUntil.the(SerenityBuy.TXT_Dispatched, isVisible())
                .forNoMoreThan(15).seconds();
        String message = SerenityBuy.TXT_Dispatched.resolveFor(OnStage.theActorInTheSpotlight()).getText();
        System.out.println("MENSAJE = " + message);
        OnStage.theActorInTheSpotlight().should(seeThat(
                ValidateText.of(SerenityBuy.TXT_Dispatched),containsString(text)));

    }
}
