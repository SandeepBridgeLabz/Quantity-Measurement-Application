package com.bridgelab;

/**
 * Enum representing supported length units and their
 * conversion factors relative to the base unit (FEET).
 */
public enum  LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    /**
     * Returns conversion factor relative to feet.
     *
     * @return conversion factor
     */
    public double getConversionFactor() {
        return conversionFactor;
    }
}
