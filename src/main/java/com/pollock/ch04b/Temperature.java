package com.pollock.ch04b;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Temperature {
    private String inputTemp;
    private boolean FToC;

    private String convertedTemp;
    private final String DEFAULT_NUM = "0";

    public Temperature(String inputTemp, boolean FToC) {
        validateTemp(inputTemp);
        this.inputTemp = inputTemp;
        this.FToC = FToC;
        convertTemp();
    }

    public Temperature(boolean FToC) {
        this.FToC = FToC;
        inputTemp = DEFAULT_NUM;
        convertTemp();
    }

    public String getInputTemp() {
        return inputTemp;
    }

    public void setInputTemp(String inputTemp) {
        validateTemp(inputTemp);
        this.inputTemp = inputTemp;
    }

    public boolean isFToC() {
        return FToC;
    }

    public void setFToC(boolean FToC) {
        this.FToC = FToC;
    }

    private void convertTemp(){
        String result = "";

        BigDecimal temp = new BigDecimal(inputTemp);

        if(FToC){
            try {
                convertedTemp = temp.subtract(new BigDecimal(32.0)).multiply(new BigDecimal(5.0)).divide(new BigDecimal(9.0)).toPlainString();
            }
            catch(ArithmeticException ex){
                convertedTemp = temp.subtract(new BigDecimal(32.0)).multiply(new BigDecimal(5.0)).divide(new BigDecimal(9.0), 3, RoundingMode.HALF_UP).toPlainString();
            }
        } else {
            try {
                convertedTemp = temp.multiply(new BigDecimal(9).divide(new BigDecimal(5))).add(new BigDecimal(32)).toPlainString();
            } catch (ArithmeticException ex) {
                convertedTemp = temp.multiply(new BigDecimal(9).divide(new BigDecimal(5), 3, RoundingMode.HALF_UP)).add(new BigDecimal(32)).toPlainString();
            }
        }
    }

    private void validateTemp(String temp){
        try{
            // temp is short for temperature, dTemp is short for Double temp
            Double dTemp = Double.parseDouble(temp);
            if((FToC && dTemp < -459.67) || (!FToC && dTemp < -273.15)){
                throw new IllegalArgumentException("Cannot accept a temperature this low.");
            }
        } catch(NumberFormatException ex){
            throw new IllegalArgumentException("Invalid number");
        }
    }

    public String toString(){
        String result = "";

        if(FToC){
            result = "(" + inputTemp + "°F − 32) × 5/9 = " + convertedTemp + "°C";
        } else{
            result = "(" + inputTemp + "°C * 9/5) + 32 = " + convertedTemp + "°F";
        }

        return result;
    }
}
