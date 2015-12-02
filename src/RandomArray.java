import java.util.HashMap;

public class RandomArray
{
    public static int missingNumber(int[] numbers) {
        HashMap<Integer, Integer> allNumbers = new HashMap<Integer, Integer>();
        for (int i = 1; i <= 100; i++) {
            allNumbers.put(i, 0);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (allNumbers.containsKey(numbers[i])) {
                allNumbers.put(numbers[i], allNumbers.get(numbers[i])+1);
            }
        }

        for (Integer num : allNumbers.keySet()) {
            if (allNumbers.get(num) == 0)
                return num;
        }

        //there is no missing number
        return -1;
    }

    public static void generateArray(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            if (i == num)
                continue;
            else
                a[i] = i+1;
        }
    }

    public static void main(String[] args)
    {
        int[] one = new int[100];
        int[] two = new int[100];
        int[] three = new int[100];

        generateArray(one, 60);
        generateArray(two, 43);
        generateArray(three, 100);

        System.out.println(missingNumber(one));
        System.out.println(missingNumber(two));
        System.out.println(missingNumber(three));
    }
}