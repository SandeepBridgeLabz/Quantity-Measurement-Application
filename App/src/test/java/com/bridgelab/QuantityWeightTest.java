package com.bridgelab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityWeightTest {

    private static final double EPSILON = 0.01;

    // =====================================================
    // IMeasurable Interface Tests
    // =====================================================

    @Test
    void testIMeasurableInterface_LengthUnitImplementation() {
        IMeasurable unit = LengthUnit.FEET;

        assertEquals("FEET", unit.getUnitName());
        assertEquals(1.0,
                unit.getConversionFactor(),
                EPSILON);
    }

    @Test
    void testIMeasurableInterface_WeightUnitImplementation() {
        IMeasurable unit = WeightUnit.KILOGRAM;

        assertEquals("KILOGRAM",
                unit.getUnitName());

        assertEquals(1.0,
                unit.getConversionFactor(),
                EPSILON);
    }

    // =====================================================
    // LENGTH EQUALITY TESTS (UC1-UC8)
    // =====================================================

    @Test
    void testEquality_FeetToFeet_SameValue() {
        assertEquals(
                new Quantity<>(1, LengthUnit.FEET),
                new Quantity<>(1, LengthUnit.FEET)
        );
    }

    @Test
    void testEquality_FeetToInches() {
        assertEquals(
                new Quantity<>(1, LengthUnit.FEET),
                new Quantity<>(12,
                        LengthUnit.INCHES)
        );
    }

    @Test
    void testEquality_FeetToYards() {
        assertEquals(
                new Quantity<>(3, LengthUnit.FEET),
                new Quantity<>(1,
                        LengthUnit.YARDS)
        );
    }

    @Test
    void testEquality_FeetToCentimeters() {
        assertEquals(
                new Quantity<>(1,
                        LengthUnit.FEET),
                new Quantity<>(30.48,
                        LengthUnit.CENTIMETERS)
        );
    }

    // =====================================================
    // WEIGHT EQUALITY TESTS (UC9)
    // =====================================================

    @Test
    void testEquality_KilogramToKilogram() {
        assertEquals(
                new Quantity<>(1,
                        WeightUnit.KILOGRAM),
                new Quantity<>(1,
                        WeightUnit.KILOGRAM)
        );
    }

    @Test
    void testEquality_KilogramToGram() {
        assertEquals(
                new Quantity<>(1,
                        WeightUnit.KILOGRAM),
                new Quantity<>(1000,
                        WeightUnit.GRAM)
        );
    }

    @Test
    void testEquality_GramToKilogram() {
        assertEquals(
                new Quantity<>(1000,
                        WeightUnit.GRAM),
                new Quantity<>(1,
                        WeightUnit.KILOGRAM)
        );
    }

    @Test
    void testEquality_KilogramToPound() {
        assertEquals(
                new Quantity<>(1,
                        WeightUnit.KILOGRAM),
                new Quantity<>(2.20462,
                        WeightUnit.POUND)
        );
    }

    @Test
    void testEquality_GramToPound() {
        assertEquals(
                new Quantity<>(453.592,
                        WeightUnit.GRAM),
                new Quantity<>(1,
                        WeightUnit.POUND)
        );
    }

    // =====================================================
    // CONVERSION TESTS
    // =====================================================

    @Test
    void testConversion_FeetToInches() {
        Quantity<LengthUnit> result =
                new Quantity<>(1,
                        LengthUnit.FEET)
                        .convertTo(
                                LengthUnit.INCHES);

        assertEquals(12,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testConversion_KgToGram() {
        Quantity<WeightUnit> result =
                new Quantity<>(1,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.GRAM);

        assertEquals(1000,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testConversion_PoundToKilogram() {
        Quantity<WeightUnit> result =
                new Quantity<>(2.20462,
                        WeightUnit.POUND)
                        .convertTo(
                                WeightUnit.KILOGRAM);

        assertEquals(1,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testConversion_RoundTrip() {
        Quantity<WeightUnit> result =
                new Quantity<>(1.5,
                        WeightUnit.KILOGRAM)
                        .convertTo(
                                WeightUnit.GRAM)
                        .convertTo(
                                WeightUnit.KILOGRAM);

        assertEquals(1.5,
                result.getValue(),
                EPSILON);
    }

    // =====================================================
    // ADDITION TESTS
    // =====================================================

    @Test
    void testAddition_SameLengthUnits() {
        assertEquals(
                new Quantity<>(3,
                        LengthUnit.FEET),

                new Quantity<>(1,
                        LengthUnit.FEET)
                        .add(
                                new Quantity<>(2,
                                        LengthUnit.FEET)
                        )
        );
    }

    @Test
    void testAddition_CrossLengthUnits() {
        assertEquals(
                new Quantity<>(2,
                        LengthUnit.FEET),

                new Quantity<>(1,
                        LengthUnit.FEET)
                        .add(
                                new Quantity<>(12,
                                        LengthUnit.INCHES)
                        )
        );
    }

    @Test
    void testAddition_KgPlusGram() {
        assertEquals(
                new Quantity<>(2,
                        WeightUnit.KILOGRAM),

                new Quantity<>(1,
                        WeightUnit.KILOGRAM)
                        .add(
                                new Quantity<>(1000,
                                        WeightUnit.GRAM)
                        )
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit() {

        Quantity<WeightUnit> result =
                new Quantity<>(1,
                        WeightUnit.KILOGRAM)
                        .add(
                                new Quantity<>(1000,
                                        WeightUnit.GRAM),
                                WeightUnit.GRAM
                        );

        assertEquals(2000,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_PoundPlusKilogram() {

        Quantity<WeightUnit> result =
                new Quantity<>(2.20462,
                        WeightUnit.POUND)
                        .add(
                                new Quantity<>(1,
                                        WeightUnit.KILOGRAM),
                                WeightUnit.POUND
                        );

        assertEquals(4.41,
                result.getValue(),
                EPSILON);
    }

    // =====================================================
    // EQUALS CONTRACT TESTS
    // =====================================================

    @Test
    void testEquality_NullComparison() {
        Quantity<LengthUnit> quantity =
                new Quantity<>(1,
                        LengthUnit.FEET);

        assertNotEquals(quantity,
                null);
    }

    @Test
    void testEquality_SameReference() {
        Quantity<WeightUnit> quantity =
                new Quantity<>(1,
                        WeightUnit.KILOGRAM);

        assertEquals(quantity,
                quantity);
    }

    @Test
    void testEquality_DifferentValue() {
        assertNotEquals(
                new Quantity<>(1,
                        WeightUnit.KILOGRAM),

                new Quantity<>(2,
                        WeightUnit.KILOGRAM)
        );
    }

    // =====================================================
    // HASHCODE TESTS
    // =====================================================

    @Test
    void testHashCode_Consistency() {
        Quantity<LengthUnit> q1 =
                new Quantity<>(1,
                        LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12,
                        LengthUnit.INCHES);

        assertEquals(
                q1.hashCode(),
                q2.hashCode()
        );
    }

    // =====================================================
    // VALIDATION TESTS
    // =====================================================

    @Test
    void testConstructor_NullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(1,
                        null)
        );
    }

    @Test
    void testConstructor_NaNValue() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(
                        Double.NaN,
                        LengthUnit.FEET)
        );
    }

    @Test
    void testConstructor_InfiniteValue() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(
                        Double.POSITIVE_INFINITY,
                        LengthUnit.FEET)
        );
    }

    // =====================================================
    // EDGE CASES
    // =====================================================

    @Test
    void testZeroValue() {
        assertEquals(
                new Quantity<>(0,
                        WeightUnit.KILOGRAM),

                new Quantity<>(0,
                        WeightUnit.GRAM)
        );
    }

    @Test
    void testNegativeValue() {
        assertEquals(
                new Quantity<>(-1,
                        WeightUnit.KILOGRAM),

                new Quantity<>(-1000,
                        WeightUnit.GRAM)
        );
    }

    @Test
    void testLargeValue() {
        assertEquals(
                new Quantity<>(1_000_000,
                        WeightUnit.GRAM),

                new Quantity<>(1000,
                        WeightUnit.KILOGRAM)
        );
    }

    @Test
    void testSmallValue() {
        assertEquals(
                new Quantity<>(0.001,
                        WeightUnit.KILOGRAM),

                new Quantity<>(1,
                        WeightUnit.GRAM)
        );
    }

    // =====================================================
    // SCALABILITY TEST (UC10)
    // =====================================================

    enum VolumeUnit implements IMeasurable {

        LITER(1.0),
        MILLILITER(0.001);

        private final double factor;

        VolumeUnit(double factor) {
            this.factor = factor;
        }

        @Override
        public double getConversionFactor() {
            return factor;
        }

        @Override
        public double convertToBaseUnit(double value) {
            return value * factor;
        }

        @Override
        public double convertFromBaseUnit(double baseValue) {
            return baseValue / factor;
        }

        @Override
        public String getUnitName() {
            return name();
        }
    }

    @Test
    void testScalability_NewCategory() {

        Quantity<VolumeUnit> liter =
                new Quantity<>(1,
                        VolumeUnit.LITER);

        Quantity<VolumeUnit> ml =
                new Quantity<>(1000,
                        VolumeUnit.MILLILITER);

        assertEquals(liter, ml);
    }
}