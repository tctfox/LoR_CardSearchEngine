package dbTesting;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class jsontest2 {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        jsontest1 jsontest1 = new jsontest1();
        jsontest1.parseFile("/set2-en_us.json");

        int number = 68;

        System.out.println(jsontest1.cardlist.get(number));
        jsontest1.cardlist.get(number).printregions();
    }

}
