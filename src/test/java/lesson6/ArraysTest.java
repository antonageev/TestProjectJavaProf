package lesson6;

import org.junit.Assert;
import org.junit.Test;



public class ArraysTest {
    @Test
    public void testGetArrayAfterLast4_1(){
        Assert.assertArrayEquals(new Integer[]{6, 7}, MainApp.getArrayAfterLastFour(1,2,3,4,5,6,4,6,7));
    }

    @Test
    public void testGetArrayAfterLast4_2(){
        Assert.assertArrayEquals(new Integer[]{}, MainApp.getArrayAfterLastFour(3,4,4));
    }

    @Test(expected = RuntimeException.class)
    public void testGetArrayAfterLast4_Except(){
        MainApp.getArrayAfterLastFour(1,2,3,5,6,6,7);
    }

    @Test
    public void testCheckArr4and1_1(){
        Assert.assertTrue(MainApp.checkArr4and1(1,1,4,4,1,4,1,4));
    }
    @Test
    public void testCheckArr4and1_2(){
        Assert.assertFalse(MainApp.checkArr4and1(1,1,4,4,1,4,3));
    }
    @Test
    public void testCheckArr4and1_3(){
        Assert.assertFalse(MainApp.checkArr4and1(1,1,1,1));
    }
    @Test
    public void testCheckArr4and1_4(){
        Assert.assertFalse(MainApp.checkArr4and1(4,4,4,4));
    }
    @Test
    public void testCheckArr4and1_5(){
        Assert.assertFalse(MainApp.checkArr4and1());
    }
}
