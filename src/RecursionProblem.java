public class RecursionProblem
{

    public static void main(String[] args)
    {
        System.out.println(isEvenWord("abcdeffedcba"));
        System.out.println(isEvenWord("abcd"));
        System.out.println(isEvenWord("00006666"));
    }

    public static boolean isEvenWord(String word)
    {
        //base case
        if (word.length() == 0) {
            //is even
            return true;
        } else {
            //do recursive step
            int index = word.indexOf(word.charAt(0), 1);
            if (index == -1) {
                return false;
            }
            word = word.substring(1, index) + word.substring(index + 1, word.length());
            // don't leave print statements in the code
            System.out.println(word);
            return isEvenWord(word);
        }
    }
    
    // this is good clean code, I would test with more examples next time
}
