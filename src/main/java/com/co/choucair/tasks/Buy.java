package com.co.choucair.tasks;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.userinterfaces.SerenityBuy;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Buy implements Task {

    private final UserLoombokData userLoombokData;

    public Buy(UserLoombokData userLoombokData) {
        this.userLoombokData = userLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("FIRSTNAME = " + userLoombokData.getFirstName());
        System.out.println("LASTNAME = " + userLoombokData.getLastName());
        System.out.println("ZIP = " + userLoombokData.getPostalCode());

        actor.attemptsTo(

                WaitUntil.the(SerenityBuy.TXT_Backpack, isVisible())
                        .forNoMoreThan(10).seconds(),

                JavaScriptClick.on(SerenityBuy.TXT_Labs),

                WaitUntil.the(SerenityBuy.TXT_Bike, isVisible())
                        .forNoMoreThan(10).seconds(),

                JavaScriptClick.on(SerenityBuy.TXT_BikeLight),

                JavaScriptClick.on(SerenityBuy.TXT_Car),

                WaitUntil.the(SerenityBuy.TXT_YourCart, isVisible()).forNoMoreThan(10).seconds(),

                JavaScriptClick.on(SerenityBuy.TXT_checkout),

                WaitUntil.the(SerenityBuy.TXT_FirstName, isVisible()).forNoMoreThan(10).seconds(),

                SendKeys.of(userLoombokData.getFirstName()).into(SerenityBuy.TXT_FirstName),
                SendKeys.of(userLoombokData.getLastName()).into(SerenityBuy.TXT_LastName),
                SendKeys.of(userLoombokData.getPostalCode()).into(SerenityBuy.TXT_Zip),

                JavaScriptClick.on(SerenityBuy.TXT_Continue),

                WaitUntil.the(SerenityBuy.TXT_OVERVIEW, isVisible()).forNoMoreThan(20).seconds(),

                JavaScriptClick.on(SerenityBuy.TXT_Finish)
        );

        // WaitUntil.the(SerenityBuy.TXT_Dispatched, isVisible())
                //        .forNoMoreThan(15).seconds(),

                //  Ensure.that(
                // SerenityBuy.TXT_Dispatched.resolveFor(actor).getText()
        //  ).isEqualTo("Thank you for your order!"),

        //   JavaScriptClick.on(SerenityBuy.TXT_Back)

    }

    public static Buy onTheSite(UserLoombokData userLoombokData) {
        return Instrumented.instanceOf(Buy.class)
                .withProperties(userLoombokData);
    }
}