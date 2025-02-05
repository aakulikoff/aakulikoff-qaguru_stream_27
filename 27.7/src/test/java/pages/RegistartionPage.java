package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;

public class RegistartionPage {

    static Faker faker = new Faker();
    CalendarComponent calendarComponent = new CalendarComponent();

    public static String baseUrl = "https://demoqa.com/automation-practice-form",
            text = "Practice Form",
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = getRandomPhone(),
            monthOfBirth = "August",
            yearOfBirth = "1987",
            gender = "Male",
            dayOfBirth = "2",
            dayOfWeekOfBirth = "Sunday",
            subject = "Arts",
            hobby = "Sports",
            currentAddress = getRandomMessage(5,9),
            picture = "pic.jpeg",
            state = "NCR",
            city = "Delhi";

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            userGenderInput = $(byText(gender)),
            userSubjectInput = $("#subjectsInput"),
            userHobbieInput = $("#hobbiesWrapper"),
            userCurrentAddressInput = $("#currentAddress"),
            userStateInput = $("#stateCity-wrapper"),
            userCityInput = $("#stateCity-wrapper"),
            jpgInpit = $("#uploadPicture"),
            birthDateInput =  $("#dateOfBirthInput");


    public RegistartionPage openPage() {
        open(baseUrl);
        $(".text-center").shouldHave(text(text));

        return this;
    }

    public RegistartionPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistartionPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistartionPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistartionPage setUserGender() {
        userGenderInput.click();

        return this;
    }

    public RegistartionPage setPhoneNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistartionPage setBirtdayDate(String year, String month, String day, String dayOfWeek) {
        birthDateInput.click();
        calendarComponent.setDate(year,month,day, dayOfWeek);
        return this;
    }

    public RegistartionPage setSubject(String value) {
        userSubjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistartionPage setHobbie(String value) {
        userHobbieInput.$(byText(value)).click();

        return this;
    }

    public RegistartionPage uploadPicture() {
        jpgInpit.uploadFromClasspath("img/" + picture);

        return this;
    }

    public RegistartionPage setCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);

        return this;
    }

    public RegistartionPage setState(String value) {
        $("#state").scrollTo().click();
        userStateInput.$(byText(value)).click();

        return this;
    }

    public RegistartionPage setCity(String value) {
        $("#city").click();
        userCityInput.$(byText(value)).click();

        return this;
    }

    public RegistartionPage submintPage() {
        $("#submit").scrollTo().click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail), text(gender));

        return this;
    }

    public RegistartionPage checkFullDataPage(){
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(userEmail));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(userNumber));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));

        return this;
    }

    public RegistartionPage checkMinDataPage(){
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldBe(empty);
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(userNumber));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldBe(empty);
        $x("//td[text()='Hobbies']").parent().shouldBe(empty);
        $x("//td[text()='Picture']").parent().shouldBe(empty);
        $x("//td[text()='Address']").parent().shouldBe(empty);
        $x("//td[text()='State and City']").parent().shouldBe(empty);

        return this;
    }

}

