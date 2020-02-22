package lesson6;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

    }

    static Integer[] getArrayAfterLastFour(Integer... inputArr){
        List<Integer> inputList = Arrays.asList(inputArr);
        int lastIndexOfFour = inputList.lastIndexOf(4); // проще найти индекс последней 4-ки в листе, чтобы не ходить по массиву

        if (lastIndexOfFour == -1) throw new RuntimeException();

        return Arrays.copyOfRange(inputArr, lastIndexOfFour+1, inputArr.length);
    }

    static boolean checkArr4and1(Integer... inputArr){
        boolean check4 = false;
        boolean check1 = false;
        for (int i : inputArr) {
            if (!(i==1 || i==4)) return false;
            if (i == 1) check1 = true;
            if (i == 4) check4 = true;
        }
        return (check1 && check4);
    }
}
