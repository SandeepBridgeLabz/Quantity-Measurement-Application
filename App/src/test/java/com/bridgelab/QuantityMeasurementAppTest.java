package com.bridgelab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testEquality_YardToYard_SameValue() {
        QuantityLength yard1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength yard2 = new QuantityLength(1.0, LengthUnit.YARD);

        assertEquals(yard1, yard2);
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        QuantityLength yard1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength yard2 = new QuantityLength(2.0, LengthUnit.YARD);

        assertNotEquals(yard1, yard2);
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);

        assertEquals(yard, feet);
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);

        assertEquals(feet, yard);
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);

        assertEquals(yard, inch);
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {
        QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);

        assertEquals(inch, yard);
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(2.0, LengthUnit.FEET);

        assertNotEquals(yard, feet);
    }

    @Test
    void testEquality_CentimeterToCentimeter_SameValue() {
        QuantityLength cm1 = new QuantityLength(2.0, LengthUnit.CENTIMETER);
        QuantityLength cm2 = new QuantityLength(2.0, LengthUnit.CENTIMETER);

        assertEquals(cm1, cm2);
    }

    @Test
    void testEquality_CentimeterToCentimeter_DifferentValue() {
        QuantityLength cm1 = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength cm2 = new QuantityLength(2.0, LengthUnit.CENTIMETER);

        assertNotEquals(cm1, cm2);
    }

    @Test
    void testEquality_CentimeterToInch_EquivalentValue() {
        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength inch = new QuantityLength(0.393701, LengthUnit.INCH);

        assertEquals(cm, inch);
    }

    @Test
    void testEquality_InchToCentimeter_EquivalentValue() {
        QuantityLength inch = new QuantityLength(0.393701, LengthUnit.INCH);
        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETER);

        assertEquals(inch, cm);
    }

    @Test
    void testEquality_CentimeterToFeet_NonEquivalentValue() {
        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);

        assertNotEquals(cm, feet);
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);

        assertEquals(yard, feet);
        assertEquals(feet, inch);
        assertEquals(yard, inch);
    }

    @Test
    void testEquality_AllUnits_ComplexScenario() {
        QuantityLength yard = new QuantityLength(2.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(6.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(72.0, LengthUnit.INCH);

        assertEquals(yard, feet);
        assertEquals(feet, inch);
        assertEquals(yard, inch);
    }

    @Test
    void testEquality_NullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null)
        );
    }

    @Test
    void testEquality_SameReference() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);

        assertEquals(yard, yard);
    }

    @Test
    void testEquality_NullComparison() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);

        assertNotEquals(yard, null);
    }

    @Test
    void testEquality_DifferentObjectType() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);

        assertNotEquals(yard, "1 Yard");
    }
}