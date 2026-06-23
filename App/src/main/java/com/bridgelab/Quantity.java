package com.bridgelab;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

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

        double baseValue = unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(convertedValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other,
                           U targetUnit) {

        double base1 =
                unit.convertToBaseUnit(value);

        double base2 =
                other.unit.convertToBaseUnit(other.value);

        double sum = base1 + base2;

        double converted =
                targetUnit.convertFromBaseUnit(sum);

        converted =
                Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(converted, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Quantity<?>))
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (unit.getClass() !=
                other.unit.getClass())
            return false;

        double base1 =
                unit.convertToBaseUnit(value);

        double base2 =
                other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2)
                < EPSILON;
    }

    @Override
    public int hashCode() {

        double base =
                unit.convertToBaseUnit(value);

        return Objects.hash(
                Math.round(base * 10000)
        );
    }

    @Override
    public String toString() {
        return "Quantity(" +
                value +
                ", " +
                unit.getUnitName() +
                ")";
    }
}