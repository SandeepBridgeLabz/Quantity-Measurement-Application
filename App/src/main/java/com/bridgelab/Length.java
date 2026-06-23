package com.bridgelab;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    /**
     * Length units.
     * Conversion factors are relative to FEET.
     */
    public enum LengthUnit {

        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.0328084);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    /**
     * Constructor
     */
    public Length(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null.");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite.");
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
     * Convert current length to base unit (FEET).
     */
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    /**
     * Equality comparison in base unit.
     */
    private boolean compare(Length thatLength) {

        double thisFeet = this.convertToBaseUnit();
        double thatFeet = thatLength.convertToBaseUnit();

        double epsilon = 0.0001;

        return Math.abs(thisFeet - thatFeet) < epsilon;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (!(o instanceof Length))
            return false;

        Length that = (Length) o;

        return compare(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Math.round(convertToBaseUnit() * 10000));
    }

    /**
     * Convert length to target unit.
     */
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null.");
        }

        double lengthInFeet = convertToBaseUnit();

        double targetValue =
                lengthInFeet /
                        targetUnit.getConversionFactor();

        return new Length(targetValue, targetUnit);
    }

    /**
     * UC6
     * Add and return result in first operand's unit.
     */
    public Length add(Length thatLength) {

        if (thatLength == null) {
            throw new IllegalArgumentException(
                    "Length cannot be null.");
        }

        return addAndConvert(thatLength, this.unit);
    }

    /**
     * UC7
     * Add and return result in specified target unit.
     */
    public Length add(
            Length length,
            LengthUnit targetUnit) {

        if (length == null) {
            throw new IllegalArgumentException(
                    "Length cannot be null.");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null.");
        }

        return addAndConvert(length, targetUnit);
    }

    /**
     * Private utility method.
     */
    private Length addAndConvert(
            Length length,
            LengthUnit targetUnit) {

        double thisInFeet =
                this.convertToBaseUnit();

        double thatInFeet =
                length.convertToBaseUnit();

        double sumInFeet =
                thisInFeet + thatInFeet;

        double result =
                convertFromBaseToTargetUnit(
                        sumInFeet,
                        targetUnit);

        return new Length(result, targetUnit);
    }

    /**
     * Convert feet to target unit.
     */
    private double convertFromBaseToTargetUnit(
            double lengthInFeet,
            LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null.");
        }

        return lengthInFeet /
                targetUnit.getConversionFactor();
    }

    @Override
    public String toString() {
        return "Quantity(" +
                value +
                ", " +
                unit +
                ")";
    }

    public static void main(String[] args) {

        Length l1 =
                new Length(1, LengthUnit.FEET);

        Length l2 =
                new Length(12, LengthUnit.INCHES);

        System.out.println(
                l1.add(l2, LengthUnit.FEET));

        System.out.println(
                l1.add(l2, LengthUnit.INCHES));

        System.out.println(
                l1.add(l2, LengthUnit.YARDS));
    }
}