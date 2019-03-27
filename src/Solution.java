import java.io.*;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {
    public static String solution(String S) {
        int[] occurrences = new int[26];
        char[] ca = S.toCharArray();
        for (char ch: ca) {
            occurrences[(int)ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = occurrences[0]; // 0; // occurrences[0];

        for (int i = 1; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char)('a' + i);
                best_res  = occurrences[i];
            }
        }

        return null;//best_char.toString();
    }
    
    public static void main(String[] args) {
    	
    	solution("aazzahelzllolzaazza");
    }
}