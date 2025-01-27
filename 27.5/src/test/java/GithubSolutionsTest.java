import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class GithubSolutionsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void openEnterprisePage() {
        open("https://github.com");
        $("nav").$(byTagAndText("button","Solutions")).hover();
        $("[href='/enterprise']").click();
//        $(byTagAndText("a", "Enterprise")).click();
        webdriver().shouldHave(url("https://github.com/enterprise"));
    }
}
