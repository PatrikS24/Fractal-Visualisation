package Logic;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public void setReal(double input) {real = input;}
    public void setImaginary(double input) {imaginary = input;}
    public double getReal() {return real;}
    public double getImaginary() {return imaginary;}
    public ComplexNumber i() {return new ComplexNumber(0, 1);}

    public ComplexNumber() {
        real = 0;
        imaginary = 0;
    }

    public ComplexNumber(double r, double i) {
        real = r;
        imaginary = i;
    }

    public static ComplexNumber add(ComplexNumber num1, ComplexNumber num2){
        ComplexNumber result = new ComplexNumber();
        result.real = num1.real + num2.real;
        result.imaginary = num1.imaginary + num2.imaginary;
        return result;
    }

    public static ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2){
        ComplexNumber result = new ComplexNumber();
        result.real = (num1.real * num2.real) + ((num1.imaginary * num2.imaginary) * -1);
        result.imaginary = num1.real * num2.imaginary + num2.real * num1.imaginary;
        return result;
    }

    public static ComplexNumber square(ComplexNumber num1){
        ComplexNumber result = new ComplexNumber();
        result.real = (num1.real * num1.real) + ((num1.imaginary * num1.imaginary) * -1);
        result.imaginary = num1.real * num1.imaginary + num1.real * num1.imaginary;
        return result;
    }

    // Distance from 0,0 to complex number
    public static double magnitude(ComplexNumber input) {
        return Math.sqrt(Math.pow(input.real, 2) + Math.pow(input.imaginary, 2));
    }

    public static ComplexNumber sin(ComplexNumber input) {
        double a = input.real;
        double b = input.imaginary;
        return new ComplexNumber(Math.sin(a) * Math.cosh(b), Math.cos(a) * Math.sinh(b));
    }

    public String toString() {
        return (String)(real + " +i" + imaginary);
    }
}
