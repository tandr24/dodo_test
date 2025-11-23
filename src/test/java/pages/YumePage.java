package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class YumePage {

    private final SelenideElement chooseCityElement = $(".header__container-links .selectPlace__button");
    private final SelenideElement cityElement = $("select.MuiNativeSelect-select");
    private final SelenideElement okElement = $(".MuiDialogActions-root.MuiDialogActions-spacing.css-b07ifn");
    private final SelenideElement fullPageElement = $(".app__wrapper");
    private final SelenideElement checkCityElement = $(".header__container-links");

    @Step("Open site")
    public YumePage openSite(String value) {
        open(value);
        return this;
    }

    @Step("Choose city")
    public YumePage chooseCity(String value) {
        chooseCityElement.click();
        cityElement.selectOptionByValue(value);
        okElement.$(byText("Ok")).click();
        return this;
    }

    @Step("Check city")
    public YumePage checkCity(String expectedCity) {
        checkCityElement.shouldHave(text(expectedCity));
        return this;
    }

    @Step("Choose item {name}")
    public YumePage chooseItem(String name) {
        fullPageElement.$(byText(name)).ancestor(".dishes__card").$(".dishes__cart-button").click();
        return this;
    }
}
