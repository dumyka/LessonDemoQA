package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.io.File;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

public class RegistrationPages {
  private CalendarComponent calendarComponent = new CalendarComponent();
  File file = new File("src/test/resources/key.txt");
  private RegistrationResultModal registrationResultModal = new RegistrationResultModal();
  private final String TITLE_TEXT = "Practice form";
  private SelenideElement
      firstName = $("#firstName"),
      lastName = $("#lastName"),
      dateOfBirthInput = $("#dateOfBirthInput");

  @Step("Открытие формы")
  public RegistrationPages openPages() {
    open("https://demoqa.com/automation-practice-form");
    $(".main-header").shouldHave(text(TITLE_TEXT));
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    return this;
  }

  @Step("Заполняем форму")
  public RegistrationPages setFirstName(String value) {
    firstName.setValue(value);
    return this;
  }

  public RegistrationPages setLastName(String value) {
    lastName.setValue(value);
    return this;
  }

  public RegistrationPages setEmail(String value) {
    $("#userEmail").setValue(value);
    return this;
  }

  public RegistrationPages setGender(String value) {
    $("#genterWrapper").$(byText(value)).click();
    return this;
  }

  public RegistrationPages setPhone(String value) {
    $("#userNumber").setValue(value);
    return this;
  }

  public RegistrationPages setBirthDay(String day, String month, String year) {
    dateOfBirthInput.click();
    calendarComponent.setDate(day, month, year);
    return this;
  }

  public RegistrationPages setObject(String value) {
    $("#subjectsInput").setValue(value).pressEnter();
    return this;
  }

  public RegistrationPages setHobbies(String value1, String value2, String value3) {
    $("#hobbiesWrapper").$(byText(value1)).click();
    $("#hobbiesWrapper").$(byText(value2)).click();
    $("#hobbiesWrapper").$(byText(value3)).click();
    return this;
  }

  public RegistrationPages setUploadFile() {
    $("#uploadPicture").uploadFile(file);
    return this;
  }

  public RegistrationPages setAddress(String value) {
    $("#currentAddress").setValue(value);
    return this;
  }

  public RegistrationPages setState(String value) {
    $("#state").click();
    $("#react-select-3-input").setValue(value).pressEnter();
    return this;
  }

  public RegistrationPages setCity(String value) {
    $("#city").click();
    $("#react-select-4-input").setValue(value).pressEnter();
    return this;
  }

  public RegistrationPages clickSubmitButton() {
    $("#submit").click();
    return this;
  }

  public RegistrationPages verifyResultModalAppears() {
    registrationResultModal.verifyModalAppears();
    return this;
  }

  @Step("Проверяем результат")
  public RegistrationPages verifyResult(String key, String value) {
    registrationResultModal.verifyResult(key, value);
    return this;
  }

  public RegistrationPages closeModalResult() {
    $("#closeLargeModal").click();
    return this;
  }

  public RegistrationPages setHobby(String value) {
    $("#hobbiesWrapper").$(byText(value)).click();
    return this;
  }
}
