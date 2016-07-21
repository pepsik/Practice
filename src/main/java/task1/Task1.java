package task1;

import java.util.Scanner;

/**
 * The {@code Task1} class represents two int values x, y. This class is designed for swap values x and y between themselves where
 * x will get y value and y will get x value without any additional methods, parameters, arrays or collections.
 * E.g. <blockquote><pre>
 * x = 5
 * y = 12
 * </pre></blockquote>
 * After using {@link Task1#inverseXY()} there will be
 * <blockquote><pre>
 * x = 12
 * y = 5
 * </pre></blockquote>
 */
public class Task1 {
    private int x;
    private int y;

    /**
     * Initializes a newly created Task1 object with two values x, y and checks it {@link Task1#checkValues()}
     * @param x input x value
     * @param y input y value
     */
    public Task1(int x, int y) {
        this.x = x;
        this.y = y;
        checkValues();
    }

    /**
     * Validates the values x and y
     *
     * @throws ArithmeticException in case {@code x + y <= Integer.MAX_VALUE}
     */
    private void checkValues() {
 //todo: validate normally
        Math.addExact(Math.abs(x), Math.abs(y));
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Swaps x and y values without any additional methods, parameters, arrays or collections
     */
    public void inverseXY() {
        x = x + y;
        y = x - y;
        x -= y;
    }

    public void print() {
        System.out.println("Result x - " + x);
        System.out.println("Result y - " + y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number x - ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter number y - ");
        int y = Integer.parseInt(scanner.nextLine());
        Task1 task = new Task1(x, y);
        task.inverseXY();
        task.print();
    }
}
