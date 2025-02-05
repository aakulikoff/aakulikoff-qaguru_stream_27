package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import pages.RegistartionPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static pages.RegistartionPage.*;

public class PracticeFormTestPO extends TestBase {

    RegistartionPage registartionPage = new RegistartionPage();


    @Test
    void fillFullFormTest() {

        registartionPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender()
                .setPhoneNumber(userNumber)
                .setBirtdayDate(yearOfBirth,monthOfBirth,dayOfBirth,dayOfWeekOfBirth)
                .setSubject(subject)
                .setHobbie(hobby)
                .uploadPicture()
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submintPage()
                .checkFullDataPage();
    }

    @Test
    void fillMinFormTest() {

        registartionPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserGender()
                .setPhoneNumber(userNumber)
                .setBirtdayDate(yearOfBirth,monthOfBirth,dayOfBirth,dayOfWeekOfBirth)
                .submintPage()
                .checkMinDataPage();
    }
}
