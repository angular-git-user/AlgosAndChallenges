import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class Hackerrank {
    static int[] a = new int[] { 2, 8, 8, 11, 13, 13, 16 };

    public static void main(String args[]) {

        Arrays.sort(a, 0, 5);
        // int count = makeAnagram("showman", "woman");
        System.out.println(isValid("aaaaabc"));
    }

    public static int binSearch(int[] a, int search, int low, int high) {

        if (low == high)
            return low;

        int mid = (low + high) / 2;

        if (low < high) {
            if (a[mid] < search) {
                // if ((mid + 1) == high)
                // return high;
                // else
                return binSearch(a, search, mid + 1, high);
            } else if (a[mid] > search) {

                // if ((mid - 1) == low)
                // return low;
                // else
                return binSearch(a, search, low, mid);
            } else {
                return mid;
            }
        } else {
            return mid;
        }
    }

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer value = map.get(s.charAt(i));
            if (value == null) {
                value = 1;
            } else {
                value++;
            }

            map.put(s.charAt(i), value);
        }

        Set<Integer> set = new HashSet<>();
        int min = -1;
        int max = -1;
        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            set.add(value);

            if (min == -1 && max == -1) {
                min = value;
                max = value;
            } else {
                if (value < min)
                    min = value;
                else if (value > max)
                    max = value;
            }

        }

        if (!(min == 1 || max == 1) && max - min > 1)
            return "NO";

        if (set.size() > 2)
            return "NO";
        else if (set.size() == 1)
            return "YES";
        else {
            int count1 = 0;
            int count2 = 0;

            for (Character key : map.keySet()) {
                Integer value = map.get(key);

                if (value == max) {
                    count1++;
                } else {
                    count2++;
                }
            }
            int minOccur = 0;
            if (count1 < count2) {
                minOccur = count1;
            } else {
                minOccur = count2;
            }
            if (minOccur > 1)
                return "NO";
            else
                return "YES";
        }
    }

    static int alternatingCharacters(String s) {
        int count = 0;
        char prev = 'z';
        for (int i = 0; i < s.length(); i++) {

            if (prev - s.charAt(i) == 0) {
                count++;
            }
            prev = s.charAt(i);
        }
        return count;
    }

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            Integer value = map.get(a.charAt(i));
            if (value == null)
                value = 1;
            else
                value++;
            map.put(a.charAt(i), value);
        }

        int count = 0;
        for (int i = 0; i < b.length(); i++) {
            Integer value = map.get(b.charAt(i));
            if (value == null || value == 0)
                count++;
            else {
                value--;
                map.put(b.charAt(i), value);
            }
        }

        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            count = count + value;
        }
        return count;
    }
}