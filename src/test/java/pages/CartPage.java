package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    private final SelenideElement cartElement = $(".header__cart-button.app__button-opacity");
    private final SelenideElement cartProductsElement = $(".cart__products");
    private final SelenideElement classCart = $(".cart");
    private final SelenideElement clearCartElement = $(".cart__btn-products_clean.app__button-opacity");
    private final ElementsCollection cartItemElement = $$(".cart__product-name");


    @Step("Go to the cart")
    public CartPage goToCart() {
        cartElement.click();
        return this;
    }

    @Step("Check that item {name} is in cart")
    public CartPage checkCart(String expectedName) {
        cartProductsElement.shouldHave(text(expectedName));
        return this;
    }

    @Step("Delete item from cart")
    public CartPage deleteItemFromCart(String item) {
        cartItemElement
                .findBy(text(item))
                .parent()
                .$(".cart__product-btn_trash.app__button-opacity")
                .click();
        return this;
    }

    @Step("Check that cart is empty")
    public CartPage checkCartIsEmpty(String expectedText) {
        classCart.shouldHave(text(expectedText));
        return this;
    }

    @Step("Remove everything from cart")
    public CartPage removeAllItemFromCart() {
        clearCartElement.click();
        return this;
    }
}
