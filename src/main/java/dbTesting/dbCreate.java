package dbTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import org.apache.commons.io.FileUtils;

public class dbCreate {

    private static final String dbUrl = "jdbc:sqlite:src/main/java/resources/Cards.db";

    public static void createNewDatabase() {

        try (Connection conn = DriverManager.getConnection(dbCreate.dbUrl)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createCardTable() {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS cards (\n"
                + "	name text NOT NULL,\n"
                + "	descriptionraw text,\n"
                + "	flavortext text,\n"
                + "	cardcode text PRIMARY KEY,\n"
                + "	cardtype text,\n"
                + "	fullabsolutepath text,\n"
                + "	gameabsolutepath text\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(dbCreate.dbUrl);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createMiscTable() {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS misc (\n"
                + "	name text NOT NULL,\n"
                + "	description text,\n"
                + "	type text \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(dbCreate.dbUrl);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fillTableCard() throws SQLException, FileNotFoundException {
        dbCardIndexing cardIndexer = new dbCardIndexing();
        cardIndexer.parseAllCards();
    }

    public static void fillMiscInfoTable() throws SQLException, FileNotFoundException {
        dbCardIndexing cardIndexer = new dbCardIndexing();
        cardIndexer.parseFileInfo("/globals-en_us.json");
    }

    public static void getJsons() throws IOException {
        for (int i = 1; i < 6; i++){
            String urlString = String.format("https://dd.b.pvp.net/latest/set%o/en_us/data/set%o-en_us.json",i,i);
            String setDestinationString = String.format("src/main/java/resources/set%o-en_us.json",i);

            URL setwebsite = new URL(urlString);
            File set = new File(setDestinationString);
            FileUtils.copyURLToFile(setwebsite, set);
        }
    }

    public static void dbFullCreate() throws SQLException, FileNotFoundException {
        try {
            getJsons();
        } catch (IOException e) {
            e.printStackTrace();
        }
        createNewDatabase();
        createCardTable();
        createMiscTable();
        fillTableCard();
        fillMiscInfoTable();
    }

}
