package com.bridgelab;

/**
 * QuantityMeasurementAppUC3
 *
 * Demonstrates equality checks using
 * generic Length class.
 */
public class QuantityMeasurementApp {

    /**
     * Generic method to demonstrate
     * length equality.
     */
    public static boolean
    demonstrateLengthEquality(
            Length length1,
            Length length2) {

        return length1.equals(length2);
    }

    /**
     * Demonstrate feet equality.
     */
    public static void
    demonstrateFeetEquality() {

        Length feet1 =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length feet2 =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        System.out.println(
                "Feet Equality : "
                        + demonstrateLengthEquality(
                        feet1,
                        feet2
                )
        );
    }

    /**
     * Demonstrate inches equality.
     */
    public static void
    demonstrateInchesEquality() {

        Length inch1 =
                new Length(
                        1.0,
                        LengthUnit.INCH
                );

        Length inch2 =
                new Length(
                        1.0,
                        LengthUnit.INCH
                );

        System.out.println(
                "Inches Equality : "
                        + demonstrateLengthEquality(
                        inch1,
                        inch2
                )
        );
    }

    /**
     * Demonstrate feet and inches comparison.
     */
    public static void
    demonstrateFeetInchesComparison() {

        Length feet =
                new Length(
                        1.0,
                        LengthUnit.FEET
                );

        Length inches =
                new Length(
                        12.0,
                        LengthUnit.INCH
                );

        System.out.println(
                "Feet and Inches Equality : "
                        + demonstrateLengthEquality(
                        feet,
                        inches
                )
        );
    }

    /**
     * Main method.
     */
    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}