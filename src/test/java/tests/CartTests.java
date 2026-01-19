package tests;

import data.YumeData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.YumePage;

public class CartTests extends TestBase{
    YumePage yumeSteps = new YumePage();
    YumeData yumeData = new YumeData();
    CartPage cartPage = new CartPage();

    @Test
    @DisplayName ("Verify that item is deleted from cart")
    @Owner("QA Team")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Cart Tests")
    @Feature("Delete items from cart")
    @Story("One item is deleted")
    void deleteItemFromCartTest() {
        yumeSteps.openSite("/")
                .chooseItem(yumeData.item);
        cartPage.goToCart()
                .checkCart(yumeData.item)
                .deleteItemFromCart(yumeData.item)
                .checkCartIsEmpty("Vaša korpa je prazna!");
    }

    @Test
    @DisplayName ("Verify that all items are deleted from cart")
    @Owner("QA Team")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Cart Tests")
    @Feature("Delete items from cart")
    @Story("All items are deleted")
    void clearCartTest() {
        yumeSteps.openSite("/")
                .chooseItem(yumeData.item);
        cartPage.goToCart()
                .removeAllItemFromCart()
                .checkCartIsEmpty("Vaša korpa je prazna!");
    }
}