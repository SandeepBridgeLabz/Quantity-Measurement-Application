package com.bridgelab;

public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // Constructor to initialize length value and unit
    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }

        this.value = value;
        this.unit = unit;
    }

    // Convert the length value to the base unit (inches)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // Compare two Length objects for equality based on their values
    // in the base unit
    public boolean compare(Length thatLength) {

        if (thatLength == null) {
            return false;
        }

        return Double.compare(
                this.convertToBaseUnit(),
                thatLength.convertToBaseUnit()
        ) == 0;
    }

    // Equals method
    @Override
    public boolean equals(Object o) {

        // Same reference
        if (this == o) {
            return true;
        }

        // Null or different class
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // Cast and compare
        Length thatLength = (Length) o;
        return compare(thatLength);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }
}
