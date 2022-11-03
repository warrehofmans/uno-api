package it.unogame.services;

import it.unogame.enums.Color;
import it.unogame.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rules implements IRules {

    public boolean[] canCardsBePlayed(Card card1, Card[] cards) {
        boolean[] cardChecks = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            cardChecks[i] = this.canCardBePlayed(card1, cards[i]);
        }
        return cardChecks;
    }

    public boolean canCardBePlayed(Card card1, Card card2) {
        return this.canColorBePlayed(card1, card2) || this.canNumberBePlayed(card1, card2);
    }

    private boolean canColorBePlayed(Card card1, Card card2) {
        return card2
                .getColor() == Color.WILDCARD || card1.getColor() == Color.WILDCARD
                || card1.getColor() == card2.getColor();
    }

    private boolean canNumberBePlayed(Card card1, Card card2) {
        return card1.getNumber() == card2.getNumber();
    }

    public List<Card> getCards() {
        return Game.getActiveGame().getDeck();
    }

    public void startGame(Card[] cards) {
        Game.getActiveGame().addCards(cards);
    }

    public void removeCard(Card card) {
        Game.getActiveGame().removeCard(card);
    }

    public void addCard(Card card) {
        Game.getActiveGame().addCard(card);
    }
}
