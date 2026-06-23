package com.bridgelab;

import java.util.Objects;

public class Length {

    private static final double EPSILON = 0.01;

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Length that = (Length) obj;

        double thisBase = convertToBaseUnit();
        double thatBase = that.convertToBaseUnit();

        return Math.abs(thisBase - thatBase) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }

    /**
     * Convert to target unit
     */
    public Length convertTo(LengthUnit targetUnit) {

        double baseValue = convertToBaseUnit();
        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        return new Length(convertedValue, targetUnit);
    }

    /**
     * Add and return result in current unit
     */
    public Length add(Length thatLength) {
        return add(thatLength, this.unit);
    }

    /**
     * Add and return result in specified target unit
     */
    public Length add(Length length,
                      LengthUnit targetUnit) {

        return addAndConvert(length, targetUnit);
    }

    private Length addAndConvert(Length length,
                                 LengthUnit targetUnit) {

        double first = this.convertToBaseUnit();
        double second = length.convertToBaseUnit();

        double total = first + second;

        double converted =
                targetUnit.convertFromBaseUnit(total);

        return new Length(converted, targetUnit);
    }

    /**
     * Delegates conversion to enum
     */
    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    /**
     * Delegates conversion to enum
     */
    private double convertFromBaseToTargetUnit(
            double baseValue,
            LengthUnit targetUnit) {

        return targetUnit.convertFromBaseUnit(baseValue);
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public static void main(String[] args) {

        Length oneFoot =
                new Length(1, LengthUnit.FEET);

        Length twelveInches =
                new Length(12, LengthUnit.INCHES);

        System.out.println(oneFoot.equals(twelveInches));

        System.out.println(
                oneFoot.convertTo(LengthUnit.INCHES));

        System.out.println(
                oneFoot.add(twelveInches));

        System.out.println(
                oneFoot.add(
                        twelveInches,
                        LengthUnit.YARDS));
    }
}