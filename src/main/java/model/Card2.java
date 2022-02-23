package model;

import java.util.ArrayList;

public class Card2 {

    String name;
    String descriptionRaw;
    String flavorText;
    String cardCode;

    CardTypes cardType;

    String fullAbsolutePath;
    String gameAbsolutePath;

    ArrayList<String> regionslist = new ArrayList<>();

    int attack;
    int cost;
    int health;


    public Card2(String name, String descriptionRaw, String flavorText, String cardCode) {
        this.name = name;
        this.descriptionRaw = descriptionRaw;
        this.flavorText = flavorText;
        this.cardCode = cardCode;
    }

    public Card2(String name, String descriptionRaw, String flavorText, String cardCode, String fullAbsolutePath, String smallPicture) {
        this.name = name;
        this.descriptionRaw = descriptionRaw;
        this.flavorText = flavorText;
        this.cardCode = cardCode;
        this.fullAbsolutePath = fullAbsolutePath;
        this.gameAbsolutePath = smallPicture;
    }

    public Card2(String name, String descriptionRaw, String flavorText, String cardCode, CardTypes cardType, String fullAbsolutePath, String gameAbsolutePath) {
        this.name = name;
        this.descriptionRaw = descriptionRaw;
        this.flavorText = flavorText;
        this.cardCode = cardCode;
        this.cardType = cardType;
        this.fullAbsolutePath = fullAbsolutePath;
        this.gameAbsolutePath = gameAbsolutePath;
    }

    public String getName() {
        return name;
    }

    public String getDescriptionRaw() {
        return descriptionRaw;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public String getFullAbsolutePath() {
        String beginning = this.fullAbsolutePath.substring(0, 4);
        String ending = this.fullAbsolutePath.substring(4);
        return beginning + "s" + ending;
    }

    public String getGameAbsolutePath() {
        String beginning = this.gameAbsolutePath.substring(0, 4);
        String ending = this.gameAbsolutePath.substring(4);
        return beginning + "s" + ending;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void addRegion(String region){
        this.regionslist.add(region);
    }

    public void printregions(){
        for(String region : this.regionslist){
            System.out.println(region);
        }
    }

    @Override
    public String toString() {
        String spacer = "-----------------------------------";
        return  spacer +
                "\nName: " + getName() +
                "\nDescription: " + getDescriptionRaw() +
                "\nLore Text: " + getFlavorText() +
                "\nCardCode: " + this.cardCode +
                "\nFull Picture: " + this.fullAbsolutePath +
                "\nGame Picture: " + this.gameAbsolutePath +
                "\nType: " + this.cardType+"\n" +
                spacer;

    }
}
