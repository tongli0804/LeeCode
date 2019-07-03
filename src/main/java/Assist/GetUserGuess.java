package Assist;


import java.util.Scanner;

public class GetUserGuess {
    public static void getUserGuess(){
        Scanner user = new Scanner(System.in);
        int getuserGuess = user.nextInt();
        //double  getuserError = user.nextDouble();
        System.out.println("客官您猜是几呢：");
            if (getuserGuess == 0){
                System.out.println("请输入1-1000的整数哦");
            }else if(getuserGuess != (int)user.nextInt()){
                System.out.println("请输入整数");

        }

    }

    public static void main(String[] args) {
        getUserGuess();
    }
}
