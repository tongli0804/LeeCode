package course.tongli;

import java.util.Map;
import java.util.Scanner;

/**
 * @author dylan.ll
 * @date 2022/1/2 18:15
 */
class Mouse extends Animal {
    public Mouse(String myName, int myId, String myFoods) {
        super(myName, myId);
        System.out.println("我是" + myName + " " + "我的身高" + myId + "" + "我正在吃" + myFoods);
    }

    public Mouse() {
        super();
    }
    @Override
    public void eat() {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        int id = s.nextInt();
        String foods = s.nextLine();
        System.out.println("我是" + name + " " + "我的id是" + id + "" + "我正在吃" + foods);
    }

    void eatTest(){
        this.eat();
        super.eat();
    }
}


class Test {
    public static void main(String[] args) {
        String mingzi = "猪儿虫";
        int shengao = 1;
        String food = "黄色的东西";
        Mouse m = new Mouse(mingzi,shengao,food);
        m.eatTest();


    }

}

