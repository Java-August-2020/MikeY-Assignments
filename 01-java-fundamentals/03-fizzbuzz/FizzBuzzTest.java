public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz iD = new FizzBuzz();
        for (int i = 0; i <= 50; i++) {
            String result = iD.fizzBuzz(i);
            System.out.println("number " + i + " - " + " Result: " + result);
        }
    }
}