package leetcode;

/**
 * Created by leon on 16/5/24.
 */

//Given a string S, find the longest palindromic substring in S. Y
// ou may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

//动态规划，思路比较复杂一些，但是实现代码会比较简短。基本思路是外层循环i从后往前扫，内层循环j从i当前字符扫到结尾处。
// 过程中使用的历史信息是从i+1到n之间的任意子串是否是回文已经被记录下来，所以不用重新判断，只需要比较一下头尾字符即可。
// 这种方法使用两层循环，时间复杂度是O(n^2)。而空间上因为需要记录任意子串是否为回文，需要O(n^2)的空间

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s){
        if(s == null || s.length()==0)
            return "";
        boolean[][] palin = new boolean[s.length()][s.length()];
        String res = "";
        int maxLen = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
            for(int j=i;j<s.length();j++)
            {
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || palin[i+1][j-1]))
                {
                    palin[i][j] = true;
                    if(maxLen<j-i+1)
                    {
                        maxLen=j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        String s = "abcdefgferfv";
        System.out.println(l.longestPalindrome(s));
    }
}
