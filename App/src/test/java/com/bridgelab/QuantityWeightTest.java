package com.bridgelab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityWeightTest {

    @Test
    void testEquality_KgToKg() {
        assertTrue(
                new QuantityWeight(
                        1,
                        WeightUnit.KILOGRAM)
                        .equals(
                                new QuantityWeight(
                                        1,
                                        WeightUnit.KILOGRAM)));
    }

    @Test
    void testEquality_KgToGram() {
        assertTrue(
                new QuantityWeight(
                        1,
                        WeightUnit.KILOGRAM)
                        .equals(
                                new QuantityWeight(
                                        1000,
                                        WeightUnit.GRAM)));
    }

    @Test
    void testEquality_KgToPound() {
        assertTrue(
                new QuantityWeight(
                        1,
                        WeightUnit.KILOGRAM)
                        .equals(
                                new QuantityWeight(
                                        2.20462,
                                        WeightUnit.POUND)));
    }

    @Test
    void testConvertKgToGram() {

        QuantityWeight result =
                new QuantityWeight(
                        1,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.GRAM);

        assertEquals(
                1000,
                result.getValue(),
                0.0001);
    }

    @Test
    void testConvertPoundToKg() {

        QuantityWeight result =
                new QuantityWeight(
                        2,
                        WeightUnit.POUND)
                        .convertTo(
                                WeightUnit.KILOGRAM);

        assertEquals(
                0.907184,
                result.getValue(),
                0.0001);
    }

    @Test
    void testAddition_KgPlusKg() {

        QuantityWeight result =
                new QuantityWeight(
                        1,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(
                                        2,
                                        WeightUnit.KILOGRAM));

        assertEquals(
                3,
                result.getValue(),
                0.0001);
    }

    @Test
    void testAddition_KgPlusGram() {

        QuantityWeight result =
                new QuantityWeight(
                        1,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(
                                        1000,
                                        WeightUnit.GRAM));

        assertEquals(
                2,
                result.getValue(),
                0.0001);
    }

    @Test
    void testAddition_ExplicitTargetUnit() {

        QuantityWeight result =
                new QuantityWeight(
                        1,
                        WeightUnit.KILOGRAM)
                        .add(
                                new QuantityWeight(
                                        1000,
                                        WeightUnit.GRAM),
                                WeightUnit.GRAM);

        assertEquals(
                2000,
                result.getValue(),
                0.0001);
    }

    @Test
    void testNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityWeight(
                        1,
                        null));
    }

    @Test
    void testRoundTripConversion() {

        QuantityWeight result =
                new QuantityWeight(
                        1.5,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.GRAM)
                        .convertTo(
                                WeightUnit.KILOGRAM);

        assertEquals(
                1.5,
                result.getValue(),
                0.0001);
    }
}