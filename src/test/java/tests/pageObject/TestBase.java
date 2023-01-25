package tests.pageObject;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPages;

public class TestBase {
  RegistrationPages registrationPages = new RegistrationPages();

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    //Configuration.holdBrowserOpen = true;
  }
}
