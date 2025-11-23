package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AboutUsPage {
    private final SelenideElement tabAboutUsElement = $(".header__container-links .header__link.app__text-opacity");
    private final SelenideElement cityIntabAboutUsElement = $(".contacts__container");

    @Step("Open tab \"About Us\"")
    public AboutUsPage openTabAboutUs() {
        tabAboutUsElement.click();
        return this;
    }

    @Step("Choose city in tab \"About Us\"")
    public AboutUsPage chooseCityInTabAboutUs(String city) {
        cityIntabAboutUsElement
                .$(byText(city))
                .click();
        return this;
    }

    @Step("Verify that contact info is correct")
    public AboutUsPage verifyContactInfo(String city) {
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
