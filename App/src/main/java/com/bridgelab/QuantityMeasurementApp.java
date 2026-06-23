package com.bridgelab;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable>
    void demonstrateEquality(
            Quantity<U> q1,
            Quantity<U> q2) {

        System.out.println(
                q1 + " == " + q2 +
                        " : " + q1.equals(q2)
        );
    }

    public static <U extends IMeasurable>
    void demonstrateConversion(
            Quantity<U> q,
            U targetUnit) {

        System.out.println(
                q +
                        " -> " +
                        q.convertTo(targetUnit)
        );
    }

    public static <U extends IMeasurable>
    void demonstrateAddition(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        System.out.println(
                q1 +
                        " + " +
                        q2 +
                        " = " +
                        q1.add(q2, targetUnit)
        );
    }

    public static void main(String[] args) {

        // LENGTH

        Quantity<LengthUnit> foot =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(12.0,
                        LengthUnit.INCHES);

        demonstrateEquality(foot, inch);

        demonstrateConversion(
                foot,
                LengthUnit.INCHES);

        demonstrateAddition(
                foot,
                inch,
                LengthUnit.FEET);

        // WEIGHT

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        demonstrateEquality(kg, gram);

        demonstrateConversion(
                kg,
                WeightUnit.GRAM);

        demonstrateAddition(
                kg,
                gram,
                WeightUnit.KILOGRAM);

        // VOLUME (UC11)

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(1.0,
                        VolumeUnit.GALLON);

        demonstrateEquality(
                litre,
                ml);

        demonstrateConversion(
                litre,
                VolumeUnit.MILLILITRE);

        demonstrateConversion(
                gallon,
                VolumeUnit.LITRE);

        demonstrateAddition(
                litre,
                ml,
                VolumeUnit.LITRE);

        demonstrateAddition(
                gallon,
                litre,
                VolumeUnit.GALLON);
    }
}