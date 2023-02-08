package tests.jenkins;

import static io.qameta.allure.Allure.step;
import static tests.randomUtils.GenerateRandom.cityGenerator;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class RegistrationWithPageObjectFakerTestForJenkins extends TestBaseExtended {
  Faker faker = new Faker();

  @Tag("simple")
  @DisplayName("Заполнение формы регистрации DemoQA")
  @Test
  void successfulRegistrationTest() {
    String userName = faker.name().firstName();
    String surName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.options().option("Male","Female","Other");
    String phone = faker.phoneNumber().subscriberNumber(10);
    String day = String.format("%02d", faker.number().numberBetween(1, 28));
    String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    String year = faker.number().numberBetween(1900, 2022) + "";
    String object = faker.options().option("Hindi", "Social Studies", "Maths", "Economics");
    String hobby = faker.options().option("Reading", "Sports", "Music");
    String file = "key.txt";
    String address = faker.address().fullAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");;
    String city = cityGenerator(state);

    step("Open form", () -> {
    registrationPages.openPages();
    });

    step("Fill form", () -> {
      registrationPages
          .setFirstName(userName)
          .setLastName(surName)
          .setEmail(email)
          .setGender(gender)
          .setPhone(phone)
          .setBirthDay(day, month, year)
          .setObject(object)
          .setHobby(hobby)
          .setUploadFile()
          .setAddress(address)
          .setState(state)
          .setCity(city)
          .clickSubmitButton();
    });

    step("Verify result", () -> {
      registrationPages
          .verifyResultModalAppears()
          .verifyResult("Student Name", userName + " " + surName)
          .verifyResult("Student Email", email)
          .verifyResult("Gender", gender)
          .verifyResult("Mobile", phone)
          .verifyResult("Date of Birth", day + " " + month + "," + year)
          .verifyResult("Subjects", object)
          .verifyResult("Hobbies", hobby)
          .verifyResult("Picture", file)
          .verifyResult("Address", address)
          .verifyResult("State and City", state + " " + city);
    });

    step("Close modal", () -> {
      registrationPages
          .closeModalResult();
    });
  }
}
