package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class searchCard {

    indexCards indexer = new indexCards();
    private List<Card> cardList = indexer.getCardList();

    public searchCard() throws FileNotFoundException {
    }

    public Card searchCardExact(String name){
        for (Card currentCard : cardList){
            if (currentCard.name.equals(name)){
                return currentCard;
            }
        }
        return null;
    }

    public List<Card> searchAllCards(String name){
        List<Card> outputList = new ArrayList<>();
        for (Card currentCard : cardList){
            if (currentCard.name.contains(name)){
                outputList.add(currentCard);
            }
        }
        return outputList;
    }
}
