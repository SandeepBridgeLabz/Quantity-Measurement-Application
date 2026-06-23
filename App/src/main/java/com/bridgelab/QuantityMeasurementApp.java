package com.bridgelab;

import com.bridgelab.*;

public class QuantityMeasurementApp{

    public static boolean demonstrateLengthEquality(Length length1, Length length2){
        boolean result=length1.equals(length2);

        if(result)
            System.out.println("The two length measurements are equal.");
        else
            System.out.println("The two length measurements are not equal.");

        return result;
    }

    public static boolean demonstrateLengthComparison(double value1,Length.LengthUnit unit1,double value2,Length.LengthUnit unit2){
        Length length1=new Length(value1,unit1);
        Length length2=new Length(value2,unit2);

        return demonstrateLengthEquality(length1,length2);
    }

    public static Length demonstrateLengthConversion(double value,Length.LengthUnit fromUnit,Length.LengthUnit toUnit){
        Length length=new Length(value,fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length length,Length.LengthUnit toUnit){
        return length.convertTo(toUnit);
    }

    public static void main(String[] args){
        Length lengthInInches=demonstrateLengthConversion(3.0,Length.LengthUnit.FEET,Length.LengthUnit.INCHES);
        System.out.println(lengthInInches);

        Length lengthInYards=new Length(2.0,Length.LengthUnit.YARDS);
        Length converted=demonstrateLengthConversion(lengthInYards,Length.LengthUnit.INCHES);
        System.out.println(converted);
    }
}