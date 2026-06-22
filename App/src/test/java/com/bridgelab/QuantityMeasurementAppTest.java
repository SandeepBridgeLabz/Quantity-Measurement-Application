package com.bridgelab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    private static final double EPSILON = 1e-6;

    // FEET -> INCHES
    @Test
    void testConversion_FeetToInches() {
        double result = QuantityLength.convert(
                1.0,
                LengthUnit.FEET,
                LengthUnit.INCHES
        );

        assertEquals(12.0, result, EPSILON);
    }

    // INCHES -> FEET
    @Test
    void testConversion_InchesToFeet() {
        double result = QuantityLength.convert(
                24.0,
                LengthUnit.INCHES,
                LengthUnit.FEET
        );

        assertEquals(2.0, result, EPSILON);
    }

    // YARDS -> INCHES
    @Test
    void testConversion_YardsToInches() {
        double result = QuantityLength.convert(
                1.0,
                LengthUnit.YARDS,
                LengthUnit.INCHES
        );

        assertEquals(36.0, result, EPSILON);
    }

    // INCHES -> YARDS
    @Test
    void testConversion_InchesToYards() {
        double result = QuantityLength.convert(
                72.0,
                LengthUnit.INCHES,
                LengthUnit.YARDS
        );

        assertEquals(2.0, result, EPSILON);
    }

    // CENTIMETERS -> INCHES
    @Test
    void testConversion_CentimetersToInches() {
        double result = QuantityLength.convert(
                2.54,
                LengthUnit.CENTIMETERS,
                LengthUnit.INCHES
        );

        assertEquals(1.0, result, EPSILON);
    }

    // FEET -> YARDS
    @Test
    void testConversion_FeetToYards() {
        double result = QuantityLength.convert(
                6.0,
                LengthUnit.FEET,
                LengthUnit.YARDS
        );

        assertEquals(2.0, result, EPSILON);
    }

    // Zero Value
    @Test
    void testConversion_ZeroValue() {
        double result = QuantityLength.convert(
                0.0,
                LengthUnit.FEET,
                LengthUnit.INCHES
        );

        assertEquals(0.0, result, EPSILON);
    }

    // Negative Value
    @Test
    void testConversion_NegativeValue() {
        double result = QuantityLength.convert(
                -1.0,
                LengthUnit.FEET,
                LengthUnit.INCHES
        );

        assertEquals(-12.0, result, EPSILON);
    }

    // Same Unit Conversion
    @Test
    void testConversion_SameUnit() {
        double result = QuantityLength.convert(
                5.0,
                LengthUnit.FEET,
                LengthUnit.FEET
        );

        assertEquals(5.0, result, EPSILON);
    }

    // Round Trip Conversion
    @Test
    void testConversion_RoundTrip_PreservesValue() {

        double original = 10.0;

        double inches = QuantityLength.convert(
                original,
                LengthUnit.FEET,
                LengthUnit.INCHES
        );

        double feet = QuantityLength.convert(
                inches,
                LengthUnit.INCHES,
                LengthUnit.FEET
        );

        assertEquals(original, feet, EPSILON);
    }

    // NaN Validation
    @Test
    void testConversion_NaN_Throws() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        Double.NaN,
                        LengthUnit.FEET,
                        LengthUnit.INCHES
                )
        );
    }

    // Positive Infinity Validation
    @Test
    void testConversion_PositiveInfinity_Throws() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        Double.POSITIVE_INFINITY,
                        LengthUnit.FEET,
                        LengthUnit.INCHES
                )
        );
    }

    // Negative Infinity Validation
    @Test
    void testConversion_NegativeInfinity_Throws() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        Double.NEGATIVE_INFINITY,
                        LengthUnit.FEET,
                        LengthUnit.INCHES
                )
        );
    }

    // Null Source Unit
    @Test
    void testConversion_NullSourceUnit_Throws() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        1.0,
                        null,
                        LengthUnit.INCHES
                )
        );
    }

    // Null Target Unit
    @Test
    void testConversion_NullTargetUnit_Throws() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityLength.convert(
                        1.0,
                        LengthUnit.FEET,
                        null
                )
        );
    }

    // Equality Test
    @Test
    void testEquals_SameLengthDifferentUnits() {

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityLength inches =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES
                );

        assertEquals(feet, inches);
    }

    // Not Equal
    @Test
    void testEquals_DifferentLengths() {

        QuantityLength oneFoot =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityLength twoFeet =
                new QuantityLength(
                        2.0,
                        LengthUnit.FEET
                );

        assertNotEquals(oneFoot, twoFeet);
    }

    // convertTo() Method
    @Test
    void testConvertTo_ReturnsNewObject() {

        QuantityLength length =
                new QuantityLength(
                        1.0,
                        LengthUnit.YARDS
                );

        QuantityLength converted =
                length.convertTo(
                        LengthUnit.INCHES
                );

        assertEquals(
                36.0,
                converted.getValue(),
                EPSILON
        );

        assertEquals(
                LengthUnit.INCHES,
                converted.getUnit()
        );
    }

    // Large Value Conversion
    @Test
    void testConversion_LargeValue() {
        double result = QuantityLength.convert(
                1_000_000,
                LengthUnit.FEET,
                LengthUnit.INCHES
        );

        assertEquals(
                12_000_000,
                result,
                EPSILON
        );
    }

    // Small Value Conversion
    @Test
    void testConversion_SmallValue() {
        double result = QuantityLength.convert(
                0.0001,
                LengthUnit.FEET,
                LengthUnit.INCHES
        );

        assertEquals(
                0.0012,
                result,
                EPSILON
        );
    }

    // toString()
    @Test
    void testToString() {

        QuantityLength length =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        assertEquals(
                "1.00 FEET",
                length.toString()
        );
    }
}