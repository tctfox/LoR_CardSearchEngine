package dbTesting;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Card2;
import model.CardTypes;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

public class jsonTestRegions {

    ArrayList<Card2> cardlist = new ArrayList<>();


    public void parseFile(String location) throws FileNotFoundException, SQLException {

        JsonElement fileElement = null;

        try (InputStream is = this.getClass().getResourceAsStream(location);
             Reader rd = new InputStreamReader(is, "UTF-8");) {
            fileElement = JsonParser.parseReader(rd);
        } catch (Exception ex) {
            System.out.println("failed to read: " + ex.getMessage());
        }

        //Read fileElement as JsonArrayObject
        JsonArray jsonArray = fileElement.getAsJsonArray();

        for (JsonElement cardElement : jsonArray) {
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
            if (cardObject.get("type").getAsString().equals("Unit")) {
                if (cardObject.get("supertype").getAsString().equals("Champion")) {
                    cardType = CardTypes.CHAMPION;
                } else {
                    cardType = CardTypes.UNIT;
                }
            }
            if (cardObject.get("type").getAsString().equals("Landmark")) {
                cardType = CardTypes.LANDMARK;
            }
            if (cardObject.get("type").getAsString().equals("Spell")) {
                cardType = CardTypes.SPELL;
            }
            if (cardObject.get("type").getAsString().equals("Ability")) {
                cardType = CardTypes.SKILL;
            }
            if (cardObject.get("type").getAsString().equals("Trap")) {
                cardType = CardTypes.TRAP;
            }


            Card2 localCard = new Card2(cardName, descriptionRaw, flavorText, cardCode, cardType, fullAbsolutePath, gameAbsolutePath);

            JsonArray cardRegionsJsonArray = cardObject.getAsJsonArray("regions");
            for (JsonElement regionelement : cardRegionsJsonArray){
                localCard.addRegion(regionelement.toString());
            }
            cardlist.add(localCard);
        }
    }
}
