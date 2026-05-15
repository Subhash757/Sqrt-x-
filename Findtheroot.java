package LeetCode;
import java.util.*;

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        long ans = 0;
        long l = 0;
        long h = x;

        while (l <= h) {
            long mid = l + (h - l) / 2;
            long sq = mid * mid;

            if (sq == x) {
                return (int) mid;
            } else if (sq < x) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return (int) ans;
    }
}

public class Findtheroot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int x = sc.nextInt();

        Solution sol = new Solution();       
        int result = sol.mySqrt(x);          

        System.out.println("Square root: " + result); 
    }
}