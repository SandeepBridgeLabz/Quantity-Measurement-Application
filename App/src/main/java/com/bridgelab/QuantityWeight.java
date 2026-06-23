package com.bridgelab;

import java.util.Objects;

public final class QuantityWeight {

    private static final double EPSILON = 0.000001;

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid weight value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    // Convert to another unit
    public QuantityWeight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityWeight(convertedValue, targetUnit);
    }

    // Add and return result in first operand's unit
    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    // Add and return result in specified target unit
    public QuantityWeight add(QuantityWeight other,
                              WeightUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Weight cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double firstInKg =
                unit.convertToBaseUnit(this.value);

        double secondInKg =
                other.unit.convertToBaseUnit(other.value);

        double sumInKg = firstInKg + secondInKg;

        double result =
                targetUnit.convertFromBaseUnit(sumInKg);

        return new QuantityWeight(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        QuantityWeight other = (QuantityWeight) obj;

        double thisKg =
                unit.convertToBaseUnit(this.value);

        double otherKg =
                other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisKg - otherKg) < EPSILON;
    }

    @Override
    public int hashCode() {

        double baseValue =
                unit.convertToBaseUnit(value);

        long rounded =
                Math.round(baseValue / EPSILON);

        return Objects.hash(rounded);
    }

    @Override
    public String toString() {
        return "QuantityWeight{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}