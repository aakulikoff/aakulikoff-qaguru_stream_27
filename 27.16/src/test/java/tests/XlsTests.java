package tests;

import com.codeborne.xlstest.XLS;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.*;

public class XlsTests extends TestData {

    @Test
    void xlsFileTest() throws IOException {
        String xlsFilePath = xlsActualResult;
        String expectedData = "Hello world";

//        String expectedData = xlsExpectedResult;
        // TODO: как сравнить 2 xls файла?

        XLS xls = getXls(xlsFilePath);
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void xlsCellTest() throws IOException {
        String xlsFilePath = xlsActualResult;
        String expectedData = "Hello world";

        XLS xls = getXls(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(7).getCell(1).toString();
        assertThat(actualData, Matchers.containsString(expectedData));
    }


    @Test
    void xlsxTest() {
        String xlsFilePath = xlsxActualResult;
        String expectedData = "Wow bow text";

        String actualData = readXlsxFromPath(xlsFilePath);
        assertThat(actualData, Matchers.containsString(expectedData));
    }


}
