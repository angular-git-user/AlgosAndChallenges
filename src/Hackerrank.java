import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

class ListComparator<String extends Comparable<String>> implements Comparator<List<String>> {

    @Override
    public int compare(List<String> o1, List<String> o2) {
        // int c = o1.get(0).compareTo(o2.get(0));
        if (o1.get(Hackerrank.sortColumn) == o2.get(Hackerrank.sortColumn)) {
            return 0;
        }
        if (o1.get(Hackerrank.sortColumn) == null) {
            return -1;
        }
        if (o2.get(Hackerrank.sortColumn) == null) {
            return 1;
        }
        return (o1.get(Hackerrank.sortColumn).compareTo(o2.get(Hackerrank.sortColumn))) * Hackerrank.sortOrder;
    }

}

public class Hackerrank {
    static int[] a = new int[] { 9, 1, 4, 9, 0, 4, 8, 9, 0, 1 };

    public static int sortColumn = 1;
    public static int sortOrder = 1;

    public static void main(String args[]) {

        // Arrays.sort(a, 0, 5);
        // int count = makeAnagram("showman", "woman");
        // System.out.println(Arrays.toString(solution(a)));
        List<List<String>> list = new ArrayList<>();

        // p4 1 2
        // p2 2 1
        List<String> l1 = new ArrayList<>();
        l1.add("p5");
        l1.add("1");
        l1.add("2");

        List<String> l2 = new ArrayList<>();
        l2.add("p1");
        l2.add("3");
        l2.add("1");

        List<String> l3 = new ArrayList<>();
        l3.add("p3");
        l3.add("2");
        l3.add("8");

        list.add(l1);
        list.add(l2);
        list.add(l3);

        Collections.sort(list, new ListComparator<>());
        System.out.println("");

        int totalItemsCount = 20;
        int numberOfItemsPerPage = 5;
        int page = 0;

        int numberOfPages = (int) Math.floor((totalItemsCount + numberOfItemsPerPage - 1) / numberOfItemsPerPage);
        int start = (page * numberOfItemsPerPage) - (numberOfItemsPerPage - 1);
        int end = Math.min(start + numberOfItemsPerPage - 1, totalItemsCount);
        System.out.println("");
    }

    public static int finalInstances(int instances, List<Integer> averageUtil) {

        boolean actionTaken = false;
        int upperLimit = 60;
        int lowerLimit = 25;
        System.out.println(instances);
        for (int i = 0; i < averageUtil.size(); i++) {

            int val = averageUtil.get(i);

            if (val > upperLimit) {

                instances = instances * 2;
                System.out.println(instances);
                // actionTaken = true;
                i = i + 10;
            } else if (val < lowerLimit && instances > 1) {

                instances = (int) Math.ceil(instances / 2.0);
                // actionTaken = true;
                i = i + 10;
                System.out.println(instances);
            }
        }
        System.out.println(instances);
        return instances;
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