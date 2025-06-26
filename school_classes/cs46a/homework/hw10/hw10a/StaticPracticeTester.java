import java.util.ArrayList;
/**
 * Tester for the static methods of StaticPractice
 * 
 * @author  Qi Yang
 * @version 2022-11-04
 */
public class StaticPracticeTester
{
    public static void main(String[] args)
    {
        final int MAX_SIZE = 1000;
        int[] numbers = new int[MAX_SIZE];
        
        numbers[0] = 9;
        numbers[1] = -5;
        numbers[2] = 8;
        numbers[3] = -7;
        numbers[4] = 0;
        numbers[5] = -15;
        numbers[6] = 1;
        numbers[7] = -100;
        numbers[8] = -15;
        numbers[9] = 6;

        // Testing method averageOfPositive() on arrays
        System.out.println("Average of Positive Elements: " + StaticPractice.averageOfPositive(numbers, 0));
        System.out.println("Expected: 0.0");
        System.out.println("Average of Positive Elements: " + StaticPractice.averageOfPositive(numbers, 1));
        System.out.println("Expected: 9.0");
        System.out.println("Average of Positive Elements: " + StaticPractice.averageOfPositive(numbers, 5));
        System.out.println("Expected: 8.5");
        System.out.println("Average of Positive Elements: " + StaticPractice.averageOfPositive(numbers, 10));
        System.out.println("Expected: 6.0");
        
        String[] strings = new String[MAX_SIZE];
        strings[0] = "dog";     
        strings[1] = "cat";
        strings[2] = "horse";
        strings[3] = "snake";
        strings[4] = "cat";
        strings[5] = "parrot";
        strings[6] = "pig";
        strings[7] = "cow";
        strings[8] = "horse";
        strings[9] = "cat";
        
        // Testing method targetCount() on arrays
        System.out.println("Count of Occurences: " + StaticPractice.targetCount(strings, 0, "cat"));
        System.out.println("Expected: 0");
        System.out.println("Count of Occurences: " + StaticPractice.targetCount(strings, 2, "cat"));
        System.out.println("Expected: 1");
        System.out.println("Count of Occurences: " + StaticPractice.targetCount(strings, 10, "cat"));
        System.out.println("Expected: 3");
        System.out.println("Count of Occurences: " + StaticPractice.targetCount(strings, 10, "cow"));
        System.out.println("Expected: 1");
        System.out.println("Count of Occurences: " + StaticPractice.targetCount(strings, 7, "cow"));
        System.out.println("Expected: 0");

        // Testing method averageOfPositive() on array lists
        ArrayList<Integer> list1 = new ArrayList<Integer>();

        System.out.println("Average of Positive Elements: " + StaticPractice.averageOfPositive(list1));
        System.out.println("Expected: 0.0");

        list1.add(-9);
        list1.add(-5);
        System.out.println("Average of Positive Elements: " + StaticPractice.averageOfPositive(list1));
        System.out.println("Expected: 0.0");
        
        list1.add(8);
        list1.add(-7);
        list1.add(6);        
        System.out.println("Average of Positive Elements: " + StaticPractice.averageOfPositive(list1));
        System.out.println("Expected: 7.0");

        // Testing method targetCount() on array lists
        ArrayList<String> strings1 = new ArrayList<String>();
        System.out.println("Count of Occurences: " + StaticPractice.targetCount(strings1, "cat"));
        System.out.println("Expected: 0");

        strings1.add("dog");
        strings1.add("horse");
        System.out.println("Count of Occurences: " + StaticPractice.targetCount(strings1, "cat"));
        System.out.println("Expected: 0");

        strings1.add("cat");
        strings1.add("snake");
        System.out.println("Count of Occurences: " + StaticPractice.targetCount(strings1, "cat"));
        System.out.println("Expected: 1");

        strings1.add("cat");
        strings1.add("parrot");
        strings1.add("pig");
        strings1.add("cow");
        strings1.add("horse");
        strings1.add("cat");
        System.out.println("Count of Occurences: " + StaticPractice.targetCount(strings1, "cat"));
        System.out.println("Expected: 3");
        System.out.println("Count of Occurences: " + StaticPractice.targetCount(strings1, "horse"));
        System.out.println("Expected: 2");
    }
}