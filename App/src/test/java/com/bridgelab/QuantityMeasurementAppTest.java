package com.bridgelab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class QuantityMeasurementAppTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {

        QuantityLength q1 =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(1, LengthUnit.FEET);

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_InchToInch_SameValue() {

        QuantityLength q1 =
                new QuantityLength(1, LengthUnit.INCH);

        QuantityLength q2 =
                new QuantityLength(1, LengthUnit.INCH);

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {

        QuantityLength q1 =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(12, LengthUnit.INCH);

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {

        QuantityLength q1 =
                new QuantityLength(12, LengthUnit.INCH);

        QuantityLength q2 =
                new QuantityLength(1, LengthUnit.FEET);

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue() {

        QuantityLength q1 =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(2, LengthUnit.FEET);

        assertNotEquals(q1, q2);
    }

    @Test
    void testEquality_InchToInch_DifferentValue() {

        QuantityLength q1 =
                new QuantityLength(1, LengthUnit.INCH);

        QuantityLength q2 =
                new QuantityLength(2, LengthUnit.INCH);

        assertNotEquals(q1, q2);
    }

    @Test
    void testEquality_SameReference() {

        QuantityLength q1 =
                new QuantityLength(1, LengthUnit.FEET);

        assertEquals(q1, q1);
    }

    @Test
    void testEquality_NullComparison() {

        QuantityLength q1 =
                new QuantityLength(1, LengthUnit.FEET);

        assertNotEquals(q1, null);
    }

    @Test
    void testEquality_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(1, null)
        );
    }
}