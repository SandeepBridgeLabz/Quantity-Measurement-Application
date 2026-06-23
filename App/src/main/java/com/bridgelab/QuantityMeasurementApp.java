package com.bridgelab;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        return length1.equals(length2);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    /**
     * UC6
     */
    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2) {

        return length1.add(length2);
    }

    /**
     * UC7
     */
    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2,
            Length.LengthUnit targetUnit) {

        if (length1 == null ||
                length2 == null ||
                targetUnit == null) {

            throw new IllegalArgumentException(
                    "Arguments cannot be null.");
        }

        return length1.add(
                length2,
                targetUnit);
    }

    public static void main(String[] args) {

        Length oneFoot =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET);

        Length twelveInches =
                new Length(
                        12.0,
                        Length.LengthUnit.INCHES);

        System.out.println(
                demonstrateLengthAddition(
                        oneFoot,
                        twelveInches,
                        Length.LengthUnit.FEET));

        System.out.println(
                demonstrateLengthAddition(
                        oneFoot,
                        twelveInches,
                        Length.LengthUnit.INCHES));

        System.out.println(
                demonstrateLengthAddition(
                        oneFoot,
                        twelveInches,
                        Length.LengthUnit.YARDS));

        System.out.println(
                demonstrateLengthAddition(
                        new Length(
                                1.0,
                                Length.LengthUnit.YARDS),
                        new Length(
                                3.0,
                                Length.LengthUnit.FEET),
                        Length.LengthUnit.YARDS));

        System.out.println(
                demonstrateLengthAddition(
                        new Length(
                                36.0,
                                Length.LengthUnit.INCHES),
                        new Length(
                                1.0,
                                Length.LengthUnit.YARDS),
                        Length.LengthUnit.FEET));

        System.out.println(
                demonstrateLengthAddition(
                        new Length(
                                2.54,
                                Length.LengthUnit.CENTIMETERS),
                        new Length(
                                1.0,
                                Length.LengthUnit.INCHES),
                        Length.LengthUnit.CENTIMETERS));

        System.out.println(
                demonstrateLengthAddition(
                        new Length(
                                5.0,
                                Length.LengthUnit.FEET),
                        new Length(
                                0.0,
                                Length.LengthUnit.INCHES),
                        Length.LengthUnit.YARDS));

        System.out.println(
                demonstrateLengthAddition(
                        new Length(
                                5.0,
                                Length.LengthUnit.FEET),
                        new Length(
                                -2.0,
                                Length.LengthUnit.FEET),
                        Length.LengthUnit.INCHES));
    }
}