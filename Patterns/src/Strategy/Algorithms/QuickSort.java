package Strategy.Algorithms;

/**
 * Created by Сергей on 02.03.2017.
 */
public class QuickSort implements Algorithm {
        private int[] numbers;
        private int number;

        @Override
        public int[] sort(int[] values) {
            if (values == null || values.length==0){
                return null;
            }
            this.numbers = values;
            number = values.length;
            quickSort(0, number - 1);
            return numbers;
        }

        private void quickSort(int low, int high) {
            int i = low, j = high;
            int pivot = numbers[low + (high-low)/2];

            while (i <= j) {
                while (numbers[i] < pivot) {
                    i++;
                }
                while (numbers[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    exchange(i, j);
                    i++;
                    j--;
                }
            }
            if (low < j)
                quickSort(low, j);
            if (i < high)
                quickSort(i, high);
        }

        private void exchange(int i, int j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

    @Override
    public int getMax() {
        return numbers[number - 1];
    }

    @Override
    public int getMin() {
        return numbers[0];
    }
}
