package com.bridgelab;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        boolean result = length1.equals(length2);

        if (result)
            System.out.println(
                    "The two length measurements are equal.");
        else
            System.out.println(
                    "The two length measurements are not equal.");

        return result;
    }

    public static boolean demonstrateLengthComparison(
            Length length1,
            Length length2) {

        return demonstrateLengthEquality(length1, length2);
    }

    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit targetUnit) {

        return length.convertTo(targetUnit);
    }

    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2) {

        return length1.add(length2);
    }

    public static void main(String[] args) {

        Length length1 =
                new Length(1.0, Length.LengthUnit.FEET);

        Length length2 =
                new Length(12.0, Length.LengthUnit.INCHES);

        Length result =
                demonstrateLengthAddition(length1, length2);

        System.out.println(result);
    }
}