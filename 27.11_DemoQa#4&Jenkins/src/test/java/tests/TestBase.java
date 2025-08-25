package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    public void setUp() {
        Configuration.pageLoadStrategy = "eager";
    }

}
