package allureTests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideListenerTest extends TestBase {
    AllureLifecycle lifecycle = Allure.getLifecycle();

    @Test
    @DisplayName("Тетс на прверку Issues")
    @Description("Поиск в репозитрии eroshenkoam Issue №68")
    @Link(name = "Github", url = "https://github.com")
    @Owner("kulikovaa")
    @Epic("GitGub")
    @Feature("Поиск")
    @Story("Issue")
    @Severity(SeverityLevel.MINOR)
    public void testGitHub() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("https://github.com/");
        $(byName("q")).setValue("eroshenkoam/allure-example").pressEnter();
        $(byLinkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").should(Condition.exist);
        lifecycle.addAttachment("Screenshot", "img/png", "png", takeScreenshot());
    }

    private byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs((OutputType.BYTES));
    }
}
