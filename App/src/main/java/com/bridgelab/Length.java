package com.bridgelab;

public class Length{
    private double value;
    private LengthUnit unit;

    public enum LengthUnit{
        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor){
            this.conversionFactor=conversionFactor;
        }

        public double getConversionFactor(){
            return conversionFactor;
        }
    }

    public Length(double value,LengthUnit unit){
        if(unit==null)
            throw new IllegalArgumentException("Unit cannot be null");
        if(!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value=value;
        this.unit=unit;
    }

    public double getValue(){
        return value;
    }

    public LengthUnit getUnit(){
        return unit;
    }

    private double convertToBaseUnit(){
        return Math.round(value*unit.getConversionFactor()*100.0)/100.0;
    }

    private boolean compare(Length thatLength){
        return this.convertToBaseUnit()==thatLength.convertToBaseUnit();
    }

    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;

        if(o==null||getClass()!=o.getClass())
            return false;

        Length thatLength=(Length)o;
        return compare(thatLength);
    }

    public Length convertTo(LengthUnit targetUnit){
        if(targetUnit==null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue=value*unit.getConversionFactor();
        double convertedValue=baseValue/targetUnit.getConversionFactor();
        convertedValue=Math.round(convertedValue*100.0)/100.0;

        return new Length(convertedValue,targetUnit);
    }

    @Override
    public String toString(){
        return String.format("%.2f %s",value,unit);
    }

    public static void main(String[] args){
        Length length1=new Length(1.0,LengthUnit.FEET);
        Length length2=length1.convertTo(LengthUnit.INCHES);

        System.out.println(length1);
        System.out.println(length2);
    }
}