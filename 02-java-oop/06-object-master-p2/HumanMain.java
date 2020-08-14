public class HumanMain {
    public static void main(String[] args) {
        Human yourHuman =  new Human(3, 3, 3, 100);
        Human myHuman = new Human(10, 3, 3, 100);

        myHuman.attack(yourHuman);
        System.out.println(yourHuman.getHealth());

        //Wizard 
        Wizard merlin = new Wizard();

        //heal attacked human
        merlin.heal(yourHuman);
        System.out.println(yourHuman.getHealth());

        // fireball
        merlin.fireball(yourHuman);
        System.out.println("Your health is now at " + yourHuman.getHealth() + "!");

        //Ninja 
        Ninja ninja = new Ninja();

        System.out.println(yourHuman.getHealth());
        ninja.steal(yourHuman);

        //runAway decrease 10
        ninja.runAway();
        System.out.println(ninja.getHealth());

        //Samurai
        Samurai mySamurai = new Samurai();

        //deathblow method
        mySamurai.deathBlow(yourHuman);

        mySamurai.meditate();
    }
}