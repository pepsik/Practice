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
    }

    public int getFloor(int apartment) {
        if (apartment % (apartmentsPerFloor * floors) == 0)
            return 9;
        if (apartment % (apartmentsPerFloor * floors) % apartmentsPerFloor == 0)
            return apartment % (apartmentsPerFloor * floors) / apartmentsPerFloor;
        return apartment % (apartmentsPerFloor * floors) / apartmentsPerFloor + 1;
    }

    public int getEntrance(int apartment) {
        if (apartment % (apartmentsPerFloor * floors) == 0)
            return apartment / (apartmentsPerFloor * floors);
        return apartment / (apartmentsPerFloor * floors) + 1;
    }

    public void print(int apartament) {
        System.out.println("Floor - " + getFloor(apartament));
        System.out.println("Entrance - " + getEntrance(apartament));
    }

    public static void main(String[] args) {
        Task2 task = new Task2(1, 1);

        for (int i = 1; i <20; i++) {
            System.out.println("------" + i + "-------");
            task.print(i);
        }
    }
}
