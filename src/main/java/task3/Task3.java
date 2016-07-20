package task3;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task3 {

    private int[] data;

    public Task3(int[] data) {
        this.data = data;
        checkValues();
    }

    public int getNOD() {
        int min = findMinOfData();
        int maxDivider = -1;
        // finding max divider
        for (int i = min; i > 0; i--) {
            //supposed it was found
            maxDivider = i;
            //check suppose
            for (int value : data) {
                if (value % i != 0) {
                    //if not divisible - skip
                    maxDivider = -1;
                    break;
                }
            }
            //check if found
            if (maxDivider != -1)
                break;
        }
        return maxDivider;
    }

    private void checkValues() {
        for (int value : data)
            if (value < 1)
                throw new IllegalArgumentException();
    }

    private int findMinOfData() {
        int min = Integer.MAX_VALUE;
        for (int value : data) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Task3 task = new Task3(new int[]{12, -60, 30, 24});
        System.out.println(task.getNOD());
    }
}
