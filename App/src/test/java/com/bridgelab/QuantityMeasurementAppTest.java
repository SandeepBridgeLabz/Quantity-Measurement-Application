package com.bridgelab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {

        Length length1 =
                new Length(1.0, LengthUnit.FEET);

        Length length2 =
                new Length(1.0, LengthUnit.FEET);

        assertEquals(length1, length2);
    }

    @Test
    void testEquality_InchToInch_SameValue() {

        Length length1 =
                new Length(1.0, LengthUnit.INCH);

        Length length2 =
                new Length(1.0, LengthUnit.INCH);

        assertEquals(length1, length2);
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {

        Length length1 =
                new Length(1.0, LengthUnit.FEET);

        Length length2 =
                new Length(12.0, LengthUnit.INCH);

        assertEquals(length1, length2);
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {

        Length length1 =
                new Length(12.0, LengthUnit.INCH);

        Length length2 =
                new Length(1.0, LengthUnit.FEET);

        assertEquals(length1, length2);
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue() {

        Length length1 =
                new Length(1.0, LengthUnit.FEET);

        Length length2 =
                new Length(2.0, LengthUnit.FEET);

        assertNotEquals(length1, length2);
    }

    @Test
    void testEquality_InchToInch_DifferentValue() {

        Length length1 =
                new Length(1.0, LengthUnit.INCH);

        Length length2 =
                new Length(2.0, LengthUnit.INCH);

        assertNotEquals(length1, length2);
    }

    @Test
    void testEquality_SameReference() {

        Length length =
                new Length(1.0, LengthUnit.FEET);

        assertEquals(length, length);
    }

    @Test
    void testEquality_NullComparison() {

        Length length =
                new Length(1.0, LengthUnit.FEET);

        assertNotEquals(length, null);
    }

    @Test
    void testEquality_DifferentType() {

        Length length =
                new Length(1.0, LengthUnit.FEET);

        String str = "Length";

        assertNotEquals(length, str);
    }

    @Test
    void testEquality_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(1.0, null)
        );
    }

    @Test
    void testEquality_NaNValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        Double.NaN,
                        LengthUnit.FEET
                )
        );
    }

    @Test
    void testEquality_PositiveInfinity() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        Double.POSITIVE_INFINITY,
                        LengthUnit.FEET
                )
        );
    }

    @Test
    void testEquality_NegativeInfinity() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Length(
                        Double.NEGATIVE_INFINITY,
                        LengthUnit.FEET
                )
        );
    }

    @Test
    void testDemonstrateLengthEquality() {

        Length feet =
                new Length(1.0, LengthUnit.FEET);

        Length inches =
                new Length(12.0, LengthUnit.INCH);

        assertTrue(
                QuantityMeasurementApp
                        .demonstrateLengthEquality(
                                feet,
                                inches
                        )
        );
    }
}