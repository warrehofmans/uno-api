package it.unogame.services;

import it.unogame.enums.Color;
import it.unogame.model.Card;

import java.util.List;

public interface IRules {
    boolean canCardBePlayed(Card card1, Card card2);
     void removeCard(Card card);
     void addCard(Card card);
     void startGame(Card[] cards);
    List<Card> getCards();


}
