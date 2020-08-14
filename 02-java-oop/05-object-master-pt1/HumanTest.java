public class HumanTest {
    public static void main(String[] args) {
        Human yourHuman =  new Human(3, 3, 3);
        Human myHuman = new Human(10, 3, 3);

        myHuman.attack(yourHuman);
        System.out.println(yourHuman.getHealth());
    }
}