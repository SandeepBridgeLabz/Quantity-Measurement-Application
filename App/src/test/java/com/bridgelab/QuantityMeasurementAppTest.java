package com.bridgelab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuantityMeasurementAppTest {

    @Test
    void testEquality_SameValue() {
        // Given
        QuantityMeasurementApp.Feet feet1 =
                new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 =
                new QuantityMeasurementApp.Feet(1.0);

        // When & Then
        assertTrue(feet1.equals(feet2),
                "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    void testEquality_DifferentValue() {
        // Given
        QuantityMeasurementApp.Feet feet1 =
                new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 =
                new QuantityMeasurementApp.Feet(2.0);

        // When & Then
        assertFalse(feet1.equals(feet2),
                "1.0 ft should not be equal to 2.0 ft");
    }

    @Test
    void testEquality_NullComparison() {
        // Given
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        // When & Then
        assertFalse(feet.equals(null),
                "Feet object should not be equal to null");
    }

    @Test
    void testEquality_NonNumericInput() {
        // Given
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        // When & Then
        assertFalse(feet.equals("1.0"),
                "Feet object should not be equal to a String");
    }

    @Test
    void testEquality_SameReference() {
        // Given
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        // When & Then
        assertTrue(feet.equals(feet),
                "Object should be equal to itself");
    }
}