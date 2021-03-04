package huadong;

import java.util.HashMap;

/**
 * @author misakaxin
 */
public class Prob76 {
        public static String minWindow(String s, String t) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c :  t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            int valid = 0;
            // 记录最小覆盖字串的起始索引及长度
            int start = 0, len = Integer.MAX_VALUE;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 判断取出的字符是否在字串中
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c,0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                // 判断是否需要收缩（已经找到合适的覆盖串）
                while (valid == need.size()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }

                    char d = s.charAt(left);
                    left++;
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                    }

                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
        }


    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow(s,t));
    }


}
