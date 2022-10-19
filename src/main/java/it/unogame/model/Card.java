package it.unogame.model;

import it.unogame.enums.Color;

public class Card {
    private int number;
    private Color color;

    public Card(int number, String color) {
        this.number = number;
        this.color = Color.valueOf(color);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
