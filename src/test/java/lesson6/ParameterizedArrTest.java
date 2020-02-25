package lesson6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedArrTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1,4,1,1,4,1,4}, true},
                {new Integer[]{1,4,1,1,4,1,4,3}, false},
                {new Integer[]{1,1,1,1,1,1}, false}
        });
    }

    private Integer[] a;
    private boolean b;

    public ParameterizedArrTest(Integer[] a, boolean b) {
        this.a = a;
        this.b = b;
    }

    @Test
    public void parameterArrTest(){
        Assert.assertEquals(b, MainApp.checkArr4and1(a));
    }
}
