public class Bat {
    protected int energyLevel = 300;

    //constructor
    public Bat(int energyLevel) {
       this.energyLevel = energyLevel;
    }
    //getter setters
    public int getEnergyLevel() {
        return this.energyLevel;
    }

    public void setEnergyLevel(int energyLevel){
        this.energyLevel =  energyLevel;
    }

    public void fly(){
        this.setEnergyLevel(energyLevel - 50);
        System.out.println("Sound of bat taking off!");
    }

    public void eatHumans(){
        this.setEnergyLevel(energyLevel + 25);
        System.out.println("eat humans!");
    }

    public void attackTown(){
        this.setEnergyLevel(energyLevel - 100);
        System.out.println("sound of a town on fire!");
    }

    public int displayEnergyLevel(){
        System.out.println("Energy level is: " + getEnergyLevel());
        return getEnergyLevel();
    }
}