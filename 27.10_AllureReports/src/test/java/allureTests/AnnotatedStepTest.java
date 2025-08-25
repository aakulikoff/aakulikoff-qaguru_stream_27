package allureTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class AnnotatedStepTest extends TestBase {


    @Test
    @DisplayName("Тетс на проверку Issues")
    @Description("Поиск в репозитрии eroshenkoam Issue №68")
    @Link(name = "Github", url = "https://github.com")
    @Owner("kulikovaa")
    @Epic("GitHub")
    @Feature("Поиск")
    @Story("Issue")
    @Severity(SeverityLevel.CRITICAL)
    public void testGitHub() {
        steps.openMainPage(BASEURL);
        steps.searchRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssue();
        steps.checkIssueNumber(ISSUE_NUMBER);
        steps.takeScreenshot();
    }

}
