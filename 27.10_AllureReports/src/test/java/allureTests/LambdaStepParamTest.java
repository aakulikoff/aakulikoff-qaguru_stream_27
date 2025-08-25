package allureTests;

import com.codeborne.selenide.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaStepParamTest extends TestBase {

    @ParameterizedTest( name = "{displayName} {0}")
    @ValueSource(strings = {"68", "74"})
    @DisplayName("Тетс на проверку Issues")
    @Description("Поиск в репозитрии eroshenkoam Issue №68 и №74")
    @Link(name = "Github", url = "https://github.com")
    @Owner("kulikovaa")
    @Epic("GitGub")
    @Feature("Поиск")
    @Story("Issue")
    @Severity(SeverityLevel.NORMAL)
    public void testGitHub(String issue) {
        Allure.parameter("Issue", issue);

        step("Открыть главную страницу", () -> {
            open(BASEURL);
        });
        step("Найти репозиторий", () -> {
            $(byName("q")).setValue(REPOSITORY).pressEnter();
        });
        step("Перейти в репозиторий", () -> {
            $(byLinkText(REPOSITORY)).click();
        });
        step("Перейти в Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверить, что Issues №68 и №74 существуют", () -> {
            $(withText("#" + issue)).shouldBe(Condition.visible);
           takeScreenshot();
        });
    }

    @Attachment (value = "Screenshot", type = "image/png", fileExtension = "png")
    private byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs((OutputType.BYTES));
    }
}
