package model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class indexCards {

    //Cardlist
    private List<Card> cardList = new ArrayList<>();

    //Files
    File file1 = new File("src/main/resources/set1-en_us.json");
    File file2 = new File("src/main/resources/set2-en_us.json");
    File file3 = new File("src/main/resources/set3-en_us.json");
    File file4 = new File("src/main/resources/set4-en_us.json");
    File file5 = new File("src/main/resources/set5-en_us.json");


    private void parseFile(String location) throws FileNotFoundException {

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
            String description = cardObject.get("descriptionRaw").getAsString();
            String loreText = cardObject.get("flavorText").getAsString();
            String cardCode = cardObject.get("cardCode").getAsString();

            //Get Assets Array
            JsonArray cardAssets = cardObject.getAsJsonArray("assets");
            JsonObject cardAssetsObject = cardAssets.get(0).getAsJsonObject();
            String fullPicture = cardAssetsObject.get("fullAbsolutePath").getAsString();
            String gamePicure = cardAssetsObject.get("gameAbsolutePath").getAsString();

            //Get Type
            CardTypes cardType = CardTypes.NONE;
            if (cardObject.get("type").getAsString().equals("Unit")){
                if(cardObject.get("supertype").getAsString().equals("champion")){
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


            //Create card and add it to the Array
            Card currentCard = new Card(cardName, description, loreText, cardCode, cardType, fullPicture, gamePicure);
            cardList.add(currentCard);
        }
    }

    public void parseAllCards() throws FileNotFoundException {
        parseFile("/set1-en_us.json");
        parseFile("/set2-en_us.json");
        parseFile("/set3-en_us.json");
        parseFile("/set4-en_us.json");
        parseFile("/set5-en_us.json");
    }

    public indexCards() throws FileNotFoundException {
        this.parseAllCards();
    }

    public List<Card> getCardList() {
        return Collections.unmodifiableList(cardList);
    }
}
