package com.bridgelab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {

        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);

        assertEquals(feet1, feet2);
    }

    @Test
    public void testInchesEquality() {

        Length inch1 = new Length(1.0, LengthUnit.INCH);
        Length inch2 = new Length(1.0, LengthUnit.INCH);

        assertEquals(inch1, inch2);
    }

    @Test
    public void testFeetInchesComparison() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCH);

        assertEquals(feet, inches);
    }

    @Test
    public void testYardEquality() {

        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(1.0, LengthUnit.YARDS);

        assertEquals(yard1, yard2);
    }

    @Test
    public void testYardToFeetComparison() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);

        assertEquals(yard, feet);
    }

    @Test
    public void testYardToInchesComparison() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCH);

        assertEquals(yard, inches);
    }

    @Test
    public void testCentimeterEquality() {

        Length cm1 = new Length(2.0, LengthUnit.CENTIMETERS);
        Length cm2 = new Length(2.0, LengthUnit.CENTIMETERS);

        assertEquals(cm1, cm2);
    }

    @Test
    public void testCentimeterToInchComparison() {

        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        Length inch = new Length(0.393701, LengthUnit.INCH);

        assertEquals(cm, inch);
    }

    @Test
    public void testCentimeterToFeetNotEqual() {

        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, LengthUnit.FEET);

        assertNotEquals(cm, feet);
    }

    @Test
    public void testTransitiveProperty() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inch = new Length(36.0, LengthUnit.INCH);

        assertEquals(yard, feet);
        assertEquals(feet, inch);
        assertEquals(yard, inch);
    }

    @Test
    public void testSameReference() {

        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertEquals(yard, yard);
    }

    @Test
    public void testNullComparison() {

        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertNotEquals(yard, null);
    }

    @Test
    public void testNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(1.0, null)
        );
    }

    @Test
    public void testComplexScenario() {

        Length yard = new Length(2.0, LengthUnit.YARDS);
        Length feet = new Length(6.0, LengthUnit.FEET);
        Length inch = new Length(72.0, LengthUnit.INCH);

        assertEquals(yard, feet);
        assertEquals(feet, inch);
        assertEquals(yard, inch);
    }

    @Test
    public void testDemonstrateMethod() {

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthComparison(
                                1.0,
                                LengthUnit.YARDS,
                                3.0,
                                LengthUnit.FEET
                        )
        );
    }
}