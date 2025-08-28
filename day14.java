import java.util.*;

class Solution {
    
    private int atMostKDistinct(String s, int k) {
        if (k == 0)
            return 0; // edge case
        int left = 0, res = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window if too many distinct characters
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            
            res += (right - left + 1);
        }
        return res;
    }

    
    public int substrCount(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.substrCount("pqpqs", 2)); // 7
        System.out.println(sol.substrCount("aabacbebebe", 3)); // 10
        System.out.println(sol.substrCount("a", 1)); // 1
        System.out.println(sol.substrCount("abc", 3)); // 1
        System.out.println(sol.substrCount("abc", 2)); // 2
        System.out.println(sol.substrCount("aaaa", 1)); // 10
    }
}
