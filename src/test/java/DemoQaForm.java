import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import java.io.File;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class DemoQaForm {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080";
  }

  @Test
  void practiceForm(){
    // открыть страницу
    open("https://demoqa.com/automation-practice-form");
    // убрать мешающие банеры
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    // проверка, что форма называется "Practice form"
    $(".main-header").shouldHave(text("Practice form"));
    // Заполнение формы Имя, Фамилия, мейл
    $("#firstName").setValue("Dmitriy");
    $("#lastName").setValue("Golovanov");
    $("#userEmail").setValue("Golovanov@ma.ru");
    // выбираем радио-кнопку
    $(byText("Male")).click();
    // заполняем телефон
    $("#userNumber").setValue("8800555353");
    // заполняем дату рождения
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(9); // индекс
    $(".react-datepicker__year-select").selectOption("1990"); // текст
    $(".react-datepicker__day--014").click();
    //заполняем предмет
    $("#subjectsInput").setValue("Computer Science").pressEnter();
    // выбираем чекбоксы
    $(byText("Sports")).click();
    $(byText("Reading")).click();
    $(byText("Music")).click();
    // вставляем картинку
    $("#uploadPicture").uploadFile(new File("C:\\Users\\Dmitriy.Golovanov\\OneDrive - NEDRA\\Рабочий стол\\key.txt"));
    // заполняем текущий адрес
    $("#currentAddress").setValue("текущий адрес");
    // заполняем штат и город
    $("#state").click();
    $("#react-select-3-option-0").click();
    $("#city").click();
    $("#react-select-4-option-0").click();
    // нажать submit
    $("#submit").click();
    //$(byText("Submit")).click();
    // проверка, что открылось модальное окно появилось и имеет текст "Thanks for submitting the form"
    $(".modal-content").should(appear);
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    // проверка, что в форме присутствуют введенные данные
    $(".modal-body").shouldBe(text("Dmitriy Golovanov"), text("Golovanov@ma.ru"),
        text("Male"), text("8800555353"), text("14 October,1990"), text("Computer Science"),
        text("Sports, Reading, Music"), text("key.txt"), text("текущий адрес"), text("NCR Delhi"));
    // закрыть модальное окно
    $("#closeLargeModal").click();


  }
}
