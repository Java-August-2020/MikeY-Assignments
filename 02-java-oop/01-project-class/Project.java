public class Project{
    private String name;
    private String description;

    public Project() {
    }

    //overload the method 1)
    public Project(String name) {
        this.name = name;
    }

    //overload the method 2)
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

      public String setDescription() {
        return this.description;
    }

    //create elevatorPitch
    public String elevatorPitch() {
        return this.name + ":" + this.description;
    }
}