package tests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import static pages.RegistrationPage.*;

public class PracticeFormTestPO extends TestBase {

    RegistrationPage registartionPage = new RegistrationPage();


    @Test
    void fillFullFormTestV1() {

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
    void fillFullFormTestV2() {

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
                .checkResult("Student Name",firstName + " " + lastName)
                .checkResult("Student Email",userEmail)
                .checkResult("Gender",gender)
                .checkResult("Mobile",userNumber)
                .checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects",subject)
                .checkResult("Hobbies",hobby)
                .checkResult("Picture",picture)
                .checkResult("Address",currentAddress)
                .checkResult("State and City",state + " " + city);
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
