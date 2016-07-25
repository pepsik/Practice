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

    /**
     * Return real month index (e.g. JANUARY=1, DECEMBER=12)
     *
     * @return month index
     */
    public int index() {
        return this.ordinal() + 1;
    }


    /**
     * Checks and return valid month by index
     *
     * @param idx month index
     * @return Month by index
     * @throws IllegalArgumentException in case {@code idx < 1 or idx > 12}
     */
    public static Month valueOf(int idx) {
        for (Month m : values()) {
            if (m.index() == idx) {
                return m;
            }
        }
        throw new IllegalArgumentException("Month should be between 1 and 12 but WAS:" + idx);
    }
}
