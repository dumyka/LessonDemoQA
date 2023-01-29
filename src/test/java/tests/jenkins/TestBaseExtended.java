package tests.jenkins;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPages;

public class TestBaseExtended {

  RegistrationPages registrationPages = new RegistrationPages();

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.browser = "chrome";
    Configuration.browserVersion = "100.0";
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
        "enableVNC", true,
        "enableVideo", true
    ));

    Configuration.browserCapabilities = capabilities;
  }

  @BeforeEach
  void addListener(){
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }
}