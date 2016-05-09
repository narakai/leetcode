package leetcode;

import java.util.HashMap;

/**
 * Created by leon on 16/5/9.
 */

//Given a string, find the length of the longest substring without repeating characters.
//
//        Examples:
//
//        Given "abcabcbb", the answer is "abc", which the length is 3.

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxLen = 1;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), i);
                len++;
            } else {
                //i = 0,下个循环即为1了
                i = hashMap.get(s.charAt(i));
                maxLen = Math.max(maxLen, len);
                hashMap.clear();
                len = 0;
            }
        }
        return Math.max(maxLen, len);
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("abcdabc"));
    }
}
