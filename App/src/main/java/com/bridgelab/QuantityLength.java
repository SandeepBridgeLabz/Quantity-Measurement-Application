package com.bridgelab;

import java.util.Objects;

public class QuantityLength {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Value must be finite");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * Converts the value to base unit (Feet)
     */
    private double toBaseUnit() {
        return value * unit.getConversionFactor();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof QuantityLength)) {
            return false;
        }

        QuantityLength other =
                (QuantityLength) obj;

        double thisBase =
                this.toBaseUnit();

        double otherBase =
                other.toBaseUnit();

        return Math.abs(
                thisBase - otherBase)
                < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Math.round(
                        toBaseUnit() / EPSILON));
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
