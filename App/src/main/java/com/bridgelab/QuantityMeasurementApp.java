package com.bridgelab;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength yard =
                new QuantityLength(1, LengthUnit.YARD);

        QuantityLength feet =
                new QuantityLength(3, LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(36, LengthUnit.INCH);

        QuantityLength cm =
                new QuantityLength(1, LengthUnit.CENTIMETER);

        QuantityLength inch =
                new QuantityLength(0.393701, LengthUnit.INCH);

        System.out.println(yard.equals(feet));
        System.out.println(yard.equals(inches));
        System.out.println(cm.equals(inch));
    }
}