package com.co.choucair.tasks;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.userinterfaces.SerenityBuy;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.SendKeys;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Buy implements Task {

    UserLoombokData userLoombokData;
    public Buy(UserLoombokData userLoombokData) {this.userLoombokData = userLoombokData;}
    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("FIRSTNAME = " + userLoombokData.getFirstName());
        System.out.println("LASTNAME = " + userLoombokData.getLastName());
        System.out.println("ZIP = " + userLoombokData.getPostalCode());
        actor.attemptsTo(
                WaitUntil.the(SerenityBuy.TXT_Backpack, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(SerenityBuy.TXT_Labs),
                WaitUntil.the(SerenityBuy.TXT_Bike, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(SerenityBuy.TXT_BikeLight ),
                JavaScriptClick.on(SerenityBuy.TXT_Car),

                WaitUntil.the(SerenityBuy.TXT_YourCart, isVisible()).forNoMoreThan(20).seconds(),
                Ensure.that(
                        SerenityBuy.TXT_YourCart.resolveFor(actor).getText()
                        ).isEqualTo("Products"),
                JavaScriptClick.on(SerenityBuy.TXT_checkout),
                WaitUntil.the(SerenityBuy.TXT_FirstName, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(SerenityBuy.TXT_FirstName).isDisplayed(),
                SendKeys.of("Randy").into(SerenityBuy.TXT_FirstName),
                        WaitUntil.the(SerenityBuy.TXT_LastName, isVisible()).forNoMoreThan(10).seconds(),
                SendKeys.of("Gonzalez").into(SerenityBuy.TXT_LastName),
                        WaitUntil.the(SerenityBuy.TXT_Zip, isVisible()).forNoMoreThan(10).seconds(),
                SendKeys.of("12345678").into(SerenityBuy.TXT_Zip),
                JavaScriptClick.on(SerenityBuy.TXT_Continue),
                JavaScriptClick.on(SerenityBuy.TXT_Finish)
        );
                //WaitUntil.the(SerenityBuy.TXT_Dispatched, isVisible()).forNoMoreThan(15).seconds())
                //JavaScriptClick.on(SerenityBuy.TXT_Back));
    }
public static Buy  onTheSite(UserLoombokData userLoombokData){
    return Instrumented.instanceOf(Buy.class).withProperties(userLoombokData);}
}