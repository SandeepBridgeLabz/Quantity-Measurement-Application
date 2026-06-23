package com.bridgelab;

import java.util.Objects;

public final class Quantity<U extends IMeasurable> {

    private static final double EPSILON = 1e-6;

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null.");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value.");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null.");
        }

        double baseValue = unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(
                round(convertedValue),
                targetUnit
        );
    }

    public Quantity<U> add(Quantity<U> other) {

        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other,
                           U targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null."
            );
        }

        double first =
                this.unit.convertToBaseUnit(this.value);

        double second =
                other.unit.convertToBaseUnit(other.value);

        double sum = first + second;

        double result =
                targetUnit.convertFromBaseUnit(sum);

        return new Quantity<>(
                round(result),
                targetUnit
        );
    }

    private static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null ||
                getClass() != obj.getClass())
            return false;

        Quantity<?> other =
                (Quantity<?>) obj;

        if (this.unit.getClass()
                != other.unit.getClass()) {
            return false;
        }

        double first =
                this.unit.convertToBaseUnit(this.value);

        double second =
                other.unit.convertToBaseUnit(
                        other.value);

        return Math.abs(first - second)
                < EPSILON;
    }

    @Override
    public int hashCode() {

        double baseValue =
                unit.convertToBaseUnit(value);

        long rounded =
                Math.round(baseValue / EPSILON);

        return Objects.hash(
                unit.getClass(),
                rounded
        );
    }

    @Override
    public String toString() {
        return String.format(
                "Quantity(%.2f, %s)",
                value,
                unit.getUnitName()
        );
    }
}
