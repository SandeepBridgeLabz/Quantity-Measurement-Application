package com.bridgelab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.001;

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {

        Length result =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET)
                        .add(
                                new Length(
                                        12.0,
                                        Length.LengthUnit.INCHES),
                                Length.LengthUnit.FEET);

        assertEquals(
                new Length(
                        2.0,
                        Length.LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {

        Length result =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET)
                        .add(
                                new Length(
                                        12.0,
                                        Length.LengthUnit.INCHES),
                                Length.LengthUnit.INCHES);

        assertEquals(
                24.0,
                result.getValue(),
                EPSILON);

        assertEquals(
                Length.LengthUnit.INCHES,
                result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {

        Length result =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET)
                        .add(
                                new Length(
                                        12.0,
                                        Length.LengthUnit.INCHES),
                                Length.LengthUnit.YARDS);

        assertEquals(
                0.6666667,
                result.getValue(),
                EPSILON);

        assertEquals(
                Length.LengthUnit.YARDS,
                result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {

        Length result =
                new Length(
                        1.0,
                        Length.LengthUnit.INCHES)
                        .add(
                                new Length(
                                        1.0,
                                        Length.LengthUnit.INCHES),
                                Length.LengthUnit.CENTIMETERS);

        assertEquals(
                5.08,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Commutativity() {

        Length a =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET);

        Length b =
                new Length(
                        12.0,
                        Length.LengthUnit.INCHES);

        Length r1 =
                a.add(
                        b,
                        Length.LengthUnit.YARDS);

        Length r2 =
                b.add(
                        a,
                        Length.LengthUnit.YARDS);

        assertEquals(r1, r2);
    }

    @Test
    void testAddition_ExplicitTargetUnit_WithZero() {

        Length result =
                new Length(
                        5.0,
                        Length.LengthUnit.FEET)
                        .add(
                                new Length(
                                        0.0,
                                        Length.LengthUnit.INCHES),
                                Length.LengthUnit.YARDS);

        assertEquals(
                1.6667,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_NegativeValues() {

        Length result =
                new Length(
                        5.0,
                        Length.LengthUnit.FEET)
                        .add(
                                new Length(
                                        -2.0,
                                        Length.LengthUnit.FEET),
                                Length.LengthUnit.INCHES);

        assertEquals(
                36.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_NullTargetUnit() {

        Length l1 =
                new Length(
                        1.0,
                        Length.LengthUnit.FEET);

        Length l2 =
                new Length(
                        12.0,
                        Length.LengthUnit.INCHES);

        assertThrows(
                IllegalArgumentException.class,
                () -> l1.add(l2, null));
    }

    @Test
    void testAddition_ExplicitTargetUnit_LargeToSmallScale() {

        Length result =
                new Length(
                        1000.0,
                        Length.LengthUnit.FEET)
                        .add(
                                new Length(
                                        500.0,
                                        Length.LengthUnit.FEET),
                                Length.LengthUnit.INCHES);

        assertEquals(
                18000.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_SmallToLargeScale() {

        Length result =
                new Length(
                        12.0,
                        Length.LengthUnit.INCHES)
                        .add(
                                new Length(
                                        12.0,
                                        Length.LengthUnit.INCHES),
                                Length.LengthUnit.YARDS);

        assertEquals(
                0.6666667,
                result.getValue(),
                EPSILON);
    }
}