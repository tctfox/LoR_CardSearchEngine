package testing;

import model.Card;
import model.searchCard;

import java.io.IOException;

public class testing2 {

    public static void main(String[] args) throws IOException {

        searchCard searcher = new searchCard();

        for (Card currentCard : searcher.searchAllCards("Yasuo")){
            System.out.println(currentCard);
        }

    }

}
