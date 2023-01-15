package tests;

import static com.codeborne.selenide.Selenide.$;
import java.io.File;
import org.junit.jupiter.api.Test;



public class RegistrationWithPageObjectTest extends TestBase {

  @Test
  void successfulRegistrationTest() {
    String userName = "Dmitriy";
    String surName = "Golovanov";
    String email = "golova@mail.ru";
    String gender = "Male";
    String phone = "8800555353";
    String day = "14";
    String month = "October";
    String year = "1990";
    String object = "Computer Science";
    String hobby1 = "Sports";
    String hobby2 = "Reading";
    String hobby3 = "Music";
    String address = "текущий адрес";
    String state = "NCR";
    String city = "Delhi";

    registrationPages.openPages()
        .setFirstName(userName)
        .setLastName(surName)
        .setEmail(email)
        .setGender(gender)
        .setPhone(phone)
        .setBirthDay(day, month, year)
        .setObject(object)
        .setHobbies(hobby1, hobby2, hobby3)
        .setUploadFile()
        .setAddress(address)
        .setState(state)
        .setCity(city)
        .clickSubmitButton()
        .verifyResultModalAppears()
        .verifyResult("Student Name", userName + " " + surName)
        .verifyResult("Student Email", email)
        .verifyResult("Gender", gender)
        .verifyResult("Mobile", phone)
        .verifyResult("Date of Birth", "14 October,1990")
        .verifyResult("Subjects", "Computer Science")
        .verifyResult("Hobbies", "Sports, Reading, Music")
        .verifyResult("Picture", "key.txt")
        .verifyResult("Address", "текущий адрес")
        .verifyResult("State and City", "NCR Delhi")
        .closeModalResult();


  }
}
