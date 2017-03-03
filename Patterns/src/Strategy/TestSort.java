package Strategy;

import Strategy.Algorithms.Algorithm;
import Strategy.Algorithms.BubbleSort;
import Strategy.Algorithms.QuickSort;

/**
 * Created by Сергей on 02.03.2017.
 */

public class TestSort {
    public static void main(String[] args) {
        Algorithm bubble = new BubbleSort();
        Sorting sorting = new Sorting(bubble);

        int[] array = { 45, 15, 20, 3, 100, 4, 8, 1, 0 };
        //sorting.sort(array);
        //System.out.println(sorting.getMax());
        //System.out.println(sorting.getMin());

        sorting.setAlgorithm(new QuickSort());
        sorting.sort(array);
        System.out.println(sorting.getMax());
        System.out.println(sorting.getMin());
    }
}
