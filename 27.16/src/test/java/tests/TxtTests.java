package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.readTextFromPath;

public class TxtTests extends TestData {

    @Test
    void txtFileTest() throws IOException {
        String txtFilePath = "src/test/resources/files/txt/doc.txt";
        String expectedData = readTextFromPath(txtExpectedResult);
        String actualData = readTextFromPath(txtFilePath);

        assertThat(actualData, containsString(expectedData));
//        assertEquals(actualData, expectedData);
    }
}
