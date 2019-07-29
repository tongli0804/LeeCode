package Leecode;

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
        for (int i=0;i<3;){
           if(getShip(loctions)){
            i++;
           }
        }

        Scanner  sc = new Scanner(System.in);
        dot.SetlocationCells(loctions);
        while (true){

        String userguess = sc.nextLine();
        String result = dot.checkYourself(userguess);
        if(result.equals("kill")){
        break;
        }
        }


    }
private static boolean setLoc(int[][] loctions,int head_h,int head_s){
         if(loctions[head_h][head_s]==1){
             return false;
         }
    loctions[head_h][head_s]=1;
return true;
}
    private static boolean getShip(int[][] loctions) {
        int head_h =(int) (Math.random()*5);
        int head_s =(int) (Math.random()*5);
        int dir =(int) (Math.random()*2);
        if(!setLoc(loctions,head_h,head_s)){
            return false;
        }
        if(dir==0){
            if(!setLoc(loctions,head_h+1,head_s)){
                return false;
            }
            if(!setLoc(loctions,head_h+2,head_s)){
                return false;
            }
        }else {
            if(!setLoc(loctions,head_h,head_s+1)){
                return false;
            }
            if(!setLoc(loctions,head_h,head_s+2)){
                return false;
            }
        }
    return true;
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
