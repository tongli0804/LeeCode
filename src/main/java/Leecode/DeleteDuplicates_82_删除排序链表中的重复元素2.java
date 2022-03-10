package Leecode;

/**
 * @author dylan.ll
 * @date 2022/3/4 23:05
 */
public class DeleteDuplicates_82_删除排序链表中的重复元素2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode();
        preHead.next = head;
        preHead.val=0;

        ListNode preNode = preHead;
        ListNode curNode = head;
        int deleteVal = Integer.MIN_VALUE;
        while (curNode.next != null) {

            if (curNode.val == curNode.next.val) {
                deleteVal = curNode.val;
                preNode.next = curNode.next;
                curNode = preNode.next;
            } else if (deleteVal == curNode.val) {
                preNode.next = curNode.next;
                curNode = preNode.next;
            } else {
                preNode = preNode.next;
                curNode = curNode.next;
            }
        }
        if(curNode.val==deleteVal){
            preNode.next=null;
        }

        return preHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,3,4,4,5};
        ListNode head=new ListNode(nums[0]);
        ListNode pre=head;
        for (int i=1;i<nums.length;i++){
            ListNode cur=new ListNode(nums[i]);
            pre.next=cur;
            pre=cur;
        }

        ListNode cur=head;
        while (cur!=null){
            System.out.print(cur.val+",");
            cur=cur.next;
        }
        System.out.println();

        cur=new DeleteDuplicates_82_删除排序链表中的重复元素2().deleteDuplicates(head);
        while (cur!=null){
            System.out.print(cur.val+",");
            cur=cur.next;
        }
        System.out.println();
    }
}


