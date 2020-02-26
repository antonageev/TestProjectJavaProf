package lesson7;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestLauncher{

    public static void main(String[] args) {
        start(TestedClass.class);
    }

    public static void start(Class testClass){
        Method[] methods = testClass.getDeclaredMethods();
        // Блок проверок на единственность @BeforeSuite и @AfterSuite и отсутствие приоритета @Test вне диапазона [1-10]
        int methodBeforeCounter = 0;
        int methodAfterCounter = 0;
        Method methodToInvokeBefore = null;
        Method methodToInvokeAfter = null;
        for (Method m : methods){
            if (m.isAnnotationPresent(BeforeSuite.class)){
                methodBeforeCounter++;
                methodToInvokeBefore = m;
            }
            if (m.isAnnotationPresent(AfterSuite.class)){
                methodAfterCounter++;
                methodToInvokeAfter = m;
            }
            if (m.isAnnotationPresent(Test.class)) {
                if (m.getAnnotation(Test.class).priority() < 1 || m.getAnnotation(Test.class).priority() > 10) {
                    throw new RuntimeException("Приоритет аннотации @Test вне диапазона от 1 до 10");
                }
            }
        }
        if (methodBeforeCounter > 1 || methodAfterCounter > 1){
            throw new RuntimeException("Более одной аннотации BeforeSuite или AfterSuite");
        }

        // Блок запуска тестов по порядку

        try {
            if (methodToInvokeBefore != null) methodToInvokeBefore.invoke(testClass);

            for (int i = 10; i > 0; i--){
                for (Method m : methods){
                    if (m.isAnnotationPresent(Test.class) && m.getAnnotation(Test.class).priority() == i){
                        m.invoke(testClass);
                    }
                }
            }

            if (methodToInvokeAfter != null) methodToInvokeAfter.invoke(testClass);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
