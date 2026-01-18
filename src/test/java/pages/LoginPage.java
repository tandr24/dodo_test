package pages;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement emailElement = $("#email");
    private final SelenideElement passwordElement = $("#password");
    private final SelenideElement loginEnterElement = $(".login__submit-button");
    private final SelenideElement loginWelcomeTextElement = $(".profile__text");

    @Step("Press Login")
    public LoginPage pressLogin() {
        loginEnterElement.click();
        return this;
    }

    @Step("Verify Login button is not clickable")
    public LoginPage loginButtonIsNotClickable() {
        loginEnterElement.shouldNotBe(clickable);
        return this;
    }

    @Step("Enter e-mail")
    public LoginPage enterEmail(String email) {
        emailElement.setValue(email);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        passwordElement.setValue(password);
        return this;
    }
    @Step("Welcome Text should have expected result")
    public LoginPage verifyWelcomeText(String welcomeText) {
        loginWelcomeTextElement.shouldHave(text(welcomeText));
        return this;
    }
}
