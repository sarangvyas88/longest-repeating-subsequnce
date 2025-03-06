import java.util.*;
import java.io.*;

public class Solution {
    public static int longestRepeatingSubsequence(String st, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (st.charAt(i - 1) == st.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][n];
    }

    public static void main(String[] args) {
        String st = "aabb";
        int n = st.length();
        System.out.println(longestRepeatingSubsequence(st, n)); // Output: 2

        st = "aab";
        n = st.length();
        System.out.println(longestRepeatingSubsequence(st, n)); // Output: 1

        st = "abcabc";
        n = st.length();
        System.out.println(longestRepeatingSubsequence(st, n)); // Output: 3

        st = "aaa";
        n = st.length();
        System.out.println(longestRepeatingSubsequence(st, n)); // Output: 2
    }
}