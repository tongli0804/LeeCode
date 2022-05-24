package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dylan.ll
 * @date 2022/3/21 22:52
 */
public class SortJumbled_2191_将杂乱无章的数字排序 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i], mapInt(mapping, nums[i]));
        }
        return Arrays.stream(nodes).sorted(Comparator.comparingInt(Node::getMap)).mapToInt(Node::getOrigin).toArray();

    }

    private int mapInt(int[] mapping, int origin) {
        String originStr = String.valueOf(origin);
        StringBuilder mapStr = new StringBuilder();
        for (int i = 0; i < originStr.length(); i++) {
            mapStr.append(mapping[originStr.charAt(i) - '0']);
        }
        return Integer.parseInt(mapStr.toString());
    }

    static class Node {
        int origin;
        int map;

        public Node(int origin, int map) {
            this.origin = origin;
            this.map = map;
        }

        public int getOrigin() {
            return origin;
        }

        public int getMap() {
            return map;
        }
    }

    public static void main(String[] args) {
         int[] mapping={8,9,4,0,2,1,3,5,7,6};
         int[] nums={991,338,38};
        System.out.println(JSON.toJSONString(new SortJumbled_2191_将杂乱无章的数字排序().sortJumbled(mapping,nums)));
    }
}
