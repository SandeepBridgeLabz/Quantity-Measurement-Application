package com.bridgelab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

    // =========================================================
    // UC1–UC10 LENGTH TESTS
    // =========================================================

    @Test
    void testLengthEquality_FeetToInches() {
        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    void testLengthConversion_FeetToInches() {
        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), EPSILON);
    }

    @Test
    void testLengthAddition() {
        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(new Quantity<>(12.0,
                                        LengthUnit.INCHES),
                                LengthUnit.FEET);

        assertEquals(2.0,
                result.getValue(),
                EPSILON);
    }

    // =========================================================
    // UC9–UC10 WEIGHT TESTS
    // =========================================================

    @Test
    void testWeightEquality_KgToGram() {
        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    void testWeightConversion_KgToGram() {
        Quantity<WeightUnit> result =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(1000.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testWeightAddition() {
        Quantity<WeightUnit> result =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM)
                        .add(
                                new Quantity<>(1000.0,
                                        WeightUnit.GRAM),
                                WeightUnit.KILOGRAM);

        assertEquals(2.0,
                result.getValue(),
                EPSILON);
    }

    // =========================================================
    // UC11 VOLUME EQUALITY TESTS
    // =========================================================

    @Test
    void testEquality_LitreToLitre_SameValue() {
        assertEquals(
                new Quantity<>(1.0,
                        VolumeUnit.LITRE),
                new Quantity<>(1.0,
                        VolumeUnit.LITRE)
        );
    }

    @Test
    void testEquality_LitreToLitre_DifferentValue() {
        assertNotEquals(
                new Quantity<>(1.0,
                        VolumeUnit.LITRE),
                new Quantity<>(2.0,
                        VolumeUnit.LITRE)
        );
    }

    @Test
    void testEquality_LitreToMillilitre_EquivalentValue() {
        assertEquals(
                new Quantity<>(1.0,
                        VolumeUnit.LITRE),
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE)
        );
    }

    @Test
    void testEquality_MillilitreToLitre_EquivalentValue() {
        assertEquals(
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE),
                new Quantity<>(1.0,
                        VolumeUnit.LITRE)
        );
    }

    @Test
    void testEquality_GallonToLitre_EquivalentValue() {
        assertEquals(
                new Quantity<>(1.0,
                        VolumeUnit.GALLON),
                new Quantity<>(3.78541,
                        VolumeUnit.LITRE)
        );
    }

    @Test
    void testEquality_NullComparison() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        assertFalse(litre.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        assertEquals(litre, litre);
    }

    @Test
    void testEquality_ZeroValue() {
        assertEquals(
                new Quantity<>(0.0,
                        VolumeUnit.LITRE),
                new Quantity<>(0.0,
                        VolumeUnit.MILLILITRE)
        );
    }

    @Test
    void testEquality_NegativeVolume() {
        assertEquals(
                new Quantity<>(-1.0,
                        VolumeUnit.LITRE),
                new Quantity<>(-1000.0,
                        VolumeUnit.MILLILITRE)
        );
    }

    @Test
    void testEquality_LargeVolumeValue() {
        assertEquals(
                new Quantity<>(1000000.0,
                        VolumeUnit.MILLILITRE),
                new Quantity<>(1000.0,
                        VolumeUnit.LITRE)
        );
    }

    // =========================================================
    // UC11 CONVERSION TESTS
    // =========================================================

    @Test
    void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE)
                        .convertTo(
                                VolumeUnit.MILLILITRE);

        assertEquals(1000.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testConversion_MillilitreToLitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE)
                        .convertTo(
                                VolumeUnit.LITRE);

        assertEquals(1.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1.0,
                        VolumeUnit.GALLON)
                        .convertTo(
                                VolumeUnit.LITRE);

        assertEquals(3.78541,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testConversion_LitreToGallon() {
        Quantity<VolumeUnit> result =
                new Quantity<>(3.78541,
                        VolumeUnit.LITRE)
                        .convertTo(
                                VolumeUnit.GALLON);

        assertEquals(1.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testConversion_RoundTrip() {
        Quantity<VolumeUnit> original =
                new Quantity<>(1.5,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                original.convertTo(
                                VolumeUnit.MILLILITRE)
                        .convertTo(
                                VolumeUnit.LITRE);

        assertEquals(
                original.getValue(),
                result.getValue(),
                EPSILON
        );
    }

    // =========================================================
    // UC11 ADDITION TESTS
    // =========================================================

    @Test
    void testAddition_SameUnit_LitrePlusLitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE)
                        .add(
                                new Quantity<>(2.0,
                                        VolumeUnit.LITRE));

        assertEquals(3.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_CrossUnit_LitrePlusMillilitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE)
                        .add(
                                new Quantity<>(1000.0,
                                        VolumeUnit.MILLILITRE));

        assertEquals(2.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Millilitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE)
                        .add(
                                new Quantity<>(1000.0,
                                        VolumeUnit.MILLILITRE),
                                VolumeUnit.MILLILITRE);

        assertEquals(2000.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Gallon() {
        Quantity<VolumeUnit> result =
                new Quantity<>(3.78541,
                        VolumeUnit.LITRE)
                        .add(
                                new Quantity<>(3.78541,
                                        VolumeUnit.LITRE),
                                VolumeUnit.GALLON);

        assertEquals(2.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_WithZero() {
        Quantity<VolumeUnit> result =
                new Quantity<>(5.0,
                        VolumeUnit.LITRE)
                        .add(
                                new Quantity<>(0.0,
                                        VolumeUnit.MILLILITRE));

        assertEquals(5.0,
                result.getValue(),
                EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        Quantity<VolumeUnit> result =
                new Quantity<>(5.0,
                        VolumeUnit.LITRE)
                        .add(
                                new Quantity<>(-2000.0,
                                        VolumeUnit.MILLILITRE));

        assertEquals(3.0,
                result.getValue(),
                EPSILON);
    }

    // =========================================================
    // UC11 ENUM TESTS
    // =========================================================

    @Test
    void testVolumeUnitEnum_LitreConstant() {
        assertEquals(
                1.0,
                VolumeUnit.LITRE
                        .getConversionFactor(),
                EPSILON
        );
    }

    @Test
    void testVolumeUnitEnum_MillilitreConstant() {
        assertEquals(
                0.001,
                VolumeUnit.MILLILITRE
                        .getConversionFactor(),
                EPSILON
        );
    }

    @Test
    void testVolumeUnitEnum_GallonConstant() {
        assertEquals(
                3.78541,
                VolumeUnit.GALLON
                        .getConversionFactor(),
                EPSILON
        );
    }

    @Test
    void testConvertToBaseUnit_MillilitreToLitre() {
        assertEquals(
                1.0,
                VolumeUnit.MILLILITRE
                        .convertToBaseUnit(1000.0),
                EPSILON
        );
    }

    @Test
    void testConvertToBaseUnit_GallonToLitre() {
        assertEquals(
                3.78541,
                VolumeUnit.GALLON
                        .convertToBaseUnit(1.0),
                EPSILON
        );
    }

    @Test
    void testConvertFromBaseUnit_LitreToMillilitre() {
        assertEquals(
                1000.0,
                VolumeUnit.MILLILITRE
                        .convertFromBaseUnit(1.0),
                EPSILON
        );
    }

    @Test
    void testConvertFromBaseUnit_LitreToGallon() {
        assertEquals(
                1.0,
                VolumeUnit.GALLON
                        .convertFromBaseUnit(3.78541),
                EPSILON
        );
    }

    // =========================================================
    // CROSS CATEGORY TESTS
    // =========================================================

    @Test
    void testVolumeVsLength_Incompatible() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<LengthUnit> foot =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        assertFalse(litre.equals(foot));
    }

    @Test
    void testVolumeVsWeight_Incompatible() {
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        assertFalse(litre.equals(kg));
    }

    // =========================================================
    // VALIDATION TESTS
    // =========================================================

    @Test
    void testConstructor_NullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null)
        );
    }

    @Test
    void testConstructor_InvalidValue() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(
                        Double.NaN,
                        VolumeUnit.LITRE)
        );
    }
}