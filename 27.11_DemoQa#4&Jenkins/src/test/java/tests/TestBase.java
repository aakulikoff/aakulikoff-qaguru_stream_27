package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    public void setUp() {
        Configuration.pageLoadStrategy = "eager";
    }

    String baseUrl = "https://demoqa.com/automation-practice-form",
            text = "Practice Form",
            firstName = "Peter",
            lastName = "The Great",
            userEmail = "russia@rf.ru",
            userNumber = "9119991122",
            monthOfBirth = "August",
            yearOfBirth = "1987",
            gender = "Male",
            dayOfBirth = "2",
            dayOfWeekOfBirth = "Sunday",
            subject = "Arts",
            hobby = "Sports",
            currentAddress = "Russia, Saint-Petersburg, Palace",
            picture = "pic.jpeg",
            state = "NCR",
            city = "Delhi";
}
