package task5;

/**
 * Enum class represents a weekday. It consists 7 days of weekday and can determine weekday by index {@link Weekday#valueOf(int)}.
 */

enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    /**
     * Return real weekday index (e.g. MONDAY=1, SUNDAY=7)
     *
     * @return index of weekday
     */
    public int index() {
        return this.ordinal() + 1;
    }

    /**
     * Checks and return valid weekday by index
     *
     * @param idx weekday index
     * @return Weekday by index
     * @throws IllegalArgumentException in case {@code idx < 1 or idx > 7}
     */
    public static Weekday valueOf(int idx) {
        for (Weekday w : values()) {
            if (w.index() == idx) {
                return w;
            }
        }
        throw new IllegalArgumentException("Weekday should be between 1 and 7 but WAS: " + idx);
    }
}