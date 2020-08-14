public class Ninja extends Human {

    //directly calls Human constructor
    public Ninja() {
        super(0, 0, 10, 100);
    }

    public void steal(Human target){
        int newHumanHealth = target.health -= this.stealth;
        int newNinjaHealth = this.health += this.stealth;

        System.out.println("New Human Health! " + newHumanHealth);
        System.out.println("New ninja Health! " + newNinjaHealth);
    }

    public void runAway() {
        this.health -= 10;
    }
}