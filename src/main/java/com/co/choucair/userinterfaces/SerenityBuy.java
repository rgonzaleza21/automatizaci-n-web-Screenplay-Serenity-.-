package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SerenityBuy {
    public static final Target TXT_Backpack = Target.the("txt")
            .located(By.xpath("//div[text()='Sauce Labs Backpack']"));
    public static final Target TXT_Labs = Target.the("txt")
            .located(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
    public static final Target TXT_Bike = Target.the("txt")
            .located(By.xpath("//div[@data-test='inventory-item-name' and text()='Sauce Labs Bike Light']"));
    public static final Target TXT_BikeLight = Target.the("txt")
            .located(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
    public static final Target TXT_Car = Target.the("txt")
            .located(By.xpath("//a[@class='shopping_cart_link']"));
    public static final Target TXT_products = Target.the("txt")
            .located(By.xpath("//span[text()='Products']"));
    public static final Target TXT_YourCart = Target.the("txt")
            .located(By.xpath("//span[text()='Your Cart']"));
    public static final Target TXT_checkout = Target.the("txt")
            .located(By.xpath("//button[@id='checkout']"));
    public static final Target TXT_FirstName =
            Target.the("First Name").located(By.id("first-name"));
    public static final Target TXT_LastName =
            Target.the("Last Name").located(By.id("last-name"));
    public static final Target TXT_Zip =
            Target.the("Zip").located(By.id("postal-code"));
    public static final Target TXT_Continue = Target.the("txt")
            .located(By.xpath("//input[@id='continue']"));
    public static final Target TXT_OVERVIEW = Target.the("Checkout Overview")
            .located(By.xpath("//span[text()='Checkout: Overview']"));
    public static final Target TXT_Finish = Target.the("txt")
            .located(By.xpath("//button[@id='finish']"));
    public static final Target TXT_Dispatched =Target.the("mensaje compra").located(By.xpath("//h2[@data-test='complete-header']"));
    public static final Target TXT_Back = Target.the("txt")
            .located(By.xpath("//button[@data-test='back-to-products']"));
}
