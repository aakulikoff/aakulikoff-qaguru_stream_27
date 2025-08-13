package allureTests.steps;

import com.codeborne.selenide.*;
import io.qameta.allure.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step ("Открыть главную страницу")
    public void openMainPage (String url) {
        open(url);
    }

    @Step ("Найти репозиторий")
    public void searchRepository (String repository) {
        $(byName("q")).setValue(repository).pressEnter();
    }

    @Step ("Перейти в репозиторий")
    public void goToRepository (String repository) {
        $(byLinkText(repository)).click();
    }

    @Step ("Перейти в Issues")
    public void openIssue() {
        $("#issues-tab").click();
    }

    @Step ("Проверить, что Issues №68 существует")
    public void checkIssueNumber(int number) {
        $(withText("#" + number)).shouldBe(Condition.visible);
    }

    @Attachment (value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs((OutputType.BYTES));
    }
}
