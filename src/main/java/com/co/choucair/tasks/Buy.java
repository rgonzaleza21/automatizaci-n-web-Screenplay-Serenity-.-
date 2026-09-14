package com.co.choucair.tasks;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.userinterfaces.SerenityBuy;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Buy implements Task {

    UserLoombokData userLoombokData;
    public Buy(UserLoombokData userLoombokData) {this.userLoombokData = userLoombokData;}
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SerenityBuy.TXT_Backpack, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(SerenityBuy.TXT_Labs),
                WaitUntil.the(SerenityBuy.TXT_Bike, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(SerenityBuy.TXT_BikeLight ),
                JavaScriptClick.on(SerenityBuy.TXT_Car),
                WaitUntil.the(SerenityBuy.TXT_YourCart, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(SerenityBuy.TXT_checkout),
                Enter.theValue(userLoombokData.getUser()).into(SerenityBuy.TXT_FirstName),
                Enter.theValue(userLoombokData.getUser()).into(SerenityBuy.TXT_LastName),
                Enter.theValue(userLoombokData.getUser()).into(SerenityBuy.TXT_Zip),
                JavaScriptClick.on(SerenityBuy.TXT_Continue),
                JavaScriptClick.on(SerenityBuy.TXT_Finish),
                WaitUntil.the(SerenityBuy.TXT_Dispatched, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(SerenityBuy.TXT_Back)


        );
    }
public static Buy  onTheSite(UserLoombokData userLoombokData){
    return Instrumented.instanceOf(Buy.class).withProperties(userLoombokData);}
}