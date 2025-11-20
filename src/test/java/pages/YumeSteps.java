package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YumeSteps {

    private final SelenideElement chooseCityElement = $(".MuiSvgIcon-root.MuiSvgIcon-fontSizeMedium.css-1wh0xfl");
    private final SelenideElement cityElement = $(".MuiNativeSelect-select.MuiNativeSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-1ub306l");
    private final SelenideElement okElement = $(".MuiTouchRipple-root.css-w0pj6f");
    private final SelenideElement fullPageElement = $(".app__wrapper");
    private final SelenideElement cartElement = $(".header__cart-button.app__button-opacity");
    private final SelenideElement cartProductsElement = $(".cart__products");
    private final SelenideElement classCart = $(".cart");

    private final SelenideElement clearCartElement = $(".cart__btn-products_clean.app__button-opacity");


    @Step("Open site")
    public YumeSteps openSite(String value) {
        open(value);
        return this;
    }

    @Step("Choose city")
    public YumeSteps chooseCity(String value) {
        chooseCityElement.click();
        cityElement.setValue(value);
        okElement.click();
        return this;
    }
    @Step("Check city")
    public YumeSteps checkCity(String expectedCity) {
        chooseCityElement.shouldHave(text(expectedCity));
        return this;
    }

    @Step("Choose item {name}")
    public YumeSteps chooseItem(String name) {
        fullPageElement.$(byText(name)).ancestor(".dishes__card").$(".dishes__cart-button").click();
        return this;
    }

    @Step("Go to the cart")
    public YumeSteps goToCart(){
        cartElement.click();
        return this;
    }

    @Step("Check that item {name} is in cart")
    public YumeSteps checkCart(String expectedName){
        cartProductsElement.shouldHave(text(expectedName));
        return this;
    }

    @Step("Delete item from cart")
    public YumeSteps deleteItemFromCart(String item){
//        classCart.$(byText(item)).parent().
//                $("cart__product-btn_trash.app__button-opacity").click();
        $$(".cart__product-name")
                .findBy(text(item))                     // <p class="cart__product-name">item</p>
                .parent()                               // div.cart__products
                .$(".cart__product-btn_trash.app__button-opacity")
                .click();
        return this;
    }

    @Step("Check that cart is empty")
    public YumeSteps checkCartIsEmpty(){
        classCart.shouldHave(text("Vaša korpa je prazna!"));
    return this;
    }


    @Step("Remove everything from cart")
    public YumeSteps removeAllItemFromCart(){
        clearCartElement.click();
        return this;
    }

}
