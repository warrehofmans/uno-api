package it.unogame.model;

public class CardCheck {
    private Card card;
    private Card[] cards;

    public CardCheck(Card card, Card[] cards) {
        this.card = card;
        this.cards = cards;
    }

    public Card getCard() {
        return card;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

}
