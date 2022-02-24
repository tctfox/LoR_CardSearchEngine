package dbTesting;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class executeJsonTests {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        jsonTestRegions jsonTestRegions = new jsonTestRegions();
        jsonTestRegions.parseFile("/set1-en_us.json");
        jsonTestRegions.parseFile("/set2-en_us.json");
        jsonTestRegions.parseFile("/set3-en_us.json");
        jsonTestRegions.parseFile("/set4-en_us.json");
        jsonTestRegions.parseFile("/set5-en_us.json");

        int number = 68;

        System.out.println(jsonTestRegions.cardlist.get(number));
        jsonTestRegions.cardlist.get(number).printregions();
        System.out.println(jsonTestRegions.cardlist.size());
    }

}
