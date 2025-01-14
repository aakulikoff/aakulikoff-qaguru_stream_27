package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideGitHub {

    @BeforeEach
    public void setUp() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void gitHubSelenideSearch() {
        //открыть страницу github
        open("https://github.com/");

        //ввести в поле поиска selenide и нажать enter
        $(".search-input-container").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        //проверить выдаваемый поиск
        $("[data-testid=results-list]").shouldHave(text("selenide/selenide"));

        //кликнуть 'selenide/selenide'
        $(byLinkText("selenide/selenide")).click();
//        выбрать первый найденый проект из списка и кликнуть на него
//        $$("ul.repo-list li").first().$("a").click();

        //проверить, что в заголовке встречается selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

        //кликнуть по Wiki
        $("#wiki-tab").click();

        //проверить, что текст Soft assertions видимый и кликнуть по нему
        $(byText("Soft assertions"))
                .shouldBe(visible)
                .click();

        //проверить наличие на странице Using JUnit5 extend test class
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }


    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#columns").should(appear);
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
//        Selenide.actions().dragAndDrop($("#column-a"),$("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));


    }
}
