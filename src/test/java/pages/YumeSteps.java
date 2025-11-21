package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YumeSteps {

    private final SelenideElement chooseCityElement = $(".header__container-links .selectPlace__button");
    private final SelenideElement cityElement = $("select.MuiNativeSelect-select");
    private final SelenideElement okElement = $(".MuiDialogActions-root.MuiDialogActions-spacing.css-b07ifn");
    private final SelenideElement fullPageElement = $(".app__wrapper");
    private final SelenideElement cartElement = $(".header__cart-button.app__button-opacity");
    private final SelenideElement cartProductsElement = $(".cart__products");
    private final SelenideElement classCart = $(".cart");
    private final SelenideElement clearCartElement = $(".cart__btn-products_clean.app__button-opacity");
    private final SelenideElement checkCityElement = $(".header__container-links");
    private final ElementsCollection cartItemElement = $$(".cart__product-name");
    private final SelenideElement tabAboutUsElement = $(".header__container-links .header__link.app__text-opacity");
    private final SelenideElement cityIntabAboutUsElement = $(".contacts__container");

    @Step("Open site")
    public YumeSteps openSite(String value) {
        open(value);
        return this;
    }

    @Step("Choose city")
    public YumeSteps chooseCity(String value) {
        chooseCityElement.click();
        cityElement.selectOptionByValue(value);
        okElement.$(byText("Ok")).click();
        return this;
    }

    @Step("Check city")
    public YumeSteps checkCity(String expectedCity) {
        checkCityElement.shouldHave(text(expectedCity));
        return this;
    }

    @Step("Choose item {name}")
    public YumeSteps chooseItem(String name) {
        fullPageElement.$(byText(name)).ancestor(".dishes__card").$(".dishes__cart-button").click();
        return this;
    }

    @Step("Go to the cart")
    public YumeSteps goToCart() {
        cartElement.click();
        return this;
    }

    @Step("Check that item {name} is in cart")
    public YumeSteps checkCart(String expectedName) {
        cartProductsElement.shouldHave(text(expectedName));
        return this;
    }

    @Step("Delete item from cart")
    public YumeSteps deleteItemFromCart(String item) {
        cartItemElement
                .findBy(text(item))
                .parent()
                .$(".cart__product-btn_trash.app__button-opacity")
                .click();
        return this;
    }

    @Step("Check that cart is empty")
    public YumeSteps checkCartIsEmpty() {
        classCart.shouldHave(text("Vaša korpa je prazna!"));
        return this;
    }

    @Step("Remove everything from cart")
    public YumeSteps removeAllItemFromCart() {
        clearCartElement.click();
        return this;
    }

    @Step("Open tab \"About Us\"")
    public YumeSteps openTabAboutUs() {
        tabAboutUsElement.click();
        return this;
    }

    @Step("Choose city in tab \"About Us\"")
    public YumeSteps chooseCityInTabAboutUs(String city) {
        cityIntabAboutUsElement
                .$(byText(city))
                .click();
        return this;
    }

    @Step("Verify that contact info is correct")
    public YumeSteps verifyContactInfo(String city) {
        if (city.equals("Beograd")) {
            cityIntabAboutUsElement
                    .$(byText(city))
                    .shouldHave(text("+381612714798"));
        }
        if (city.equals("Novi Sad")) {
            cityIntabAboutUsElement
                    .$(byText(city))
                    .shouldHave(text("+381614813011"));
        }
        return this;
    }


}
