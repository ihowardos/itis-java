package Strategy.Algorithms;

/**
 * Created by Сергей on 02.03.2017.
 */
public class BubbleSort implements Algorithm {
    private int min, max;
    @Override
    public int[] sort(int[] array) {
        int j;
        boolean flag = true;
        int temp;

        while ( flag )
        {
            flag= false;
            for( j=0; j < array.length - 1; j++ )
            {
                if ( array[j] < array[j+1] )
                {
                    temp = array[ j ];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
        }
        this.min = array[array.length - 1];
        this.max = array[0];
        return array;
    }

    @Override
    public int getMax() {
        return max;
    }

    @Override
    public int getMin() {
        return min;
    }
}
