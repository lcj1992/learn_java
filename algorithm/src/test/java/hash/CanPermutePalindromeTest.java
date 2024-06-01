package hash;

import org.junit.Test;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/palindrome-permutation/">...</a>
 *
 * @author foolchid
 * @date 2024/5/28
 **/
public class CanPermutePalindromeTest {


    @Test
    public void test() {
        boolean res = canPermutePalindrome("code");
        System.out.println(res);
    }

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            dic.put(s.charAt(i), dic.getOrDefault(s.charAt(i), 0) + 1);
        }
        int odd = 0;
        for (int val : dic.values()) {
            if (val % 2 == 1) {
                if (++odd > 1) return false;
            }
        }
        return true;
    }
}