import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    void successfulGoogleSelenideSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
//        $("#main").shouldHave(text("https://ru.selenide.org"));
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
    }

    @Test
    void successfulGoogleMosSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("mos ru").pressEnter();
//        $("#main").shouldHave(text("https://ru.selenide.org"));
        $("[id=search]").shouldHave(text("Официальный сайт Мэра Москвы"));
    }

    @Test
    void successfulYandexMosSearchTest() {
        open("https://ya.ru/");
        $(".search3__input").click();
        $("[id=search-result]").shouldHave(text("Официальный сайт Мэра Москвы"));
    }
}

