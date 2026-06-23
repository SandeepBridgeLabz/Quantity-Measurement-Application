package com.bridgelab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testFeetEquality() {
        assertEquals(
                new Length(1, LengthUnit.FEET),
                new Length(1, LengthUnit.FEET));
    }

    @Test
    void testInchesEquality() {
        assertEquals(
                new Length(12, LengthUnit.INCHES),
                new Length(12, LengthUnit.INCHES));
    }

    @Test
    void testFeetInchesComparison() {
        assertEquals(
                new Length(1, LengthUnit.FEET),
                new Length(12, LengthUnit.INCHES));
    }

    @Test
    void testFeetInequality() {
        assertNotEquals(
                new Length(1, LengthUnit.FEET),
                new Length(2, LengthUnit.FEET));
    }

    @Test
    void testInchesInequality() {
        assertNotEquals(
                new Length(12, LengthUnit.INCHES),
                new Length(24, LengthUnit.INCHES));
    }

    @Test
    void testCrossUnitInequality() {
        assertNotEquals(
                new Length(1, LengthUnit.FEET),
                new Length(1, LengthUnit.INCHES));
    }

    @Test
    void yardEquals36Inches() {
        assertEquals(
                new Length(1, LengthUnit.YARDS),
                new Length(36, LengthUnit.INCHES));
    }

    @Test
    void centimeterEqualsOneFoot() {
        assertEquals(
                new Length(30.48,
                        LengthUnit.CENTIMETERS),
                new Length(1,
                        LengthUnit.FEET));
    }

    @Test
    void threeFeetEqualsOneYard() {
        assertEquals(
                new Length(3,
                        LengthUnit.FEET),
                new Length(1,
                        LengthUnit.YARDS));
    }

    @Test
    void convertFeetToInches() {

        Length actual =
                new Length(1,
                        LengthUnit.FEET)
                        .convertTo(
                                LengthUnit.INCHES);

        assertEquals(
                new Length(12,
                        LengthUnit.INCHES),
                actual);
    }

    @Test
    void convertYardsToInches() {

        Length actual =
                new Length(1,
                        LengthUnit.YARDS)
                        .convertTo(
                                LengthUnit.INCHES);

        assertEquals(
                new Length(36,
                        LengthUnit.INCHES),
                actual);
    }

    @Test
    void addFeetAndInches() {

        Length actual =
                new Length(1,
                        LengthUnit.FEET)
                        .add(
                                new Length(
                                        12,
                                        LengthUnit.INCHES));

        assertEquals(
                new Length(2,
                        LengthUnit.FEET),
                actual);
    }

    @Test
    void addFeetAndInchesWithTargetUnit() {

        Length actual =
                new Length(1,
                        LengthUnit.FEET)
                        .add(
                                new Length(
                                        12,
                                        LengthUnit.INCHES),
                                LengthUnit.INCHES);

        assertEquals(
                new Length(24,
                        LengthUnit.INCHES),
                actual);
    }

    @Test
    void testLengthUnitFeetConstant() {
        assertEquals(
                1.0,
                LengthUnit.FEET.getConversionFactor());
    }

    @Test
    void testLengthUnitInchesConstant() {
        assertEquals(
                1.0 / 12.0,
                LengthUnit.INCHES.getConversionFactor(),
                0.01);
    }

    @Test
    void testLengthUnitYardsConstant() {
        assertEquals(
                3.0,
                LengthUnit.YARDS.getConversionFactor());
    }

    @Test
    void testLengthUnitCentimetersConstant() {
        assertEquals(
                1.0 / 30.48,
                LengthUnit.CENTIMETERS.getConversionFactor(),
                0.01);
    }

    @Test
    void testConvertToBaseUnitInchesToFeet() {
        assertEquals(
                1.0,
                LengthUnit.INCHES
                        .convertToBaseUnit(12),
                0.01);
    }

    @Test
    void testConvertFromBaseUnitFeetToInches() {
        assertEquals(
                12.0,
                LengthUnit.INCHES
                        .convertFromBaseUnit(1),
                0.01);
    }

    @Test
    void testNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(1, null));
    }

    @Test
    void testInvalidValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        Double.NaN,
                        LengthUnit.FEET));
    }
}