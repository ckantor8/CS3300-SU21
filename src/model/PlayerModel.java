package model;

import javafx.scene.paint.Color;

public class PlayerModel {
    private String name;
    private Color character;
    private int gold;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCharacter(Color character) {
        this.character = character;
    }

    public Color getCharacter() {
        return character;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

}
