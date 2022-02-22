package dbTesting;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class jsongettests {

    public static void main(String[] args) throws IOException {

        String urlString = "https://docs.google.com/spreadsheets/d/1Xlh2kg7gLzvqugqGPpI4PidAdM5snggbJ44aRLuik5E/export?format=csv&id=1Xlh2kg7gLzvqugqGPpI4PidAdM5snggbJ44aRLuik5E&gid=975656893";
        String setDestinationString = "src/main/java/resources/lor_ranked_data_allDecks.csv";

        URL setwebsite = new URL(urlString);
        File set = new File(setDestinationString);
        FileUtils.copyURLToFile(setwebsite, set);

    }

}
