
public class Mammal {
    //Attributes
    protected int energyLevel = 100;

    //Constructor
    public Mammal(int energyLevel){
        this.energyLevel = energyLevel;
    }

    //getters setters
    public int getEnergyLevel(){
        return this.energyLevel;
    }

    public void setEnergyLevel(int energyLevel){
        this.energyLevel = energyLevel;
    }

    public int displayEnergyLevel(){
        System.out.println("energy level is: " + getEnergyLevel());
        return getEnergyLevel();
    }
}
