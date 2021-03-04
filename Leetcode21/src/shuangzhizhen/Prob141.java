package shuangzhizhen;

public class Prob141 {
    static boolean hasCycle(ListNode head) {
        ListNode fast,slow;
        fast=slow=head;
        while(fast !=null &&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }
}
