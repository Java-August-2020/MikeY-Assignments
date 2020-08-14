public class Human {
    protected int strength = 3;
    protected int intelligence = 3;
    protected int stealth = 3;
    protected int health = 100;

    public Human(int strength, int intelligence, int stealth, int health) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.stealth = stealth;
        this.health = health;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStealth() {
        return this.stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attack(Human target){
        target.health -= this.strength;
    }
}