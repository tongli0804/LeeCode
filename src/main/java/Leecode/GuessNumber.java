package Leecode;

import Assist.GetUserGuess;

import java.util.Scanner;


public class GuessNumber {
    /*
     * > 需要的功能:
     * >1.随机生成一个1~1000之间的整数
     * >2.用户每猜测一次，控制台提示大了，小了，对了
     * >3.若猜对，宣布游戏结束，并询问用户是否继续开始新游戏
     * >4.用户不论猜对与否，输入0都开始新游戏
     */
    static String guessTrue = "猜对啦！";
    static String guessSmall = "猜小啦~";
    static String guessBig = "猜大了~";
    static String onemoreGame = "行嘞~这就开始";
    static String removeGame = "拜拜啦~";

    public static void main(String[] args){
        Start();//开始游戏
        ifonemoreGame();//是否开启下一局游戏

    }
    //开始游戏
    private static void Start(){
        System.out.println("让我们开始吧！");

    }
    //获取随机数
    private static int getrandom(){
        int result = (int)(Math.random()*1000+1);
        return result;
    }
    private static  void scanner(){
        Scanner cn = new Scanner(System.in);
        String cin = cn.nextLine();
    }
    //判断是否再来一局，yes 或 no

    private static void ifonemoreGame(){
        Scanner cn = new Scanner(System.in);
        String cin = cn.nextLine();
        if(cin == "yes") {
            System.out.println(onemoreGame);
            Start();
        }else if(cin == "no"){
            System.out.println(removeGame);
        }else {
            System.out.println("请输入yes或no");
            scanner();
        }

    }
    //用户输入值与random对比
    private static void MatchResult(int result,int GetUserGuess.)

}
