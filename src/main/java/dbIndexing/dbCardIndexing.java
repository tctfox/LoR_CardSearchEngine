package dbIndexing;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Card;
import model.CardTypes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class dbCardIndexing {

    //Cardlist
    private List<Card> cardList = new ArrayList<>();
    private final String dbUrl = "jdbc:sqlite:src/main/java/resources/Cards.db";

    //Files
    File file1 = new File("src/main/resources/set1-en_us.json");
    File file2 = new File("src/main/resources/set2-en_us.json");
    File file3 = new File("src/main/resources/set3-en_us.json");
    File file4 = new File("src/main/resources/set4-en_us.json");
    File file5 = new File("src/main/resources/set5-en_us.json");


    private void parseFile(String location) throws FileNotFoundException, SQLException {

        JsonElement fileElement = null;

        try (InputStream is = this.getClass().getResourceAsStream(location);
             Reader rd = new InputStreamReader(is, "UTF-8"); ) {
            fileElement = JsonParser.parseReader(rd);
        } catch (Exception ex) {
            System.out.println("failed to read: "+ex.getMessage());
        }

        //Read fileElement as JsonArrayObject
        JsonArray jsonArray = fileElement.getAsJsonArray();

        for (JsonElement cardElement: jsonArray){
            JsonObject cardObject = cardElement.getAsJsonObject();

            //Get Card Fields
            String cardName = cardObject.get("name").getAsString();
            String descriptionRaw = cardObject.get("descriptionRaw").getAsString();
            String flavorText = cardObject.get("flavorText").getAsString();
            String cardCode = cardObject.get("cardCode").getAsString();

            //Get Assets Array
            JsonArray cardAssets = cardObject.getAsJsonArray("assets");
            JsonObject cardAssetsObject = cardAssets.get(0).getAsJsonObject();
            String fullAbsolutePath = cardAssetsObject.get("fullAbsolutePath").getAsString();
            String gameAbsolutePath = cardAssetsObject.get("gameAbsolutePath").getAsString();

            //Get Type
            CardTypes cardType = CardTypes.NONE;
            if (cardObject.get("type").getAsString().equals("Unit")){
                if(cardObject.get("supertype").getAsString().equals("Champion")){
                    cardType = CardTypes.CHAMPION;
                }
                else{
                    cardType = CardTypes.UNIT;
                }
            }
            if (cardObject.get("type").getAsString().equals("Landmark")){
                cardType = CardTypes.LANDMARK;
            }
            if (cardObject.get("type").getAsString().equals("Spell")){
                cardType = CardTypes.SPELL;
            }
            if (cardObject.get("type").getAsString().equals("Ability")){
                cardType = CardTypes.SKILL;
            }
            if (cardObject.get("type").getAsString().equals("Trap")){
                cardType = CardTypes.TRAP;
            }




            //Create card and add it to the Array
            //Card currentCard = new Card(cardName, descriptionRaw, flavorText, cardCode, cardType, fullAbsolutePath, gameAbsolutePath);
            //cardList.add(currentCard);


            //Add stuff to db
            String sql = "INSERT INTO cards (name, descriptionraw, flavortext, cardcode, cardtype, fullabsolutepath, gameabsolutepath)"
                    + "VALUES (?,?,?,?,?,?,?)";

            Connection conn = DriverManager.getConnection(dbUrl);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cardName);
            statement.setString(2, descriptionRaw);
            statement.setString(3, flavorText);
            statement.setString(4, cardCode);
            statement.setString(5, cardType.toString());
            statement.setString(6, fullAbsolutePath);
            statement.setString(7, gameAbsolutePath);
            statement.executeUpdate();

        }
    }

    public void parseFileInfo(String location) throws FileNotFoundException, SQLException{
        JsonElement fileElement = null;
        JsonArray jsonArray1 = null;
        JsonArray jsonArray2 = null;

        try (InputStream is = this.getClass().getResourceAsStream(location);
             Reader rd = new InputStreamReader(is, "UTF-8"); ) {
            fileElement = JsonParser.parseReader(rd);
            JsonObject jsonObject = fileElement.getAsJsonObject();
            jsonArray1 = jsonObject.getAsJsonArray("vocabTerms");
            jsonArray2 = jsonObject.getAsJsonArray("keywords");
        } catch (Exception ex) {
            System.out.println("failed to read: "+ex.getMessage());
        }

        for (JsonElement infoElement: jsonArray1){
            JsonObject infoObject = infoElement.getAsJsonObject();
            String name = infoObject.get("name").getAsString();
            String description = infoObject.get("description").getAsString();
            String type = "VocabTerm";

            //Add stuff to db
            String sql = "INSERT INTO misc (name, description, type)"
                    + "VALUES (?,?,?)";
            Connection conn = DriverManager.getConnection(dbUrl);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setString(3, type);
            statement.executeUpdate();

        }

        for (JsonElement infoElement: jsonArray2){
            JsonObject infoObject = infoElement.getAsJsonObject();
            String name = infoObject.get("name").getAsString();
            String description = infoObject.get("description").getAsString();
            String type = "KeyWord";

            //Add stuff to db
            String sql = "INSERT INTO misc (name, description, type)"
                    + "VALUES (?,?,?)";
            Connection conn = DriverManager.getConnection(dbUrl);
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setString(3, type);
            statement.executeUpdate();
        }

    }


    public void parseAllCards() throws FileNotFoundException, SQLException {
        parseFile("/set1-en_us.json");
        parseFile("/set2-en_us.json");
        parseFile("/set3-en_us.json");
        parseFile("/set4-en_us.json");
        parseFile("/set5-en_us.json");
    }
}
