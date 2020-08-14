public class Samurai extends Human {
    private static int numSamurai = 0;

    //directly calls Human constructor
    public Samurai() {
        super(0, 0, 10, 200);
        Samurai.numSamurai++;
    }

    public void deathBlow(Human target){
        int newHumanHealth = target.health = 0;
        int newSamuraiHealth = this.health / 2;

        System.out.println("New Human Health! " + newHumanHealth);
        System.out.println("New Samurai Health! " + newSamuraiHealth);
    }

    public void meditate() {
        int newHealth = this.health += this.health/2;
        System.out.println("New Meditated health: " + newHealth);
    }

        public static int howMany() {
            return Samurai.numSamurai;
    }
}