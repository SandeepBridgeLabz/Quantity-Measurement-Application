package com.bridgelab;

import com.bridgelab.QuantityMeasurementApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest{

    @Test
    public void testFeetEquality(){
        Length length1=new Length(1.0,Length.LengthUnit.FEET);
        Length length2=new Length(1.0,Length.LengthUnit.FEET);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void testInchesEquality(){
        Length length1=new Length(12.0,Length.LengthUnit.INCHES);
        Length length2=new Length(12.0,Length.LengthUnit.INCHES);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void testFeetInchesComparison(){
        Length length1=new Length(1.0,Length.LengthUnit.FEET);
        Length length2=new Length(12.0,Length.LengthUnit.INCHES);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void testFeetInequality(){
        Length length1=new Length(1.0,Length.LengthUnit.FEET);
        Length length2=new Length(2.0,Length.LengthUnit.FEET);

        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void testInchesInequality(){
        Length length1=new Length(12.0,Length.LengthUnit.INCHES);
        Length length2=new Length(24.0,Length.LengthUnit.INCHES);

        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void testCrossUnitInequality(){
        Length length1=new Length(1.0,Length.LengthUnit.FEET);
        Length length2=new Length(24.0,Length.LengthUnit.INCHES);

        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void yardEquals36Inches(){
        Length length1=new Length(1.0,Length.LengthUnit.YARDS);
        Length length2=new Length(36.0,Length.LengthUnit.INCHES);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void centimeterEquals39Point3701Inches(){
        Length length1=new Length(100.0,Length.LengthUnit.CENTIMETERS);
        Length length2=new Length(39.37,Length.LengthUnit.INCHES);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void convertFeetToInches(){
        Length lengthInInches=QuantityMeasurementApp.demonstrateLengthConversion(3.0,Length.LengthUnit.FEET,Length.LengthUnit.INCHES);
        Length expectedLength=new Length(36.0,Length.LengthUnit.INCHES);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches,expectedLength));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod(){
        Length lengthInYards=new Length(2.0,Length.LengthUnit.YARDS);
        Length lengthInInches=QuantityMeasurementApp.demonstrateLengthConversion(lengthInYards,Length.LengthUnit.INCHES);
        Length expectedLength=new Length(72.0,Length.LengthUnit.INCHES);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches,expectedLength));
    }

    @Test
    public void threeFeetEqualsOneYard(){
        Length length1=new Length(3.0,Length.LengthUnit.FEET);
        Length length2=new Length(1.0,Length.LengthUnit.YARDS);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot(){
        Length length1=new Length(30.48,Length.LengthUnit.CENTIMETERS);
        Length length2=new Length(1.0,Length.LengthUnit.FEET);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void yardNotEqualToInches(){
        Length length1=new Length(1.0,Length.LengthUnit.YARDS);
        Length length2=new Length(24.0,Length.LengthUnit.INCHES);

        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1,length2));
    }

    @Test
    public void referenceEqualitySameObject(){
        Length length1=new Length(1.0,Length.LengthUnit.FEET);

        assertEquals(length1,length1);
    }

    @Test
    public void equalsReturnsFalseForNull(){
        Length length1=new Length(1.0,Length.LengthUnit.FEET);

        assertFalse(length1.equals(null));
    }
}