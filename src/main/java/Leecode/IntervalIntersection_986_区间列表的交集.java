package Leecode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dylan.ll
 * @date 2022/3/5 11:35
 */
public class IntervalIntersection_986_区间列表的交集 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstIndex = 0;
        int secIndex = 0;
        List<int[]> res = new ArrayList<>();
        while (firstIndex < firstList.length && secIndex < secondList.length) {

            //不重叠情况
            if (firstList[firstIndex][1] < secondList[secIndex][0]) {
                firstIndex++;
            } else if (secondList[secIndex][1] < firstList[firstIndex][0]) {
                secIndex++;
            }else {
                //  重叠情况
                int[] intersection = new int[2];
                intersection[0] = Math.max(firstList[firstIndex][0], secondList[secIndex][0]);
                intersection[1] = Math.min(firstList[firstIndex][1], secondList[secIndex][1]);
                if( firstList[firstIndex][1]< secondList[secIndex][1]){
                    firstIndex++;
                }
                else if(firstList[firstIndex][1]> secondList[secIndex][1] ){
                    secIndex++;
                }else {
                    firstIndex++;
                    secIndex++;
                }

                res.add(intersection);
            }

        }

        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] firstList={{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList={{1,5},{8,12},{15,24},{25,26}};
        System.out.println(JSON.toJSONString(new IntervalIntersection_986_区间列表的交集().intervalIntersection(firstList,secondList)));
    }
}
