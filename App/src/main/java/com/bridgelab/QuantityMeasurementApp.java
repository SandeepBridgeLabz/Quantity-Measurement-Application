package com.bridgelab;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable>
    void demonstrateEquality(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(
                q1 + " equals " + q2
                        + " : "
                        + q1.equals(q2)
        );
    }

    public static <U extends IMeasurable>
    void demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit) {

        System.out.println(
                quantity
                        + " -> "
                        + quantity.convertTo(targetUnit)
        );
    }

    public static <U extends IMeasurable>
    void demonstrateAddition(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        System.out.println(
                q1
                        + " + "
                        + q2
                        + " = "
                        + q1.add(q2, targetUnit)
        );
    }

    public static void main(String[] args) {

        // LENGTH
        Quantity<LengthUnit> foot =
                new Quantity<>(1,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(12,
                        LengthUnit.INCHES);

        demonstrateEquality(
                foot,
                inch
        );

        demonstrateConversion(
                foot,
                LengthUnit.INCHES
        );

        demonstrateAddition(
                foot,
                inch,
                LengthUnit.FEET
        );

        System.out.println();

        // WEIGHT
        Quantity<WeightUnit> kg =
                new Quantity<>(1,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000,
                        WeightUnit.GRAM);

        demonstrateEquality(
                kg,
                gram
        );

        demonstrateConversion(
                kg,
                WeightUnit.GRAM
        );

        demonstrateAddition(
                kg,
                gram,
                WeightUnit.KILOGRAM
        );
    }
}