package com.bridgelab;

import java.util.Objects;

/**
 * Immutable value object representing a length measurement.
 */
public final class QuantityLength {

    private static final double EPSILON = 1e-6;

    private final double value;
    private final LengthUnit unit;

    /**
     * Creates a QuantityLength object.
     *
     * @param value length value
     * @param unit length unit
     */
    public QuantityLength(double value, LengthUnit unit) {
        validateValue(value);
        validateUnit(unit);

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * Static conversion API.
     *
     * @param value source value
     * @param source source unit
     * @param target target unit
     * @return converted value
     */
    public static double convert(
            double value,
            LengthUnit source,
            LengthUnit target) {

        validateValue(value);
        validateUnit(source);
        validateUnit(target);

        double baseValue = toBaseUnit(value, source);

        return fromBaseUnit(baseValue, target);
    }

    /**
     * Converts this object into target unit.
     *
     * @param targetUnit desired unit
     * @return new QuantityLength object
     */
    public QuantityLength convertTo(LengthUnit targetUnit) {

        validateUnit(targetUnit);

        double convertedValue =
                convert(this.value, this.unit, targetUnit);

        return new QuantityLength(
                convertedValue,
                targetUnit
        );
    }

    /**
     * Converts value to base unit (feet).
     */
    private static double toBaseUnit(
            double value,
            LengthUnit sourceUnit) {

        return value * sourceUnit.getConversionFactor();
    }

    /**
     * Converts from base unit (feet)
     * to target unit.
     */
    private static double fromBaseUnit(
            double baseValue,
            LengthUnit targetUnit) {

        return baseValue /
                targetUnit.getConversionFactor();
    }

    /**
     * Validates numeric value.
     */
    private static void validateValue(double value) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException(
                    "Value must be finite."
            );
        }
    }

    /**
     * Validates unit.
     */
    private static void validateUnit(
            LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null."
            );
        }
    }

    /**
     * Equality based on physical length,
     * not unit representation.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof QuantityLength))
            return false;

        QuantityLength other =
                (QuantityLength) obj;

        double thisBase =
                toBaseUnit(
                        this.value,
                        this.unit);

        double otherBase =
                toBaseUnit(
                        other.value,
                        other.unit);

        return Math.abs(
                thisBase - otherBase)
                < EPSILON;
    }

    @Override
    public int hashCode() {

        double base =
                toBaseUnit(
                        value,
                        unit);

        long rounded =
                Math.round(base / EPSILON);

        return Objects.hash(rounded);
    }

    /**
     * Human-readable representation.
     */
    @Override
    public String toString() {
        return String.format(
                "%.2f %s",
                value,
                unit
        );
    }
    public QuantityLength add(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Length cannot be null.");
        }

        double thisBase =
                this.value *
                        this.unit.getConversionFactor();

        double otherBase =
                other.value *
                        other.unit.getConversionFactor();

        double sumBase =
                thisBase + otherBase;

        double resultValue =
                sumBase /
                        this.unit.getConversionFactor();

        return new QuantityLength(
                resultValue,
                this.unit
        );
    }
}