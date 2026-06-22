package com.bridgelab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class QuantityLengthAdditionTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength length1 =
                new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength length2 =
                new QuantityLength(2.0, LengthUnit.FEET);

        QuantityLength result = length1.add(length2);

        assertEquals(3.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_SameUnit_InchPlusInch() {
        QuantityLength length1 =
                new QuantityLength(6.0, LengthUnit.INCHES);
        QuantityLength length2 =
                new QuantityLength(6.0, LengthUnit.INCHES);

        QuantityLength result = length1.add(length2);

        assertEquals(12.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength feet =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = feet.add(inches);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength inches =
                new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength feet =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength result = inches.add(feet);

        assertEquals(24.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_YardPlusFeet() {
        QuantityLength yards =
                new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength feet =
                new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength result = yards.add(feet);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_CentimeterPlusInch() {
        QuantityLength cm =
                new QuantityLength(2.54,
                        LengthUnit.CENTIMETERS);

        QuantityLength inch =
                new QuantityLength(1.0,
                        LengthUnit.INCHES);

        QuantityLength result = cm.add(inch);

        assertEquals(5.08,
                result.getValue(),
                EPSILON);

        assertEquals(
                LengthUnit.CENTIMETERS,
                result.getUnit());
    }

    @Test
    void testAddition_Commutativity() {

        QuantityLength feet =
                new QuantityLength(1.0,
                        LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(12.0,
                        LengthUnit.INCHES);

        QuantityLength result1 =
                feet.add(inches);

        QuantityLength result2 =
                inches.add(feet);

        assertEquals(result1, result2);
    }

    @Test
    void testAddition_WithZero() {

        QuantityLength feet =
                new QuantityLength(5.0,
                        LengthUnit.FEET);

        QuantityLength zero =
                new QuantityLength(0.0,
                        LengthUnit.INCHES);

        QuantityLength result =
                feet.add(zero);

        assertEquals(5.0,
                result.getValue(),
                EPSILON);

        assertEquals(
                LengthUnit.FEET,
                result.getUnit());
    }

    @Test
    void testAddition_NegativeValues() {

        QuantityLength length1 =
                new QuantityLength(5.0,
                        LengthUnit.FEET);

        QuantityLength length2 =
                new QuantityLength(-2.0,
                        LengthUnit.FEET);

        QuantityLength result =
                length1.add(length2);

        assertEquals(3.0,
                result.getValue(),
                EPSILON);

        assertEquals(
                LengthUnit.FEET,
                result.getUnit());
    }

    @Test
    void testAddition_NullSecondOperand() {

        QuantityLength length =
                new QuantityLength(1.0,
                        LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> length.add(null)
        );
    }

    @Test
    void testAddition_LargeValues() {

        QuantityLength length1 =
                new QuantityLength(1_000_000,
                        LengthUnit.FEET);

        QuantityLength length2 =
                new QuantityLength(1_000_000,
                        LengthUnit.FEET);

        QuantityLength result =
                length1.add(length2);

        assertEquals(
                2_000_000,
                result.getValue(),
                EPSILON);

        assertEquals(
                LengthUnit.FEET,
                result.getUnit());
    }

    @Test
    void testAddition_SmallValues() {

        QuantityLength length1 =
                new QuantityLength(0.001,
                        LengthUnit.FEET);

        QuantityLength length2 =
                new QuantityLength(0.002,
                        LengthUnit.FEET);

        QuantityLength result =
                length1.add(length2);

        assertEquals(
                0.003,
                result.getValue(),
                EPSILON);

        assertEquals(
                LengthUnit.FEET,
                result.getUnit());
    }

    @Test
    void testAddition_ResultIsNewObject() {

        QuantityLength length1 =
                new QuantityLength(1.0,
                        LengthUnit.FEET);

        QuantityLength length2 =
                new QuantityLength(12.0,
                        LengthUnit.INCHES);

        QuantityLength result =
                length1.add(length2);

        assertNotSame(length1, result);
        assertNotSame(length2, result);
    }

    @Test
    void testAddition_DoesNotModifyOriginalObjects() {

        QuantityLength length1 =
                new QuantityLength(1.0,
                        LengthUnit.FEET);

        QuantityLength length2 =
                new QuantityLength(12.0,
                        LengthUnit.INCHES);

        length1.add(length2);

        assertEquals(
                1.0,
                length1.getValue(),
                EPSILON);

        assertEquals(
                LengthUnit.FEET,
                length1.getUnit());

        assertEquals(
                12.0,
                length2.getValue(),
                EPSILON);

        assertEquals(
                LengthUnit.INCHES,
                length2.getUnit());
    }
}