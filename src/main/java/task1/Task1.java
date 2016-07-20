package task1;

import java.util.Scanner;

/**
 * Created by Berezovyi Aleksandr on 7/18/2016.
 */
public class Task1 {
    private int x;
    private int y;

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void inverseXY() {
        Math.addExact(Math.abs(x), Math.abs(y));
        x = x + y;
        y = x - y;
        x -= y;
    }

    public void print() {
        System.out.println("Result x - " + x);
        System.out.println("Result y - " + y);
    }

    public static void main(String[] args) {
        Task1 task = new Task1();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number x - ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter number y - ");
        int y = Integer.parseInt(scanner.nextLine());
        task.setXY(x, y);
        task.inverseXY();
        task.print();
    }
}
