package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPdf;

public class PdfTests extends TestData {

    @Test
    void pdfFileTest() throws IOException {
        String pdfFilePath = pdfActualResult;
        String expectedData = "Page Objects - это просто";

//        String expectedData = pdfExpectedResult;
        // TODO: как сравнить 2pdf файла, что то не получилось у меня?

        PDF pdf = getPdf(pdfFilePath);
        assertThat(pdf, PDF.containsText(expectedData));

    }
}
