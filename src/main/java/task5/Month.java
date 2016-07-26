package task5;

/**
 * Enum class represents a month. It consists 12 month of year and can determine month by index {@link Month#valueOf(int)}.
 */
enum Month {
    JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30),
    MAY(31), JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(30),
    OCTOBER(31), NOVEMBER(30), DECEMBER(31);

    private int days;

    /**
     * Initializes a newly created Enum object with real days count
     *
     * @param days actual days in month
     */
    Month(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
