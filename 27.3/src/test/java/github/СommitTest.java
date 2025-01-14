package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class СommitTest {

    @Test
    void commitTest(){
        open("https://github.com/");
        $(byName("q")).setValue("qaguru").pressEnter();
        $(byName("q")).setValue("allure").pressEnter();
        $(byName("q")).setValue("selenide").pressEnter();
        $(byName("q")).setValue("kulikov").pressEnter();
    }
}
