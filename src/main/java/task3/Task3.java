package task3;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task3 {

    private int[] data;

    public Task3(int[] data) {
        this.data = data;
    }

    public int getNOD() {
        int minValueOfData = findMinValue();
        int maxDivider = -1;
        for (int i = minValueOfData; i > 0; i--) {
            maxDivider = i;
            for (int value : data) {
                if (value % i != 0) {
                    maxDivider = -1;
                    break;
                }
            }
            if (maxDivider != -1)
                break;
        }
        return maxDivider;
    }

    private int findMinValue() {
        int min = Integer.MAX_VALUE;
        for (int value : data) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Task3 task4 = new Task3(new int[]{12, 60, 30, 24});
        System.out.println(task4.getNOD());
    }
}
