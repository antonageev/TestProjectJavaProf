package lesson7;

public class TestedClass {

    @BeforeSuite
    public static void beforeS(){
        System.out.println("Method before");
    }

    @Test(priority = 10)
    public static void method1(){
        System.out.println("Method number 1");
    }

    @Test(priority = 9)
    public static void method2(){
        System.out.println("Method number 2");
    }

    @Test(priority = 3)
    public static void method3(){
        System.out.println("Method number 3");
    }

    @Test(priority = 7)
    public static void method4(){
        System.out.println("Method number 4");
    }

    @Test(priority = 6)
    public static void method5(){
        System.out.println("Method number 5");
    }

    @Test
    public static void method6(){
        System.out.println("Method number 6");
    }

    @AfterSuite
    public static void afterS(){
        System.out.println("Method after");
    }

}
