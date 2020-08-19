public class ProjectTest{
    public static void main(String[] args) {
        Project project =  new Project();
        project.setName("Mike");
        project.setDescription("Schoolwork");

        Project project2 = new Project("Mike", "Schoolwork2");
        //will return "Mike"
        project2.getName();

    System.out.println(project.elevatorPitch());
    }
}