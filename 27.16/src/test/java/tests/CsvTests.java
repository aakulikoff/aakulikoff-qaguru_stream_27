package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Files.readTextFromPath;

public class CsvTests extends TestData{

    @Test
    void csvFileTest() throws IOException {
        String actualData = readTextFromPath(csvActualResult);
        String expectedData = readTextFromPath(csvExpectedResult);

//        assertThat(actualData, containsString(expectedData));
        assertEquals(actualData, expectedData);
    }
}
