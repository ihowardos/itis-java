package Strategy;

import Strategy.Algorithms.Algorithm;

/**
 * Created by Сергей on 02.03.2017.
 */
public class Sorting {
    private Algorithm algorithm;

    public Sorting(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public int[] sort(int[] array) {
        return algorithm.sort(array);
    }

    public int getMax() {
        return algorithm.getMax();
    }

    public int getMin() {
        return algorithm.getMin();
    }
}
