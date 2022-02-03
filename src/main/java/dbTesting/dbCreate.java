package dbTesting;

import java.io.FileNotFoundException;
import java.sql.*;

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

    public static void createNewTable() {

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

    public static void fillTableCard() throws SQLException, FileNotFoundException {
        dbCardIndexing cardIndexer = new dbCardIndexing();
        cardIndexer.parseAllCards();
    }

    public static void dbFullCreate() throws SQLException, FileNotFoundException {
        createNewDatabase();
        createNewTable();
        fillTableCard();
    }

}
