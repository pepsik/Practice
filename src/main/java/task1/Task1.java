package task1;

/**
 * The {@code Task1} class represents two int values x, y. This class is designed for swap values x and y where
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

    /**
     * foo
     */
    private int x; //value1 to swap
    private int y; //value2 to swap

    /**
     * Initializes a newly created Task1 object with two values x, y and checks it {@link Task1#checkValues()}
     *
     * @param x input x value
     * @param y input y value
     */
    public Task1(int x, int y) {
        this.x = x;
        this.y = y;
        checkValues();
    }

    /**
     * Swaps x and y values without any additional methods, parameters, arrays or collections
     */
    public void inverseXY() {
        x = x + y; //todo: not +
        y = x - y;
        x -= y;
    }

    /**
     * Validates the values x and y
     *
     * @throws ArithmeticException in cases ({@code x + y > Integer.MAX_VALUE}), ({@code x + y < Integer.MIN_VALUE})
     */
    private void checkValues() {
        int halfXY = x / 2 + y / 2; //todo: bigInt
        if (x < 0 && y < 0) {
            if (halfXY < Integer.MIN_VALUE / 2) {
                throw new ArithmeticException("Sum x + y cause integer overflow!");
            }
        } else if (x > 0 && y > 0) {                      //if x, y positive
            if (halfXY + 1 > Integer.MAX_VALUE / 2) {
                throw new ArithmeticException("Sum x + y cause integer overflow!");
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
