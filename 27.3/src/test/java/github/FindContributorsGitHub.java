package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindContributorsGitHub {

    @Test
    void popUpClickTest() {
        Configuration.headless = false;
        // открыть страничку selenide
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому элементу в области Contributors
        $(".BorderGrid").$(byText("Contributors"))
                .closest("div").$("li").hover();
        // проверка: в появившемся окошечке (overlay)
        $$(".Popover-message").findBy(visible)
                .shouldHave(text("Andrei Solntsev"));
    }
}
