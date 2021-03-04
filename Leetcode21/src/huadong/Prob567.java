package huadong;

import java.util.HashMap;

public class Prob567 {
    // 判断 s2 中是否存在 s1 的排列
   public static boolean checkInclusion(String s1, String s2) {
       HashMap<Character, Integer> need = new HashMap<>();
       HashMap<Character, Integer> window = new HashMap<>();
       for (char c : s1.toCharArray()){
           need.put(c, need.getOrDefault(c, 0) + 1);
       }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }

    public static void main(String[] args) {
        String s1="ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }
}
