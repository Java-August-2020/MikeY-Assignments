public class GorillaTest {
    public static void main(String[] args) {
        Gorilla gorilla1 = new Gorilla();

        gorilla1.displayEnergyLevel();

        //throw three things
        gorilla1.throwSomething();
        gorilla1.throwSomething();
        gorilla1.throwSomething();

        gorilla1.displayEnergyLevel();

        //eat a banana
        gorilla1.eatBananas();
        gorilla1.displayEnergyLevel();

        //climb a tree
        gorilla1.climb();
        gorilla1.displayEnergyLevel();

        //eat a 2nd banana
        gorilla1.eatBananas();
        gorilla1.displayEnergyLevel();
        
    }
}