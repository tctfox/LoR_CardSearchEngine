package dbTesting;
import dbIndexing.dbCreate;

import java.io.FileNotFoundException;
import java.sql.*;

public class dbtest {

    private static final String dbUrl = "jdbc:sqlite:src/main/java/resources/Cards.db";

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        dbCreate.dbFullFill();
    }






}
