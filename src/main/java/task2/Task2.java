package task2;

import static java.lang.Integer.MAX_VALUE;

/**
 * The {@code Task2} class represents a simple house with numbers: house floors, apartments per floor, entrances.
 * <p>The purpose of this class is to count numbers of entrance and floor using 3 input values:
 * floors, apartments per floor and apartment to find.
 * <p>E.g. input data
 * <blockquote><pre>
 * floors = 9
 * apartmentsPerFloor = 4
 * apartment = 72
 * </pre></blockquote>
 * will find apartment 72 and return
 * <blockquote><pre>
 * entrance = 2
 * floor = 9
 * </pre></blockquote>
 */
public class Task2 {
    /**
     * floors in house
     */
    private final int floors;

    /**
     * apartments per floor
     */
    private final int apartmentsPerFloor;

    /**
     * Initializes a newly created Task2 object with two values: floors, apartmentsPerFloor and validates {@link Task2#checkValues()}
     *
     * @param floors             input floor value
     * @param apartmentsPerFloor input apartments per floor value
     */
    public Task2(int floors, int apartmentsPerFloor) {
        this.floors = floors;
        this.apartmentsPerFloor = apartmentsPerFloor;
        checkValues();
    }

    /**
     * Finds a floor number by given apartment number
     *
     * @param inputApartment input apartment number
     * @return floor number
     */
    public int getFloor(int inputApartment) {
        int apartmentsPerEntrance = apartmentsPerFloor * floors; // number of apartments per entrance
        int apartmentsLeftInEntrance = inputApartment % apartmentsPerEntrance;  //apartments left in entrance where is target apartment
        int targetFloor = apartmentsLeftInEntrance / apartmentsPerFloor;

        if (apartmentsLeftInEntrance == 0) {    //if target floor is the last in entrance
            return floors;
        }

        if (apartmentsLeftInEntrance % apartmentsPerFloor == 0) {  //if target apartment is last on floor
            return targetFloor;
        }

        return targetFloor + 1; // in other cases add 1 to floor count
        // e.g. apartmentsLeftInEntrance = 4, apartmentsPerFloor = 5, return floor = 0 + 1
    }

    /**
     * Finds a entrances number by given apartment number
     *
     * @param inputApartment input apartment number
     * @return entrance number
     */
    public int getEntrance(int inputApartment) {
        int apartmentsPerEntrance = apartmentsPerFloor * floors; // all apartments per entrance
        int targetEntrance = inputApartment / apartmentsPerEntrance;  //finds target entrance

        if (inputApartment % apartmentsPerEntrance == 0) {     //if target apartment last in entrance
            return targetEntrance;                            //e.g. (apartmentsPerEntrance = 25, inputApartment = 25, targetEntrance = 1)

        }
        return targetEntrance + 1; //if target apartment not last in entrance then add 1 to entrance count
        //e.g. (apartmentsPerEntrance = 25, inputApartment = 26, targetEntrance = 26/25 + 1 = 1)
    }

    /**
     * Validates the values floors and apartmentsPerFloor
     *
     * @throws IllegalArgumentException in case ({@code apartmentsPerFloor < 1 or floors < 1})
     * @throws ArithmeticException      in case ({@code apartmentsPerFloor * floors > Integer.MAX_VALUE})
     */
    private void checkValues() {
        if (floors < 1) {
            throw new IllegalArgumentException("Expected floors > 0, got " + floors);
        }
        if (apartmentsPerFloor < 1) {
            throw new IllegalArgumentException("Expected apartments per floor > 0, got " + apartmentsPerFloor);
        }
        if (floors > MAX_VALUE / apartmentsPerFloor) {
            throw new ArithmeticException("Values are too big! " +
                    "floors=" + floors + " apartmentsPerFloor=" + apartmentsPerFloor);
        }
    }
}
