package task1;

import java.math.BigInteger;

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
     * value 1 to swap
     */
    private BigInteger x;
    /**
     * value 2 to swap
     */
    private BigInteger y;

    /**
     * Initializes a newly created Task1 object with two values x, y
     *
     * @param x input x value
     * @param y input y value
     */
    public Task1(BigInteger x, BigInteger y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Swaps x and y values without any additional methods, parameters, arrays or collections
     */
    public void inverseXY() {
        x = x.add(y);
        y = x.subtract(y);
        x = x.subtract(y);
    }

    public BigInteger getX() {
        return x;
    }

    public BigInteger getY() {
        return y;
    }
}
