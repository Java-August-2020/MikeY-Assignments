public class Gorilla extends Mammal {

    public Gorilla() {
        //constructor
        //because Mammal only has one parameter
        super(100);
    }

    public void throwSomething() {
        System.out.println("The gorilla has thrown something!");
        this.setEnergyLevel(energyLevel - 5);
    }

    public void eatBananas() {
        System.out.println("Satisfaction!");
        this.setEnergyLevel(energyLevel + 10);
    }

    public void climb() {
        System.out.println("The gorilla has climbed a tree!");
        this.setEnergyLevel(energyLevel - 10);
    }
}