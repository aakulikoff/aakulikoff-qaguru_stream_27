package tests;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;
import static utils.Zip.unzip;

public class ZipTests extends TestData {

     @Test
     void zipPasswordTest() throws IOException, ZipException  {

         String zipFilePath = zipActualResult;
         String unzipFolderPath = unzipFolder;
         String zipPassword = password;
         String unzipTxtFilePath = unzipPath;
         String expectedData = "Page Objects - это просто!";

         unzip(zipFilePath, unzipFolderPath, zipPassword);

         String actualData = readTextFromPath(unzipTxtFilePath);

         assertThat(actualData, equals(expectedData));
     }


}
