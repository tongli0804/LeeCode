package Leecode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author dylan.ll
 * @date 2022/3/8 21:46
 */
public class Connect_117_填充每个节点的下一个右侧节点指针2 {

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node nextLevelPre=null;
        Node cur=root;
        Node head=root;

        while (head!=null || cur!=null){
            // nextLevelPre 为空，则是本层第一个，先重置head为null
            if(nextLevelPre==null){
                head=null;
            }
            //本层次最后一个，重置下一层pre 节点，重置 当前遍历节点到下一个head
            if(cur==null){
                nextLevelPre=null;
                cur=head;
                continue;
            }

            if(cur.left!=null){
                //下一层第一个，重置head 到这个，准备重建下一层链表，nextLevelPre 指向这个
                if(nextLevelPre==null){
                    head=cur.left;
                }else {
                    //非第一个，则构建链表指针
                    nextLevelPre.next=cur.left;
                }
                nextLevelPre=cur.left;

            }
            if(cur.right!=null){
                if(nextLevelPre==null){
                    head=cur.right;
                }else {
                    nextLevelPre.next=cur.right;
                }
                nextLevelPre=cur.right;
            }
            //遍历本层最后一个
            cur=cur.next;

        }

        return root;
    }

    public static void main(String[] args) {
        Node node7=new Node(7);
        Node node15=new Node(15);
        Node node20=new Node(15,node15,node7,null);
        Node node9=new Node(9);
        Node node3=new Node(3,node9,node20,null);
        new Connect_117_填充每个节点的下一个右侧节点指针2().connect(node3);
        return;
    }
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
