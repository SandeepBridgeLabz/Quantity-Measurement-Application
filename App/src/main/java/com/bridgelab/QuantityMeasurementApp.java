package com.bridgelab;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength feet =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength inch =
                new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(feet.equals(inch));

        QuantityLength inch1 =
                new QuantityLength(1.0, LengthUnit.INCH);

        QuantityLength inch2 =
                new QuantityLength(1.0, LengthUnit.INCH);

        System.out.println(inch1.equals(inch2));
    }
}