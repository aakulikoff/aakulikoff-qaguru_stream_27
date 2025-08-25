package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Files.*;

public class DocTests extends TestData {

    @Test
    void docFileTest() throws IOException {
        String expectedData = readTextFromPath(docActualResult);
//        String actualData = readTextFromPath("./src/test/resources/files/doc/document.doc");
        String actualData = "Тут нет ничего нового, заходи в следующий раз";

        assertThat(actualData, equals(expectedData));
    }


}
