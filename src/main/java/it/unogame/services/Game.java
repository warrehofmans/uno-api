package it.unogame.services;

import it.unogame.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static Game _currentGame = null;
    private final List<Card> deck = new ArrayList<>();
    private Game () {}

    private static void createGame () {
        _currentGame = new Game ();
    }

    public List<Card> getDeck() {
        return deck;
    }

    public static Game getActiveGame () {
        if (_currentGame == null) createGame();
        return _currentGame;
    }

    public void addCard(Card card){
        this.deck.add(card);
    }

    public void removeCard(Card card){
       Card removedCard = this.deck.stream().filter(c -> c.getColor() == card.getColor() && c.getNumber() == c.getNumber()).toList().get(0);
        this.deck.remove(removedCard);
    }

    public  void addCards(Card[] cards){
            this.deck.addAll(List.of(cards));
    }
}
