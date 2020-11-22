import java.util.Arrays;

public class Leetcode242_IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] letters1 = s.toCharArray();
        char[] letters2 = t.toCharArray();
        Arrays.sort(letters1);
        Arrays.sort(letters2);
        return Arrays.equals(letters1, letters2);
    }


    public static void main(String[] args) {
        Leetcode242_IsAnagram obj = new Leetcode242_IsAnagram();
        System.out.println(obj.isAnagram("level", "lleev"));
    }
}
