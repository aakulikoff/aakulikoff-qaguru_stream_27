package allureTests;

import allureTests.steps.WebSteps;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    public static final String BASEURL = "https://github.com/";
    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final Integer ISSUE_NUMBER = 68;

    WebSteps steps = new WebSteps();

//    @BeforeAll
//    static void configBrowser() {
//        Configuration.startMaximized = true;
//    }

    @AfterEach
    public void shutDownBrowser() {
        closeWebDriver();
    }

}
