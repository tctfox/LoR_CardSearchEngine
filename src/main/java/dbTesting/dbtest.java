package dbTesting;
import java.io.FileNotFoundException;
import java.sql.*;

public class dbtest {

    private static final String dbUrl = "jdbc:sqlite:src/main/java/resources/Cards.db";

    public static void main(String[] args) {

        searchByName("Zed");


    }


    public static void searchByName(String searchName) {

        String sql = "SELECT * FROM cards where name ='"+searchName+"'";

        try (Connection conn = DriverManager.getConnection(dbUrl);
             Statement stmt = conn.createStatement()) {

            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("-----------------------------------------------------");
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("descriptionraw"));
                System.out.println(resultSet.getString("fullabsolutepath"));
                System.out.println("-----------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
