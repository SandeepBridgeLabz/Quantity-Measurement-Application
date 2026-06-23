package com.bridgelab;

public class Length {

    private static final double EPSILON = 0.0001;

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    private boolean compare(Length thatLength) {
        double thisInInches = this.convertToBaseUnit();
        double thatInInches = thatLength.convertToBaseUnit();

        return Math.abs(thisInInches - thatInInches) < EPSILON;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Length))
            return false;

        Length thatLength = (Length) obj;
        return compare(thatLength);
    }

    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double lengthInInches = convertToBaseUnit();

        double convertedValue =
                convertFromBaseToTargetUnit(lengthInInches, targetUnit);

        return new Length(convertedValue, targetUnit);
    }

    public Length add(Length thatLength) {

        if (thatLength == null) {
            throw new IllegalArgumentException(
                    "Second length cannot be null");
        }

        double thisInInches = this.convertToBaseUnit();
        double thatInInches = thatLength.convertToBaseUnit();

        double sumInInches = thisInInches + thatInInches;

        double result =
                convertFromBaseToTargetUnit(sumInInches, this.unit);

        return new Length(result, this.unit);
    }

    private double convertFromBaseToTargetUnit(
            double lengthInInches,
            LengthUnit targetUnit) {

        double converted =
                lengthInInches / targetUnit.getConversionFactor();

        return Math.round(converted * 100.0) / 100.0;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }

    public static void main(String[] args) {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result = length1.add(length2);

        System.out.println(result);
    }
}