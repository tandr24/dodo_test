package tests;

import config.LoginConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.YumePage;

public class LoginTests extends TestBase {
    YumePage yumeSteps = new YumePage();
    LoginPage loginPage = new LoginPage();
    LoginConfig loginConfig = ConfigFactory.create(LoginConfig.class, System.getProperties());

    @Test
    @DisplayName("Verify that login with correct creds work")
    @Owner("QA Team")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Login Tests")
    @Feature("Successful login")
    @Story("Login with correct creds")
    void successfulLoginWithCredsTest() {
        yumeSteps.openSite("/login");
        loginPage.enterEmail(loginConfig.email())
                .enterPassword(loginConfig.password())
                .pressLogin()
                .verifyWelcomeText("Zdravo,");
    }

    @Test
    @DisplayName("Verify that login with empty password doesn't work")
    @Owner("QA Team")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Login Tests")
    @Feature("Unsuccessful login")
    @Story("Login with empty password doesn't work")
    void unsuccessfulLoginWithEmptyPasswordTest() {
        yumeSteps.openSite("/login");
        loginPage.enterEmail(loginConfig.email())
                .enterPassword(null)
                .loginButtonIsNotClickable();
    }
}
