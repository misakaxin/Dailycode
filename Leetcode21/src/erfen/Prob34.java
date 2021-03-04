package erfen;

/**
 * @author gy2020092401
 */
public class Prob34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    //leftOrRight为true找左边界 false找右边界
    public static int  binarySearch(int[] nums, int target, boolean leftOrRight) {
        int left = 0, right = nums.length - 1;int res=-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target==nums[mid]){
                res=mid;
                //处理target == nums[mid]
                if (leftOrRight) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums={5,7,7,8,8,10};
        int target=8;
        System.out.println(binarySearch(nums,target,true));
        System.out.println(binarySearch(nums,target,false));
    }
}