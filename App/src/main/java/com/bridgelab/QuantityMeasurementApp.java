package com.bridgelab;


/**
 * Application class demonstrating
 * length comparison and conversion.
 */
public class QuantityMeasurementApp {

    /**
     * Overloaded Method #1
     *
     * Converts raw value
     */
    public static void demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toUnit) {

        double result =
                QuantityLength.convert(
                        value,
                        fromUnit,
                        toUnit);

        System.out.println(
                value + " " + fromUnit
                        + " = "
                        + result + " "
                        + toUnit);
    }

    /**
     * Overloaded Method #2
     *
     * Converts existing object.
     */
    public static void demonstrateLengthConversion(
            QuantityLength length,
            LengthUnit toUnit) {

        QuantityLength converted =
                length.convertTo(toUnit);

        System.out.println(
                length + " = "
                        + converted);
    }

    /**
     * Demonstrates equality.
     */
    public static void demonstrateLengthEquality(
            QuantityLength first,
            QuantityLength second) {

        System.out.println(
                first + " and "
                        + second
                        + " are equal : "
                        + first.equals(second));
    }

    /**
     * Demonstrates comparison.
     */
    public static void demonstrateLengthComparison(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2) {

        QuantityLength length1 =
                new QuantityLength(
                        value1,
                        unit1);

        QuantityLength length2 =
                new QuantityLength(
                        value2,
                        unit2);

        demonstrateLengthEquality(
                length1,
                length2);
    }

    /**
     * Main method for standalone testing.
     */
    public static void main(String[] args) {

        System.out.println(
                "===== Unit Conversion =====");

        demonstrateLengthConversion(
                1.0,
                LengthUnit.FEET,
                LengthUnit.INCHES);

        demonstrateLengthConversion(
                3.0,
                LengthUnit.YARDS,
                LengthUnit.FEET);

        demonstrateLengthConversion(
                36.0,
                LengthUnit.INCHES,
                LengthUnit.YARDS);

        demonstrateLengthConversion(
                2.54,
                LengthUnit.CENTIMETERS,
                LengthUnit.INCHES);

        System.out.println();

        System.out.println(
                "===== Object Conversion =====");

        QuantityLength length =
                new QuantityLength(
                        1.0,
                        LengthUnit.YARDS);

        demonstrateLengthConversion(
                length,
                LengthUnit.INCHES);

        System.out.println();

        System.out.println(
                "===== Equality Tests =====");

        demonstrateLengthComparison(
                1.0,
                LengthUnit.FEET,
                12.0,
                LengthUnit.INCHES);

        demonstrateLengthComparison(
                1.0,
                LengthUnit.YARDS,
                3.0,
                LengthUnit.FEET);

        demonstrateLengthComparison(
                2.54,
                LengthUnit.CENTIMETERS,
                1.0,
                LengthUnit.INCHES);
    }
}