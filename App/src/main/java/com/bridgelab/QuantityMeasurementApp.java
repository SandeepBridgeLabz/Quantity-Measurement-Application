package com.bridgelab;

/**
 * QuantityMeasurementAppUC4
 *
 * Demonstrates extended unit support.
 */
public class QuantityMeasurementApp {

    /**
     * Generic equality method.
     */
    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        return length1.equals(length2);
    }

    /**
     * Generic comparison method.
     */
    public static boolean demonstrateLengthComparison(
            double value1,
            LengthUnit unit1,
            double value2,
            LengthUnit unit2) {

        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);

        boolean result =
                demonstrateLengthEquality(length1, length2);

        System.out.println(
                value1 + " " + unit1 +
                        " == " +
                        value2 + " " + unit2 +
                        " : " + result
        );

        return result;
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {

        demonstrateLengthComparison(
                1.0, LengthUnit.FEET,
                12.0, LengthUnit.INCH
        );

        demonstrateLengthComparison(
                1.0, LengthUnit.YARDS,
                36.0, LengthUnit.INCH
        );

        demonstrateLengthComparison(
                1.0, LengthUnit.YARDS,
                3.0, LengthUnit.FEET
        );

        demonstrateLengthComparison(
                1.0, LengthUnit.CENTIMETERS,
                0.393701, LengthUnit.INCH
        );

        demonstrateLengthComparison(
                30.48, LengthUnit.CENTIMETERS,
                1.0, LengthUnit.FEET
        );
    }
}