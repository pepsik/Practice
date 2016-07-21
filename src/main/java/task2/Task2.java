package task2;

/**
 * The {@code Task2} class represents a simple house with number of floors, apartments, entrances.
 * It consist two int values floors, apartPerFloor (apartment per floor). The purpose of this class is to count
 * the number of entrance and floor using 3 input values: house floors count, apartments per floor count and number of apartment
 * which will seek. E.g. input data
 * <blockquote><pre>
 * floors = 9
 * apartPerFloor = 4
 * apartment = 72
 * </pre></blockquote>
 * will find apartment 72 and return
 * <blockquote><pre>
 * entrance = 2
 * floor = 9
 * </pre></blockquote>
 */
public class Task2 {
    private final int floors;
    private final int apartPerFloor;

    /**
     * Initializes a newly created Task2 object with two values: floors, apartmentsPerFloor and checks it {@link Task2#checkValues()}
     * @param floors             input floor value
     * @param apartmentsPerFloor input apartments per floor value
     */
    public Task2(int floors, int apartmentsPerFloor) {
        this.floors = floors;
        this.apartPerFloor = apartmentsPerFloor;
        checkValues();
    }

    /**
     * Checks values if they are negative then {@link IllegalArgumentException} will thrown
     * or if they multiply cause int overflow then {@link ArithmeticException} will thrown
     */
    private void checkValues() {
        if (floors < 1 || apartPerFloor < 1) {
            throw new IllegalArgumentException();
        }
        Math.multiplyExact(apartPerFloor, floors);
    }

    /**
     * Finds a floor number by given apartment number
     * @param apart input apartment value
     * @return floor number
     */
    public int getFloor(int apart) {
        int apartPerEntrance = apartPerFloor * floors;

        int i = apart % apartPerEntrance;//todo name somehow

        if (i == 0) {
            return floors;
        }

        if (i % apartPerFloor == 0) {
            return i / apartPerFloor;
        }

        return i / apartPerFloor + 1;
    }

    /**
     * Finds a entrances number by given apartment number
     * @param apart input apartment value
     * @return entrance number
     */
    public int getEntrance(int apart) {
        int apartPerEntrance = apartPerFloor * floors;

        if (apart % (apartPerEntrance) == 0) {//todo remove all brackets
            return apart / (apartPerEntrance);
        }
        return apart / (apartPerEntrance) + 1;
    }

}
