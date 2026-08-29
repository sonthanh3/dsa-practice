public class Solution {
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int l, int r) {
        if (l < r) {
            reverse(s, l + 1, r - 1);
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        }
    }
}