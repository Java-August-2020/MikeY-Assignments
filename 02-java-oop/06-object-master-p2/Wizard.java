public class Wizard extends Human {

    //directly calls Human constructor
    public Wizard() {
        super(0, 8, 0, 50);
    }

    public void heal(Human target){
        target.health += this.intelligence;
    }

    public void fireball(Human target){
        target.health -= this.intelligence * 3;
    }
}