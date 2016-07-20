package task2;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task2 {
    private final int floors;
    private final int apartmentsPerFloor;

    public Task2(int floors, int apartmentsPerFloor) {
        this.floors = floors;
        this.apartmentsPerFloor = apartmentsPerFloor;
        checkValues();
    }

    private void checkValues() {
        if (floors < 1 || apartmentsPerFloor < 1)
            throw new IllegalArgumentException();
        Math.multiplyExact(apartmentsPerFloor, floors);
    }

    public int getFloor(int apartment) {
        if (apartment % (apartmentsPerFloor * floors) == 0)
            return floors;
        if (apartment % (apartmentsPerFloor * floors) % apartmentsPerFloor == 0)
            return apartment % (apartmentsPerFloor * floors) / apartmentsPerFloor;
        return apartment % (apartmentsPerFloor * floors) / apartmentsPerFloor + 1;
    }

    public int getEntrance(int apartment) {
        if (apartment % (apartmentsPerFloor * floors) == 0)
            return apartment / (apartmentsPerFloor * floors);
        return apartment / (apartmentsPerFloor * floors) + 1;
    }

    public void findApartment(int apartment) {
        System.out.println("Floor - " + getFloor(apartment));
        System.out.println("Entrance - " + getEntrance(apartment));
    }

    public static void main(String[] args) {
        Task2 task = new Task2(2, 2);

        for (int i = 1; i < 20; i++) {
            System.out.println("------" + i + "-------");
            task.findApartment(i);
        }
    }
}
