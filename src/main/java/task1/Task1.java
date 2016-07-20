package task1;

import java.util.Scanner;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task1 {
    private int x;
    private int y;

    public Task1(int x, int y) {
        this.x = x;
        this.y = y;
        checkValues();
    }

    private void checkValues() {
        Math.addExact(Math.abs(x), Math.abs(y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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
