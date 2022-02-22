package dbTesting;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;

public class dbtest {

    private static final String dbUrl = "jdbc:sqlite:src/main/java/resources/Cards.db";

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        dbCreate.dbFullFill();
    }






}
