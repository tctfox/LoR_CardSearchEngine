package dbTesting;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class jsongettests {

    public static void main(String[] args) throws IOException {

        for (int i = 1; i < 6; i++){
            String urlString = String.format("https://dd.b.pvp.net/latest/set%o/en_us/data/set%o-en_us.json",i,i);
            String setDestinationString = String.format("src/main/java/resources/set%o-en_us.json",i);

            URL setwebsite = new URL(urlString);
            File set = new File(setDestinationString);
            FileUtils.copyURLToFile(setwebsite, set);
        }
    }

}
