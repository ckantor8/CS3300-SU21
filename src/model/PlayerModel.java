package model;

import javafx.scene.image.ImageView;

public class PlayerModel {
    private String name;
    private String startingWeapon;
    private ImageView startWeapon;
    private int difficulty;
    private int gold;
    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private int goldMult;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStartingWeapon(String weapon) {
        this.startingWeapon = weapon;
    }

    public String getStartingWeapon() {
        return startingWeapon;
    }

    public ImageView getStartWeapon() {
        return startWeapon;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setHP(int hp) {
        this.healthPoints = hp;
    }

    public int getHP() {
        return healthPoints;
    }

    public void setAP(int ap) {
        this.attackPoints = ap;
    }

    public int getAP() {
        return attackPoints;
    }

    public void setDP(int dp) {
        this.defensePoints = dp;
    }

    public int getDP() {
        return defensePoints;
    }

    public void setGoldMult(int mult) {
        this.goldMult = mult;
    }

    public int getGoldMult() {
        return goldMult;
    }

}
