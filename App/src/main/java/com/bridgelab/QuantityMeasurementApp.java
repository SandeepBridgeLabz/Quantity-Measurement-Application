package com.bridgelab;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityWeight kg =
                new QuantityWeight(1.0,
                        WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(1000.0,
                        WeightUnit.GRAM);

        QuantityWeight pound =
                new QuantityWeight(2.20462,
                        WeightUnit.POUND);

        // Equality
        System.out.println("1kg = 1000g : "
                + kg.equals(gram));

        System.out.println("1kg = 2.20462lb : "
                + kg.equals(pound));

        // Conversion
        System.out.println(
                kg.convertTo(WeightUnit.GRAM));

        System.out.println(
                gram.convertTo(WeightUnit.POUND));

        // Addition
        QuantityWeight result1 =
                kg.add(gram);

        System.out.println(
                "1kg + 1000g = "
                        + result1);

        QuantityWeight result2 =
                kg.add(gram,
                        WeightUnit.GRAM);

        System.out.println(
                "1kg + 1000g in grams = "
                        + result2);

        QuantityWeight result3 =
                new QuantityWeight(
                        2.0,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(
                                        4.0,
                                        WeightUnit.POUND),
                                WeightUnit.KILOGRAM);

        System.out.println(
                "2kg + 4lb = "
                        + result3);
    }
}