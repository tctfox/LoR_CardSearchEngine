package model;

public class Card {

    String name;
    String descriptionRaw;
    String loreText;
    String cardCode;

    CardTypes cardType;

    String fullPicture;
    String gamePicture;

    int attack;
    int cost;
    int health;


    public Card(String name, String descriptionRaw, String loreText, String cardCode) {
        this.name = name;
        this.descriptionRaw = descriptionRaw;
        this.loreText = loreText;
        this.cardCode = cardCode;
    }

    public Card(String name, String descriptionRaw, String loreText, String cardCode, String fullPicture, String smallPicture) {
        this.name = name;
        this.descriptionRaw = descriptionRaw;
        this.loreText = loreText;
        this.cardCode = cardCode;
        this.fullPicture = fullPicture;
        this.gamePicture = smallPicture;
    }

    public Card(String name, String descriptionRaw, String loreText, String cardCode, CardTypes cardType, String fullPicture, String gamePicture) {
        this.name = name;
        this.descriptionRaw = descriptionRaw;
        this.loreText = loreText;
        this.cardCode = cardCode;
        this.cardType = cardType;
        this.fullPicture = fullPicture;
        this.gamePicture = gamePicture;
    }

    public String getName() {
        return name;
    }

    public String getDescriptionRaw() {
        return descriptionRaw;
    }

    public String getLoreText() {
        return loreText;
    }

    public String getFullPicture() {
        String beginning = this.fullPicture.substring(0, 4);
        String ending = this.fullPicture.substring(4);
        return beginning + "s" + ending;
    }

    public String getGamePicture() {
        String beginning = this.gamePicture.substring(0, 4);
        String ending = this.gamePicture.substring(4);
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
                "\nLore Text: " + getLoreText() +
                "\nCardCode: " + this.cardCode +
                "\nFull Picture: " + this.fullPicture +
                "\nGame Picture: " + this.gamePicture +
                "\nType: " + this.cardType+"\n" +
                spacer;

    }
}
