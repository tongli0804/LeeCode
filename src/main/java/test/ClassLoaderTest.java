package test;

/**
 * @author dylan.ll
 * @date 2019-11-03 12:36
 */
public class ClassLoaderTest {


    private static final String CLASS_NAME_1 = "test.Test";
    private static final String CLASS_NAME_2 = "test.Test2";

    public static void main(String[] args) throws Exception {

        testClassLoader(CLASS_NAME_1, CLASS_NAME_2);
        System.out.println("上面测试ClassLoader 下面测试Class.forName()");
        testClassForName(CLASS_NAME_1, CLASS_NAME_2);

    }

    private static void testClassLoader(String class1, String class2){
        Class<?> clazz1;
        Class<?> clazz2;
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            clazz1 = classLoader.loadClass(class1);
            clazz2 = classLoader.loadClass(class2);
            System.out.println("Class1: " + clazz1.getSimpleName() + ", Class2: " + clazz2.getSimpleName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void testClassForName(String class1, String class2){
        try {
            Class clazz1 = Class.forName(class1);
            Class clazz2 = Class.forName(class2);
            System.out.println("Class1: " + clazz1.getSimpleName() + ", Class2: " + clazz2.getSimpleName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}




class Test {
    static {
        System.out.println("静态代码块执行了...");
    }

}

 class Test2 {
    static {
        System.out.println("Test2 static code blocks is running !");
    }
}
