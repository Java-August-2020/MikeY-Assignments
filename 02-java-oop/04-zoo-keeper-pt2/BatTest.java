public class BatTest {
    public static void main(String[] args) {
        Bat battytheBat = new Bat(300);

        //attack three towns
        battytheBat.displayEnergyLevel();
        battytheBat.attackTown();
        battytheBat.displayEnergyLevel();

        battytheBat.attackTown();
        battytheBat.displayEnergyLevel();

        battytheBat.attackTown();
        battytheBat.displayEnergyLevel();

        //eat two humans
        battytheBat.eatHumans();
        battytheBat.eatHumans();
        battytheBat.displayEnergyLevel();

        //fly twice
        battytheBat.fly();
        battytheBat.fly();
        battytheBat.displayEnergyLevel();
    }
}