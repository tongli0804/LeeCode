package Leecode;

import java.util.Random;
import java.util.Scanner;

public class SimpleDotComTestDriver {

    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        //初始化战舰
        int[][] loctions = new int[7][7];
//        for (int i = 0 ;i<loctions.length;i++){
//            int x;
//             x =(int) (Math.random()*10);
//             loctions[i]=x;;
//        }
        for (int i = 0; i < 3; ) {
            if (getShip(loctions)) {
                i++;
            }
        }

        Scanner sc = new Scanner(System.in);
        dot.SetlocationCells(loctions);
        while (true) {

            String userguess = sc.nextLine();
            String result = dot.checkYourself(userguess);
            if (result.equals("kill")) {
                break;
            }
        }


    }
    //确定三个长方形位置

    private static boolean setLoc(int[][] loctions, int head_x, int head_y) {
        if (loctions[head_x][head_y] == 1) {
            return false;
        }
        loctions[head_x][head_y] = 1;
        return true;
    }

    private static boolean getShip(int[][] loctions) {
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            int head_x = r.nextInt(8);
            int head_y = r.nextInt(8);
            int dir = r.nextInt(4);
            if (!setLoc(loctions, head_x, head_y)) {
                return false;
            }
            //0-上   1-下   2-左   3-右
            if (dir == 0) {
                if (!setLoc(loctions, head_x, head_y + 1)) {
                    return false;
                }
                if (!setLoc(loctions, head_x, head_y + 2)) {
                    return false;
                }
            } else if (dir == 1) {
                if (!setLoc(loctions, head_x, head_y - 1)) {
                    return false;
                }
                if (!setLoc(loctions, head_x, head_y - 2)) {
                    return false;
                }
            } else if (dir == 2) {
                if (!setLoc(loctions, head_x - 1, head_y)) {
                    return false;
                }
                if (!setLoc(loctions, head_x - 2, head_y)) {
                    return false;
                }
            } else {
                if (!setLoc(loctions, head_x + 1, head_y)) {
                    return false;
                }
                if (!setLoc(loctions, head_x + 2, head_y)) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}




class SimpleDotCom{
    int[] locationCells;
    int numOfHits = 0;
    public void SetlocationCells(int[] locs){
        locationCells = locs;
    }
    public String checkYourself(String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        for(int cell : locationCells){
            if(guess == cell){
                result = "hint";
                numOfHits++;
                break;
            }
        }
        if(numOfHits == 1){
            result = "kill";
        }
        System.out.println(result);
        return result;
    }
}
