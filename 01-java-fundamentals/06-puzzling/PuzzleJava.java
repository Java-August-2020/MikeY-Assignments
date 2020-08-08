import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    //print sum of values in an array
    public void printSum() {
        int sum = 0;
        int [] mySum = {3,5,1,2,7,9,8,13,25,32};
            for (int i = 0; i < mySum.length; i++){
            // sum += mySum[i];
            // System.out.println(sum);

            //if greater than 10, print the elements
            if (mySum[i] > 10) {
                System.out.println(mySum[i]);
            }
        }
    }

    //Have the method also return an array with names that are longer than 5 characters.

    public void myPeople(){
        ArrayList<String> people = new ArrayList<String>();
        people.add("Nanc");
        people.add("Jinichi");
        people.add("Fujibayashi");
        people.add("Momochi");
        people.add("Ishikawa");

        Collections.shuffle(people);
        
    // System.out.println(people);

        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).length() > 5){
            System.out.println(people);
            }
        }
    }

    public void alphabet() {
    ArrayList<Character> alphabet = new ArrayList<Character>();   
    for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
                System.out.println(ch + " is vowel");
            }
        }

        System.out.println(alphabet);

		Collections.shuffle(alphabet); //shuffle
        System.out.println(alphabet);
        
        //display last
        System.out.println(alphabet.get(25));
        //display first
        System.out.println(alphabet.get(0));

    }

    //Generate and return an array with 10 random numbers between 55-100

    public void rand10() {
        ArrayList<Integer> randomArray = new ArrayList<Integer>();
        Random r = new Random();

        int low = 55;
        int high = 100;

        for (int i = 0; i < 10; i++) {
            int result = r.nextInt(high-low) + low;
            randomArray.add(result);
            System.out.println(result);
        }

        //sort show smallest first
        Collections.sort(randomArray);
        System.out.println(randomArray);

        //print smallest
            System.out.println(randomArray.get(0));
        //print largest
        System.out.println(randomArray.get(9));
    }

    //Create a random string that is 5 characters long.
    // public void randString() {
    //     Random r = new Random();
        
}