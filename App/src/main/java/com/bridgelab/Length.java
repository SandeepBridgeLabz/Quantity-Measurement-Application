package com.bridgelab;

/**
 * Generic Length class supporting
 * Feet, Inches, Yards and Centimeters.
 */
public class Length {

    private double value;
    private LengthUnit unit;
    private static final double EPSILON = 0.0001;

    /**
     * Constructor.
     */
    public Length(double value, LengthUnit unit) {

        if(unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    /**
     * Convert value to base unit (Inches).
     */
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    /**
     * Compare two Length objects.
     */
    public boolean compare(Length thatLength) {

        if(thatLength == null)
            return false;

        return Math.abs(
                this.convertToBaseUnit() -
                        thatLength.convertToBaseUnit()
        ) < EPSILON;
    }

    /**
     * Override equals().
     */
    @Override
    public boolean equals(Object o) {

        if(this == o)
            return true;

        if(o == null || getClass() != o.getClass())
            return false;

        Length thatLength = (Length) o;

        return compare(thatLength);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }
}