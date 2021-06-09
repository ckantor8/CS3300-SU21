package model;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

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
    private ItemModel weapon;
    private ArrayList<ItemModel> inventory = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeapon(ItemModel weapon) {
        this.weapon = weapon;
    }

    public ItemModel getWeapon() {
        return weapon;
    }

    public void setStartingWeapon(String weapon) {
        this.startingWeapon = weapon;
    }

    public String getStartingWeapon() {
        return startingWeapon;
    }

    public void setStartWeapon() {
        this.startWeapon = weapon.getImg();
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

    public void addToInventory(ItemModel item) {
        this.inventory.add(item);
    }

    public ArrayList<ItemModel> getInventory() {
        return inventory;
    }

}
