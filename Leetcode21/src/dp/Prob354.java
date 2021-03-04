package dp;

import java.util.Arrays;



/**
 * @author misakaxin
 */
public class Prob354 {
    public static int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        //宽度升序排序，如果宽度一样，则按高度降序排序
        Arrays.sort(envelopes, (o1, o2) -> o1[0]==o2[0] ?
                o2[1]-o1[1]:o1[0]-o2[0]);

        //对高度数组寻找LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    private static int lengthOfLIS(int[] nums) {
        int [] top = new int[nums.length];
        //排队初始化为0
        int piles = 0;
        /*
          搜索左侧边界的二分搜索
         */
        for (int poker : nums) {
            // 要处理的扑克牌
            /*
              搜索左侧边界的二分搜索
             */
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            //没找到合适的牌堆，新建一堆
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }


    public static void main(String[] args) {
        int [][] res= new int[][]{{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(res));
    }
}
