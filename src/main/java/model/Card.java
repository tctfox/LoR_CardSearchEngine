package model;

public class Card {

    String name;
    String descriptionRaw;
    String flavorText;
    String cardCode;

    CardTypes cardType;

    String fullAbsolutePath;
    String gameAbsolutePath;

    int attack;
    int cost;
    int health;


    public Card(String name, String descriptionRaw, String flavorText, String cardCode) {
        this.name = name;
        this.descriptionRaw = descriptionRaw;
        this.flavorText = flavorText;
        this.cardCode = cardCode;
    }

    public Card(String name, String descriptionRaw, String flavorText, String cardCode, String fullAbsolutePath, String smallPicture) {
        this.name = name;
        this.descriptionRaw = descriptionRaw;
        this.flavorText = flavorText;
        this.cardCode = cardCode;
        this.fullAbsolutePath = fullAbsolutePath;
        this.gameAbsolutePath = smallPicture;
    }

    public Card(String name, String descriptionRaw, String flavorText, String cardCode, CardTypes cardType, String fullAbsolutePath, String gameAbsolutePath) {
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
