package task2;

import static java.lang.Integer.MAX_VALUE;

/**
 * The {@code Task2} class represents a simple house with numbers: house floors, apartments per floor, entrances and apartment number.
 * <p>The purpose of this class is to count numbers of entrance and floor using 3 input values:
 * floors, apartments per floor and apartment to find.
 * <p>E.g. input data
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
    private final int floors;           // input value - floors in house
    private final int apartPerFloor;    //input value - apartment per floor

    /**
     * Initializes a newly created Task2 object with two values: floors, apartmentsPerFloor and validates {@link Task2#checkValues()}
     *
     * @param floors             input floor value
     * @param apartmentsPerFloor input apartments per floor value
     */
    public Task2(int floors, int apartmentsPerFloor) {
        this.floors = floors;
        this.apartPerFloor = apartmentsPerFloor;
        checkValues();
    }

    /**
     * Finds a floor number by given apartment number
     *
     * @param apart input apartment value
     * @return floor number
     */
    public int getFloor(int apart) {
        int ape = apartPerFloor * floors; // all Apartments Per Entrance
        int leftAparts = apart % ape;        //apartments leftAparts in entrance where is searching apartment

        if (leftAparts == 0) {    //found last floor (ape = 36, need apart = 36, leftAparts = 0 then it on the last floor)
            return floors;
        }

        if (leftAparts % apartPerFloor == 0) {  //found last apartment on floor
            return leftAparts / apartPerFloor; //todo refact
        }

        return leftAparts / apartPerFloor + 1; // floors starts with 0, then add + 1 (leftAparts = 4, apartPerFloor = 5, return 0 + 1)
    }

    /**
     * Finds a entrances number by given apartment number
     *
     * @param apart input apartment value
     * @return entrance number
     */
    public int getEntrance(int apart) {
        int ape = apartPerFloor * floors; // all Apartments Per Entrance

        if (apart % ape == 0) {      //numbers of apartments multiples of ape (ape = 36, target apart=36, return 36/36=1)
            return apart / ape; //todo refact
        }
        return apart / ape + 1; //in other cause add 1 (ape=36, target apart=37, 37/36 + 1 = 2 entrance)
    }

    /**
     * Validates the values floors and apartPerFloor
     *
     * @throws IllegalArgumentException in case ({@code apartPerFloor < 1 or floors < 1})
     * @throws ArithmeticException      in case ({@code apartPerFloor * floors > Integer.MAX_VALUE})
     */
    private void checkValues() {
        if (floors < 1 || apartPerFloor < 1) {
            throw new IllegalArgumentException("Floors and apartPerFloor must > 0");
        }
        if (MAX_VALUE / apartPerFloor < floors) {
            throw new ArithmeticException("Floors and apartPerFloor cause integer overflow! (floors * apartPerFloor)");
        }
    }
}
