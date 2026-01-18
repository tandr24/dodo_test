package tests;

import data.YumeData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AboutUsPage;
import pages.CartPage;
import pages.YumePage;

public class MenuTests extends TestBase {
    YumePage yumeSteps = new YumePage();
    YumeData yumeData = new YumeData();
    AboutUsPage aboutUsPage = new AboutUsPage();
    CartPage cartPage = new CartPage();

    @Test
    @DisplayName("Verify that item can be added to the cart")
    @Owner("QA Team")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Menu Tests")
    @Feature("Product menu")
    @Story("One item is added to cart")
    void addItemToCartTest() {
        yumeSteps.openSite("/")
                .chooseItem(yumeData.item);
        cartPage.goToCart()
                .checkCart(yumeData.item);
    }

    @Test
    @DisplayName ("Verify if city on cite can be changed")
    @Owner("QA Team")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Site settings")
    @Feature("City settings")
    @Story("City can be changed on site")
    void changeCityOnSiteTest() {
        yumeSteps.openSite("/")
                .chooseCity(yumeData.city)
                .checkCity(yumeData.city);
    }

    @Test
    @DisplayName ("Verify if contact info is correct")
    @Owner("QA Team")
    @Severity(SeverityLevel.MINOR)
    @Epic("Site settings")
    @Feature("Contact info")
    @Story("Contact info exists and correct")
    void checkIfContactInfoExistsAndCorrectTest() {
        yumeSteps.openSite("/");
        aboutUsPage.openTabAboutUs()
                .chooseCityInTabAboutUs(yumeData.city)
                .verifyContactInfo(yumeData.city, yumeData.phoneNumber(yumeData.city));

    }

}
