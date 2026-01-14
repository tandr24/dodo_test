package tests;

import data.YumeData;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.YumePage;

public class CartTests extends TestBase{
    YumePage yumeSteps = new YumePage();
    YumeData yumeData = new YumeData();
    CartPage cartPage = new CartPage();

    @Test
    void deleteItemFromCart() {
        yumeSteps.openSite("/")
                .chooseItem(yumeData.item);
        cartPage.goToCart()
                .checkCart(yumeData.item)
                .deleteItemFromCart(yumeData.item)
                .checkCartIsEmpty();
    }

    @Test
    void clearCart() {
        yumeSteps.openSite("/")
                .chooseItem(yumeData.item);
        cartPage.goToCart()
                .removeAllItemFromCart()
                .checkCartIsEmpty();
    }
}
