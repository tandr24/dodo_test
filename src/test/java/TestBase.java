import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import helpers.Attachments;

public class TestBase {
    @BeforeAll
    static void setupConfiguration() {
        Configuration.baseUrl = "https://yumesushi.rs";
        Configuration.pageLoadStrategy = "eager";
       Configuration.remote = System.getProperty("remote");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "128.0");
        Configuration.browserSize = System.getProperty("windowSize", "1920x1080");
    }

    @AfterEach
    void addAttachments() {
        if (Configuration.browser.equals("chrome")) {
            Attachments.screenshotAs("Last screenshot");
            Attachments.pageSource();
            Attachments.browserConsoleLogs();
            Attachments.addVideo();
        }
    }

    @BeforeEach
    void setupAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}