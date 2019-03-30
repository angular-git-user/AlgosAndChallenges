
/*
Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.
*/
public class CheckPermutation {

    private static int[] array;

    public static int getFibonacci(int fact) {

        if (fact <= 1) {
            array[fact] = fact;
            return fact;
        }

        int fact1, fact2;
        if (array[fact - 1] == 0) {
            fact1 = getFibonacci(fact - 1);
        } else {
            fact1 = array[fact - 1];
        }
        if (array[fact - 2] == 0) {
            fact2 = getFibonacci(fact - 2);
        } else {
            fact2 = array[fact - 2];
        }
        int sum = fact1 + fact2;
        array[fact] = sum;
        System.out.print(sum + " ");
        return sum;
    }

    public static int getFibonacciRecursive(int fact) {

        if (fact <= 1) {
            return fact;
        }
        return getFibonacciRecursive(fact - 1) + getFibonacciRecursive(fact - 2);
    }

    public static void main(String[] args) {
        array = new int[9];
        getFibonacci(8);

        System.out.println("");
        for (int i = 0; i < 9; i++) {
            if (i == 0 || i == 1)
                System.out.print(i + " ");
            else
                System.out.print(getFibonacciRecursive(i) + " ");
        }
    }
}
