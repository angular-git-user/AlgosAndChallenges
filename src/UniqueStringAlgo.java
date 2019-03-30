
/**
 * Is Unique: Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures? Assuming
 * alphabets only
 */
public class UniqueStringAlgo {

    public static boolean isUique(String str) {

        int check = 0;

        for (int i = 0; i < str.length(); i++) {
            int ch = (int) (str.charAt(i) - 'a');
            int temp = check & (1 << ch);

            if (temp != 0) {
                System.out.println("Not unique");
                return false;
            }
            check = check | (1 << ch);
        }
        System.out.println("Unique String");
        return true;
    }

    public static void main(String args[]) {
        System.out.println(isUique("abcda"));
    }
}