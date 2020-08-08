import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    public void print255() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    public void printOdd() {
        for (int i = 1; i <= 255; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public void printSum() {
        int sum = 0;
        for (int i = 0; i <= 255; i++) {
            sum += i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    } 
    public void array(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
    }

    //find Max
    public static int getMaxValue(int[] nums) {
        // get the biggest number from array
        // loop over array, compare each value before or after it
        // Return the biggest number

        int biggestNumber = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > biggestNumber) {
                biggestNumber = nums[i];
            }
        }
        return biggestNumber;
    }

    public int getAverage(int [] newArray) {
        int sum  = 0;
        int average = 0;
        for (int i = 0; i < newArray.length; i++) {
            average = sum += i % newArray.length;
        }
        return average;
    }

    public void printOddArray() { 
        ArrayList<Integer> numsArrayList = new ArrayList<Integer>();
        for (int i =0; i <= 255; i++) {
            if (i % 2 != 0) {
                numsArrayList.add(i);
            }
            System.out.println(numsArrayList);
        }
    }

    public int greaterThanY(int[] myArray2, int y) {
            int count = 0; 
            int max = y; 

            for (int i = 0; i < myArray2.length; i++) {
                if (max < myArray2[i]) {
                    max = myArray2[i];
                    count++;
                }
            }
        return count;
    }
    
    public void squared(int [] myNewArray) {
        for (int i = 0; i < myNewArray.length; i++) {
            myNewArray[i] = myNewArray[i]*myNewArray[i];
            System.out.println(myNewArray[i]);
        }
    }

    public void eliminateNeg(int [] newArr) {
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] < 0) {
                newArr[i] = 0;
            }
            System.out.println(newArr[i]);
        }
    }

    public void maxMinAvg(int [] newArr) {
        int max = newArr[0];
        int min = newArr[0];
        int sum = 0;
        double avg = 0;
            for (int i = 0; i < newArr.length; i++) { 
                if (newArr[i] > max) {
                    max = newArr[i];
                } else if (newArr[i] < min) {
                    min = newArr[i];
                } 
                sum += newArr[i];
            }
        avg =  sum / newArr.length;
        System.out.println("Max: " + max + " Min: " + min + " Avg: " + avg);
    }

    public void shiftArray(int[] array_nums) {
        if(array_nums.length > 1) {          
            int first = array_nums[0];
                  
        for (int i = 1; i < array_nums.length; i++)
            array_nums[i - 1] = array_nums[i];
                            
        array_nums[array_nums.length - 1] = first;

            System.out.println("New Array: " + Arrays.toString(array_nums)); 
        }
    }
}