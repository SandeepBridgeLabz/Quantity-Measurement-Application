package com.bridgelab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // FEET TESTS

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(
                QuantityMeasurementApp.areFeetEqual(1.0, 1.0));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(
                QuantityMeasurementApp.areFeetEqual(1.0, 2.0));
    }

    @Test
    void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals(null));
    }

    @Test
    void testFeetEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals("ABC"));
    }

    @Test
    void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet.equals(feet));
    }

    // INCHES TESTS

    @Test
    void testInchesEquality_SameValue() {
        assertTrue(
                QuantityMeasurementApp.areInchesEqual(1.0, 1.0));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        assertFalse(
                QuantityMeasurementApp.areInchesEqual(1.0, 2.0));
    }

    @Test
    void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inch.equals(null));
    }

    @Test
    void testInchesEquality_NonNumericInput() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inch.equals("ABC"));
    }

    @Test
    void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inch.equals(inch));
    }
}
